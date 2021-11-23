package com.anvil.rakoi.anvil.restController;

import antlr.StringUtils;
import com.anvil.rakoi.anvil.entities.Client;
import com.anvil.rakoi.anvil.entities.Expenses;
import com.anvil.rakoi.anvil.services.ExpensesImpl;
import com.anvil.rakoi.anvil.util.StringFunctions;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("/api/expenses")
public class ExpensesRestController {

    @Autowired
    ExpensesImpl expensesServiceImpl;



    @GetMapping("/all")
    public  Page<Expenses>  getAll(Pageable pageable){

        return expensesServiceImpl.getAllExpenses(pageable);
    }

    @GetMapping("/getByTrip/{tripId}")
    public  Page<Expenses>  getExpenseByTrip(@PathVariable("tripId") String tripId,Pageable pageable){

        return expensesServiceImpl.getExpenseByTrip(tripId,pageable);
    }


    @GetMapping("/getByExpense/{expenseId}")
    public  Page<Expenses>  getByExpense(@PathVariable("expenseId") String expenseId,Pageable pageable){

        return expensesServiceImpl.getExpenseByTrip(expenseId,pageable);
    }

    @GetMapping("/delete/{expenseId}")
    public  ResponseEntity<?> deleteExpense(@PathVariable("expenseId") Integer expenseId){

        try{
            expensesServiceImpl.deleteExpense(expenseId);
            return new ResponseEntity<>("deleted", HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>("error", HttpStatus.OK);
        }


    }

    @PostMapping("/add")
    public ResponseEntity<?> addExpense(@RequestBody JSONObject expenses){

        Gson gson = new Gson();
        Expenses expenseObj=gson.fromJson(String.valueOf(expenses),Expenses.class);

        System.out.print(expenseObj.toString());
        expenseObj.setTimestamp(StringFunctions.getCurrentTime());

          return new ResponseEntity<>(expensesServiceImpl.createExpense(expenseObj), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateExpense(@RequestBody Expenses expenses){
        Expenses editExpense=expensesServiceImpl.getExpenseById(expenses.getId());
        editExpense.setCost(expenses.getCost());

        try{
            expensesServiceImpl.UpdateExpense(editExpense);
            return new ResponseEntity<>("updated", HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>("error", HttpStatus.OK);
        }
    }


}
