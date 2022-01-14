<h1>ANVIL </h1> Spring Boot/ Vue <br>
  
This is a simple application in development for a courrier service company.
It includes saving a parcel once a client comes in.
<img src="https://github.com/rakoi/Anvil/blob/master/screenshots/newparcel.png" >

Client can be coporate or an individual.
It has invoice intergrations(WIP) and mpesa intergrations.

Mpesa

<img src="https://github.com/rakoi/Anvil/blob/master/screenshots/mpesaIntergration.png" >

Invoices

<img src="https://github.com/rakoi/Anvil/blob/master/screenshots/payment.png" >

Drivers Module allows driver to start a trip setting the destination and origin.
This is done via a mobile app or the web application.
<img src="https://github.com/rakoi/Anvil/blob/master/screenshots/startTrip.png
">


The admin will be able to view the location of the driver on the view trip page.
The Driver can add expenses for the trips using the app or web interface.
<img src="https://github.com/rakoi/Anvil/blob/master/screenshots/addexpense.png" >


Once a trip is started by a driver the driver will load parcels scanning them and each
parcel will be asigned to a trip.This will enable the clients to track their parcels too,


<img src="https://github.com/rakoi/Anvil/blob/master/screenshots/loadParcels.png">




Once the driver reaches the destination and finishes the trip the parcels will be  marked as delivered and the clients will get a text message informing them of the delivery.


<h3><hr>Accounting Module<hr></h3> (WIP)
The  module shows trial balances,balance sheets and also generates invoices for each client.
The debting and aging report will also show the debtors since invoices are generated.
The balance sheets will also be generated for each financial period specified.


Set up..
Back end...
Add your twilo credentials and mpesa routes in the applications.properties file

Front end
Run npm run serve from the src/appfrontend/ folder.

Database

the database is anvil.sql found in the root folder


