<template>
  <div id="newparcel">
    <appLayout>
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-10">
            <h4 class="mb-3">Sender address</h4>
            <form id="newparcelform" method="post">
              <div class="mb-3">
                <div class="input-group"></div>
              </div>

              <div class="row">
                <div class="col-md-12 mb-3">
                  <input
                  
                    class="form-control"
                    name="sender.id"
                    v-model="sender.id"
                    id="senderid"
                    placeholder="#"
                  />
                  <div class="invalid-feedback">Valid ID is required.</div>
                </div>
                <div class="col-md-6 mb-3">
                  <label for="sfirstName">First name</label>
                  <input
                    type="text"
                    class="form-control"
                    placeholder="First Name"
                    required="true"
                    v-model="sender.first_name"
                  />
                 
                </div>
                <div class="col-md-6 mb-3">
                  <label for="slastName">Last name</label>
                  <input
                    type="text"
                    class="form-control"
                    name="sender.lname"
                    id="slastName"
                    placeholder="Last Name"
                    v-model="sender.last_name"
                  />
                 
                </div>
              </div>
              <div class="row">
                <div class="col-md-6 mb-3">
                  <label for="semail"
                    >Email <span class="text-muted">(Optional)</span></label
                  >
                  <input
                    type="email"
                    name="sender.email"
                    class="form-control"
                    id="semail"
                    v-model="sender.email"
                    placeholder="you@example.com"
                  />
               
                </div>
                <div class="col-md-6 mb-3">
                  <label for="sPhoneNumber">Phone Number</label>
                  <AutoComplete
                   v-on:childToParent="getSender"
                  />
                
                  <div class="alert-danger" id="sPhoneValidation"></div>
                </div>
              </div>

              <div class="mb-3">
                <label for="address">I.D Number</label>
                <input
                  type="text"
                  class="form-control"
                  name="sender.address"
                  id="saddress"
                  placeholder="121212"
                  v-model="sender.id_number"
                />
              
              </div>

              <div class="row">
                <div class="col-md-6 mb-3">
                  <label for="town">Town</label>
                  <select
                    class="custom-select d-block w-100"
                    id="stown"
                    name="sender.town"
                    required="true"
                    v-model="parcel.origin"
                  >
                    <option value="">Choose...</option>
                    <option value="Nairobi">Nairobi</option>
                    <option value="Mwea">Mwea</option>
                    <option value="Embu">Embu</option>
                    <option value="Runyenjes">Runyenjes</option>
                    <option value="Chuka">Chuka</option>
                    <option value="Nkubu">Nkubu</option>
                   
                   
                  </select>
             
                </div>
               
              </div>
              <hr class="mb-4" />
              <H2> Receiver's Details </H2>
              <div class="mb-3">
                <div class="input-group">
                  <div class="input-group-prepend"></div>
                  <div class="input-group-append"></div>
                
                </div>
              </div>
              <div class="col-md-12 mb-3">
                <input
                
                  id="receverid"
                  name="reciever.id"  
                  class="form-control"
                  placeholder="#"
                  v-model="receiver.id"
                />
             
              </div>
              <div class="row">
                <div class="col-md-6 mb-3">
                  <label for="rfirstName">First name</label>
                  <input
                    type="text"
                    class="form-control"
                    name="reciever.fname"
                    id="rfirstName"
                    placeholder="First Name"
                    required="true"
                       v-model="receiver.first_name"
                  />
                 
                </div>
                <div class="col-md-6 mb-3">
                  <label for="rlastName">Last name</label>
                  <input
                    type="text"
                    class="form-control"
                    name="reciever.lname"
                    id="rlastName"
                    placeholder="Last Name"
                       v-model="receiver.last_name"
                  />
                  <div class="invalid-feedback">
                    Valid last name is required.
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6 mb-3">
                  <label for="remail"
                    >Email <span class="text-muted">(Optional)</span></label
                  >
                  <input
                    type="email"
                    class="form-control"
                    id="remail"
                    placeholder="you@example.com"
                    name="reciever.email"
                       v-model="receiver.email"
                  />
               
                </div>
                <div class="col-md-6 mb-3">
                  <label for="rPhoneNumber">Phone Number</label>
                <AutoComplete
                   v-on:childToParent="getReceiver"
                />
                 
                </div>
              </div>

              <div class="mb-3">
                <label for="raddress">I.D Number</label>
                <input
                  type="text"
                  class="form-control"
                  id="raddress"
                  placeholder="1234568"
                  name="reciever.address"
                     v-model="receiver.phone"
                />
                
              </div>

              <div class="row">
                <div class="col-md-6 mb-3">
                  <label for="rtown">Town</label>
                  <select
                    class="custom-select d-block w-100"
                    name="reciever.town"
                    id="rtown"
                    required="true"
                    v-model="parcel.destination"
                  >
                    <option value="">Choose...</option>
                    <option value="Nairobi">Nairobi</option>
                    <option value="Mwea">Mwea</option>
                    <option value="Embu">Embu</option>
                    <option value="Runyenjes">Runyenjes</option>
                    <option value="Chuka">Chuka</option>
                    <option value="Nkubu">Nkubu</option>
                  </select>
                  <div class="invalid-feedback">
                    Please select a valid Town.
                  </div>
                </div>
           
                <div class="col-md-3 mb-3">
                  <div class="invalid-feedback"></div>
                </div>
              </div>
              <div class="custom-control custom-checkbox"></div>
              <div class="custom-control custom-checkbox"></div>

              <hr class="mb-4" />

              <h4 class="mb-3">Shipment Info</h4>
              <div class="mb-3">
                <label for="town">Description</label>
                <input
                  type="textarea"
                  class="form-control"
                  name="description"
                  id="sdescription"
                  placeholder="description"
                   v-model="parcel.description"
                />
                <div class="invalid-feedback">
                  Please select a valid description.
                </div>
              </div>
              <div class="row">
                <div class="col-md-3 mb-3">
                  <label for="weight">Weight</label>
                  <input
                    type="number"
                    class="form-control"
                    name="kilograms"
                    id="weight"
                    placeholder="11"
                     v-model="parcel.kilograms"
                    required="true"
                  />
                  <div class="invalid-feedback">Valid weight is required.</div>
                </div>
                <div class="col-md-3 mb-3">
                  <label for="quantity">Quantity</label>
                  <input
                    type="number"
                    name="quantity"
                    class="form-control"
                    placeholder="1"
                    id="quantity"
                     v-model="parcel.quantity"
                    required="true"
                  />
                  <div class="invalid-feedback">Quantity required.</div>
                </div>
                <div class="col-md-3 mb-3">
                  <label for="price">Total price</label>
                  <input
                    type="number"
                    class="form-control"
                    id="price"
                    name="price"
                    placeholder="1"
                    required="true"
                    maxlength="5"
                      v-model="parcel.price"
                  />
                  <div class="invalid-feedback">
                    Please the total amount charged.
                  </div>
                </div>
                  <div class="col-md-3 mb-3">
                  <label for="price">Amount Paid</label>
                  <input
                    type="number"
                    class="form-control"
                    id="price"
                    name="price"
                    placeholder="1"
                    required="true"
                    maxlength="5"
                     v-model="parcel.amount_paid"
                  />
                
                </div>
                  <div class="col-md-6 mb-3">
                  <label for="collection_point">Collection Point</label>
                  <textarea
                    type="number"
                    class="form-control"
                    id="collection_point"
                    name="collection_point"
                    placeholder="1"
                    required="true"
                    
                    
                  />
                
                </div>
              </div>

              <hr class="mb-4" />

              <h4 class="mb-3">Payment</h4>

              <div class="d-block my-3">
                <div class="custom-control custom-radio">
                  <input
                    id="credit"
                    name="payment"
                    type="radio"
                    value="M-Pesa"
                    class="custom-control-input"
                    
                    required
                    @change="onChange($event)"
                  />
                  <label class="custom-control-label" for="credit">Mpesa</label>
                </div>
                <div class="custom-control custom-radio">
                  <input
                    id="debit"
                    name="payment"
                    value="cash"
                    type="radio"
                    class="custom-control-input"
                    required
                   
                    @change="onChange($event)"
                  />
                  <label class="custom-control-label" for="debit">Cash</label>
                </div>
                <div class="custom-control custom-radio">
                  <input
                    id="paypal"
                    name="payment"
                    type="radio"
                    value="C.O.D"
                    class="custom-control-input"
                    required
                    
                    @change="onChange($event)"

                    
                  />
                  <label class="custom-control-label" for="paypal"
                    >Cash On Delivery</label
                  >
                </div>
                <div class="custom-control custom-radio">
                  <input
                    id="invoice"
                    name="payment"
                    type="radio"
                    value="invoice"
                    class="custom-control-input"
                    required
                     
                    @change="onChange($event)"
                  />
                  <label class="custom-control-label" for="invoice"
                    >Invoice</label
                  >
                </div>
              </div>

              <hr class="mb-4" />
              <center><div id="loader"></div></center>
              <div>
                <center>
                  <p class="danger" id="warn"></p>
                </center>
              </div>

              <button
                class="btn btn-primary btn-lg btn-block"
                id="submit"
                type="submit"
                @click="saveParcel"
              >
                Send Parcel
              </button>
            </form>
            <br><br>
          </div>
        </div>
      </div>
      <!-- /.container-fluid -->
    </appLayout>
  </div>
</template>

<script>
import appLayout from "../layout/appLayout";
import AutoComplete from '../widgets/AutoComplete.vue'
import {mapActions} from 'vuex'
export default {
  components: {
    appLayout,
    AutoComplete
  },
  created(){
      this.parcel.origin="Nairobi";
      this.parcel.destination="Mwea";
      this.parcel.kilograms=109;
      this.parcel.amount_paid="200";
      this.parcel.price="200"
       this.parcel.description="TEST"
  },
  data(){
    return{
      sender:{},
      receiver:{},
      parcel:{},
      payment_method:'',
    }
  },
  methods:{
    ...mapActions(["addParcel"]),
    onChange(event){
     var data = event.target.value;
     this.payment_method=data;
    
     this.parcel.payment_method=data;
      console.log(this.parcel);
    },
    getSender(value){
      this.sender=value;
    
    },
    getReceiver(value){
      this.receiver=value
    },
    saveParcel(e){
      e.preventDefault();
     
      
      
      let newParcel={
        sender:this.sender,
        reciever:this.receiver,
        parcel:this.parcel
      }

      console.log(newParcel)

   
    this.addParcel(newParcel);



    }

  }
};
</script>