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
                                <input class="form-control" name="sender.id" hidden v-model="sender.id" id="senderid" />
                                <div class="invalid-feedback">Valid ID is required.</div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="sfirstName">First name</label>
                                <input type="text" class="form-control" placeholder="First Name" required="true" v-model="sender.first_name" />
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="slastName">Last name</label>
                                <input type="text" class="form-control" name="sender.lname" id="slastName" placeholder="Last Name" v-model="sender.last_name" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label for="semail">Email <span class="text-muted">(Optional)</span></label>
                                <input type="email" name="sender.email" class="form-control" id="semail" v-model="sender.email" placeholder="you@example.com" />
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="sPhoneNumber">Phone Number</label>
                                <input type="senderphone" name="sender.phone" class="form-control" id="sphone" v-model="sender.phone" />

                            </div>
                        </div>

                        <div class="mb-3">
                            <label for="address">I.D Number</label>
                            <input type="text" class="form-control" name="sender.address" id="saddress" placeholder="121212" v-model="sender.id_number" />
                        </div>

                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label for="town">Town</label>

                                <select class="form-control" required="true" name="parcel.origin" v-model="parcel.origin">
                                    <option value="">Select Origin</option>
                                    <option v-for="station in stations" v-bind:value="station" :key="station.id">
                                        {{station.name}}
                                    </option>
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
                            <input id="receverid" name="reciever.id" class="form-control" placeholder="#" hidden v-model="receiver.id" />
                        </div>
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label for="rfirstName">First name</label>
                                <input type="text" class="form-control" name="reciever.fname" id="rfirstName" placeholder="First Name" required="true" v-model="receiver.first_name" />
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="rlastName">Last name</label>
                                <input type="text" class="form-control" name="reciever.lname" id="rlastName" placeholder="Last Name" v-model="receiver.last_name" />
                                <div class="invalid-feedback">
                                    Valid last name is required.
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label for="remail">Email <span class="text-muted">(Optional)</span></label>
                                <input type="email" class="form-control" id="remail" placeholder="you@example.com" name="reciever.email" v-model="receiver.email" />
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="rPhoneNumber">Phone Number</label>
                                <input type="text" name="receiver.phone" class="form-control" id="rphone" v-model="receiver.phone" />

                            </div>
                        </div>

                        <div class="mb-3">
                            <label for="raddress">I.D Number</label>
                            <input type="text" class="form-control" id="raddress" placeholder="1234568" name="reciever.address" v-model="receiver.id_number" />
                        </div>

                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label for="rtown">Town</label>

                                <select class="form-control" required="true" name="parcel.destination" v-model="parcel.destination">
                                    <option value="">Select Destination</option>
                                    <option v-for="station in stations" v-bind:value="station" :key="station.id">
                                        {{station.name}}
                                    </option>
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
                            <input type="textarea" class="form-control" name="description" id="sdescription" placeholder="description" v-model="parcel.description" />
                            <div class="invalid-feedback">
                                Please select a valid description.
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3 mb-3">
                                <label for="weight">Weight</label>
                                <input type="number" class="form-control" name="kilograms" id="weight" v-model="parcel.kilograms" required="true" />
                                <div class="invalid-feedback">Valid weight is required.</div>
                            </div>
                            <div class="col-md-3 mb-3">
                                <label for="quantity">Quantity</label>
                                <input type="number" name="quantity" class="form-control" id="quantity" v-model="parcel.quantity" required="true" />
                                <div class="invalid-feedback">Quantity required.</div>
                            </div>
                            <div class="col-md-3 mb-3">
                                <label for="price">Total price</label>
                                <input type="number" class="form-control" id="price" name="price" required="true" maxlength="5" v-model="parcel.price" />
                                <div class="invalid-feedback">
                                    Please the total amount charged.
                                </div>
                            </div>
                            <div class="col-md-3 mb-3">
                                <label for="price">Amount Paid</label>
                                <input type="number" class="form-control" id="price" name="price" required="true" maxlength="5" v-model="parcel.amount_paid" />
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="collected">Collected </label>

                                <select name="parcel.collected" v-model="parcel.collected" class="form-control">
                                    <option value="true">Collected</option>
                                    <option value="false">Not Collected</option>
                                </select>
                            </div>
                        </div>

                        <hr class="mb-4" />

                        <h4 class="mb-3">Payment</h4>

                        <div class="d-block my-3">
                            <div class="custom-control custom-radio">
                                <input id="credit" name="payment" type="radio" value="M-PESA" class="custom-control-input" v-model="parcel.payment_method" required v-b-modal.modal-1 @change="onChange($event)" />
                                <label class="custom-control-label" for="credit">Mpesa</label>
                            </div>
                            <div class="custom-control custom-radio">
                                <input id="debit" name="payment" value="cash" type="radio" v-model="parcel.payment_method" class="custom-control-input" required @change="onChange($event)" />
                                <label class="custom-control-label" for="debit">Cash</label>
                            </div>
                            <div class="custom-control custom-radio">
                                <input id="paypal" name="payment" type="radio" value="C.O.D" v-model="parcel.payment_method" class="custom-control-input" required @change="onChange($event)" />
                                <label class="custom-control-label" for="paypal">Paid On Delivery</label>
                            </div>
                            <div class="custom-control custom-radio">
                                <input id="invoice" name="payment" type="radio" value="invoice" class="custom-control-input" required v-model="parcel.payment_method" @change="onChange($event)" />
                                <label class="custom-control-label" for="invoice">Invoice</label>
                            </div>
                        </div>

                        <hr class="mb-4" />
                        <center>
                            <div id="loader"></div>
                        </center>
                        <div>
                            <center>
                                <p class="danger" id="warn"></p>
                            </center>
                        </div>

                        <div class="alert-danger" v-if="errors.length">
                            <ul>
                                <li v-for="error in errors" v-bind:key="error">{{ error }}</li>
                            </ul>
                        </div>
                        <button class="btn btn-primary btn-lg btn-block" id="submit" type="submit" @click="saveParcel">
                            Update Parcel
                        </button>
                    </form>
                    <br /><br />
                </div>
            </div>
            <div>
                <b-modal id="modal-1" ok-only ok-variant="secondary" ok-title="Cancel" title="M-PESA">
                    <label>Phone Number</label>
                    <input class="form-control" v-model="sender.phone" />
                    <label>Mpesa Code</label>
                    <input class="form-control" />
                    <div class="row">
                        <div class="col-md-6">
                            <b-button class="mt-3 btn-block" @click="sendPush()">Send Push</b-button>
                        </div>
                    </div>
                </b-modal>
            </div>
        </div>

        <!-- /.container-fluid -->
    </appLayout>
