package com.anvil.rakoi.anvil.restController;

import antlr.StringUtils;
import com.anvil.rakoi.anvil.entities.*;
import com.anvil.rakoi.anvil.entities.Pojos.IntenalPushRequest;
import com.anvil.rakoi.anvil.repos.ParcelRepository;
import com.anvil.rakoi.anvil.repos.StationRepository;
import com.anvil.rakoi.anvil.security.MyUserDetails;
import com.anvil.rakoi.anvil.services.ClientServiceImp;
import com.anvil.rakoi.anvil.services.MpesaTransactionsImpl;
import com.anvil.rakoi.anvil.services.SmsSender;
import com.anvil.rakoi.anvil.util.StringFunctions;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.anvil.rakoi.anvil.services.ParcelServiceImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.ServletContext;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/parcel")
public class ParcelRestController {

	@Autowired
	ParcelServiceImpl parcelServiceImpl;
	@Autowired
	ClientServiceImp clientServiceImp;
	@Autowired
	ParcelServiceImpl parcelService;

	@Autowired
	StationRepository stationRepository;

	@Autowired
	ParcelRepository parcelRepository;

	@Autowired
	MpesaTransactionsImpl mpesaTransactionsRepository;




	@Autowired
	public ServletContext context;

	@Autowired
	public SmsSender smsService;


	@GetMapping("/all")
	public Page<Parcel> getallParcels(Pageable pageable) {
		System.out.println("GETTING PARCELS");
		return parcelServiceImpl.getAllParcel(pageable);
	}

	@GetMapping("/getParcel/{id}")
	public ResponseEntity<Parcel> getParcel(@PathVariable("id") int id) {
		
		try {
			Parcel parcel= parcelServiceImpl.getParcelById(id);
			return ResponseEntity.ok().body(parcel);
		}catch(Exception e) {

			return ResponseEntity.notFound().build();
		}
		
	}

	@GetMapping("/deleteParcel/{id}")
	public ResponseEntity<?> deleteParcel(@PathVariable("id") int id) {
		parcelServiceImpl.DeleteParcel(id);
		return new ResponseEntity<>("Success",HttpStatus.OK);
	}
	@GetMapping("/findByOrigin")
	public ResponseEntity<?> findByOrigin(@RequestParam(value = "sort",defaultValue = "id") String search,
										  @RequestParam(value = "per_page", defaultValue = "10") Integer limit,
										  @RequestParam(value = "page", defaultValue = "0") Integer page) {

		int length=search.length();
		PageRequest pageable=null;
		if(length>3) {
			String column = search.substring(0, length - 4);

			 pageable =PageRequest.of(page, limit, Sort.by(column));
		}else{


				pageable = PageRequest.of(page, limit, Sort.by(search));

		}

		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int station_id=userDetails.getUserStation();
		Optional<Station> station=stationRepository.findById(station_id);
		Page<Parcel> outgoing = parcelServiceImpl.findSentParcels(station.get(), pageable);

		return new ResponseEntity<>(outgoing,HttpStatus.OK);
	}
	@GetMapping("/findAllByOrigin")
	public ResponseEntity<?> findByOrigin(Pageable pageable) {
		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int station_id=userDetails.getUserStation();
		Optional<Station> station=stationRepository.findById(station_id);
		System.out.println(station_id);
		return new ResponseEntity<>(parcelRepository.findAllByOrigin(station.get(),pageable),HttpStatus.OK);
	}
	@GetMapping("/findUncollected")
	public ResponseEntity<?> findMyUncollected( Pageable pageable) {




		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int station_id=userDetails.getUserStation();
		Optional<Station> station=stationRepository.findById(station_id);
		Page<Parcel> uncollected = parcelServiceImpl.findUncollected(station.get(), pageable);

		return new ResponseEntity<>(uncollected,HttpStatus.OK);
	}	@GetMapping("/findAllUncollected")
	public ResponseEntity<?> findUncollected(Pageable pageable) {


		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int station_id=userDetails.getUserStation();
		Optional<Station> station=stationRepository.findById(station_id);

		return new ResponseEntity<>(parcelRepository.findAllByCollectedFalseAndDestination(station.get(),pageable),HttpStatus.OK);
	}