</div>
</template>

<script>
import appLayout from "../layout/appLayout";
import {
    HTTP
} from '../../common/http-common'
import {
    mapActions,
    mapGetters
} from "vuex";
export default {
    components: {
        appLayout,

    },
    created() {
        let url = '/parcel/getParcel/' + this.$route.params.id;
        HTTP.get('stations/all').then((resp) => {
            this.stations = resp.data;
        })

        HTTP.get(url).then((resp) => {
            this.parcel = resp.data;
            this.receiver = resp.data.reciever;
            this.sender = resp.data.sender;

        });

    },
    data() {
        return {
            sender: {},
            errors: [],
            receiver: {},
            parcel: {},
            payment_method: "",
            stations: []
        };
    },
    methods: {
        ...mapGetters(["getLoggedInUser", "getAddedParcel"]),
        ...mapActions(["addParcel", "getUser"]),
        onChange(event) {

            var data = event.target.value;
            this.payment_method = data;

            this.parcel.payment_method = data;
        },
        getSender(value) {
            this.sender = value;
        },
        getReceiver(value) {
            this.receiver = value;
        },
        saveParcel(e) {
            e.preventDefault();

            if (this.sender.id == null) {
                this.sender.id = 0;
            }

            if (this.receiver.id == null) {
                this.receiver.id = 0;
            }

            let newParcel = {
                sender: this.sender,
                reciever: this.receiver,
                parcel: this.parcel,
            };

            //validation
            this.errors = [];
            if (this.sender.first_name === "" || !this.sender.first_name) {
                this.errors.push("enter sender first name");

            } else if (this.sender.last_name === "" || !this.sender.last_name) {
                this.errors.push("enter sender last name");
            } else if (this.sender.email === "" || !this.sender.email) {
                this.errors.push("enter sender email");
            } else if (this.sender.id_number === "" || !this.sender.id_number) {
                this.errors.push("enter sender id number");
            } else if (this.receiver.first_name === "" || !this.receiver.first_name) {
                this.errors.push("enter receiver first name");
            } else if (this.receiver.last_name === "" || !this.receiver.last_name) {
                this.errors.push("enter receiver last name");
            } else if (this.receiver.email === "" || !this.receiver.email) {
                this.errors.push("enter receiver email");
            } else if (this.receiver.id_number === "" || !this.receiver.id_number) {
                this.errors.push("enter reciver number");
            } else if (this.parcel.description === "" || !this.parcel.description) {
                this.errors.push("enter description number");
            } else if (this.parcel.kilograms === "" || !this.parcel.kilograms) {
                this.errors.push("enter weight of parcel");
            } else if (this.parcel.quantity === "" || !this.parcel.quantity) {
                this.errors.push("enter quantity");
            } else if (this.parcel.price === "" || !this.parcel.price) {
                this.errors.push("enter total_price");
            } else if (this.parcel.amount_paid === "" || !this.parcel.amount_paid) {
                this.errors.push("enter amount_paid");
            } else if (
                this.parcel.payment_method === "" || !this.parcel.payment_method) {
                this.errors.push("enter payment_method");
            } else {
                this.addParcel(newParcel).then(() => {
                    let parcel = this.getAddedParcel();

                    this.$router.push({
                        name: 'ShowParcel',
                        params: {
                            id: parcel.id
                        }
                    });
                });

            }
        },
    },
};
</script>