	@GetMapping("/incoming")
	public ResponseEntity<?> getMyincoming(Pageable pageable) {




		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int station_id=userDetails.getUserStation();
		Optional<Station> station=stationRepository.findById(station_id);
		Page<Parcel> incoming = parcelServiceImpl.findByDestination(station.get(), pageable);

		return new ResponseEntity<>(incoming,HttpStatus.OK);
	}
	@GetMapping("/allincoming")
	public ResponseEntity<?> getincoming(Pageable pageable) {


		MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int station_id=userDetails.getUserStation();
		Optional<Station> station=stationRepository.findById(station_id);

		return new ResponseEntity<>(parcelRepository.findAllByDestination(station.get(),pageable),HttpStatus.OK);
	}


	@PostMapping("/addParcel")
	public ResponseEntity<?> addParcel(@RequestBody JSONObject saveParcelEntity) throws JsonProcessingException {
		Gson gson = new Gson();
		String parcelJson=new Gson().toJson(saveParcelEntity.get("parcel"));
		Parcel parcel=gson.fromJson(parcelJson,Parcel.class);



		String senderJson=new Gson().toJson(saveParcelEntity.get("sender"));
		Client sender=gson.fromJson(senderJson,Client.class);

		String mpesaTransaction=new Gson().toJson(saveParcelEntity.get("mpesaData"));
		IntenalPushRequest mpesaData=gson.fromJson(mpesaTransaction,IntenalPushRequest.class);





		String receiverJson=new Gson().toJson(saveParcelEntity.get("reciever"));
		Client reciever=gson.fromJson(receiverJson,Client.class);


			 reciever=	clientServiceImp.addClient(reciever);


			sender=clientServiceImp.addClient(sender);


		parcel.setSender(sender);
		parcel.setReciever(reciever);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		parcel.setTimestamp(dtf.format(now));


		if(String.valueOf(parcel.getId())!=null){

			String SenderTextMessage="Your Parcel has been sent to "+parcel.getDestination().name +" from "+parcel.getOrigin().getName();
			String RecieverMessage="A  Parcel has been sent to you by "+parcel.getSender().getNames() +" from "+parcel.getOrigin().getName()+" You will be notified once it arrives";
			smsService.sendMessage(sender.getPhone(),SenderTextMessage);
			smsService.sendMessage(reciever.getPhone(),RecieverMessage);
		}


		Parcel savedParcel =parcelService.SaveParcel(parcel);
		if(mpesaData!=null && parcel.getPayment_method().toString().equals("M-PESA") ){
			mpesatransactions transaction=new mpesatransactions();
			transaction.setParcel(savedParcel);
			System.out.println("Mpesa data is present");
			//check if  transaction is in callbacks

			System.out.println("fetching by receipt number"+mpesaData.getMpesaCode());
			System.out.println(mpesaTransactionsRepository.findByMpesaReceiptNumber(mpesaData.getMpesaCode()));

			if(mpesaTransactionsRepository.findByMpesaReceiptNumber(mpesaData.getMpesaCode())==null) {
				System.out.println("WILL SAVE");
				transaction.setAmount(Float.parseFloat(mpesaData.getAmount()));
				transaction.setDate(StringFunctions.getCurrentTimestamp());
				transaction.setPhoneNumber(mpesaData.getPhoneNumber());
				transaction.setParcel(savedParcel);
				transaction.setMpesaReceiptNumber(mpesaData.getMpesaCode());
				mpesaTransactionsRepository.saveTransaction(transaction);

			}else{
				mpesatransactions mpesatransaction= mpesaTransactionsRepository.findByMpesaReceiptNumber(mpesaData.getMpesaCode());
				mpesatransaction.setParcel(savedParcel);
				mpesaTransactionsRepository.saveTransaction(mpesatransaction);

			}
		}

		System.out.println("_------------------");
		System.out.println(mpesaData.toString());
		System.out.println("_------------------");


		System.out.println(sender.toString());



		try{


			QRCodeWriter barcodeWriter = new QRCodeWriter();
			String path=context.getRealPath("/WEB-INF/resources/labels/")+parcel.getId()+".png";
			BitMatrix bitMatrix =barcodeWriter.encode(String.valueOf(parcel.getId()), BarcodeFormat.QR_CODE, 200, 200);
			MatrixToImageWriter.writeToStream(bitMatrix, "png", new FileOutputStream(new File(path)));
		}catch (Exception e){
			System.out.println(e);
		}


		return new ResponseEntity<>(savedParcel,  HttpStatus.OK);
	}


	@GetMapping("/sendSmS")
	public ResponseEntity<?> sendSms(){
		return  new ResponseEntity<>(smsService.sendMessage("+254702164611","hello"),HttpStatus.OK);
	}

}
