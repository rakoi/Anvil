<template>
<appLayout>
    <div id="allinvoices">
        <h4>All Invoices</h4>
          <MyDatatable :columns="invoiceColumns" :values="invoiceColumnsNames" :url="'invoice/all'" :showEdit=false :showCustom=true :customButtonText="`Action`" @customButtonClicked="editInvoice" @EditButtonClicked="editInvoice" />



    </div>
</appLayout>
</template>

<style scoped>
.tab-link {
    color: red;
    padding-left: 30%;
}

hr {
    height: 1px;
    color: #123455;
    background-color: #123455;
    border: none;
}

a {
    text-decoration: none;
}
</style>

<script>
import appLayout from "../../layout/appLayout.vue";
import MyDatatable from '../../widgets/MyDatatable.vue'

export default {
    components: {
        appLayout,
        MyDatatable
    },
    methods: {
        editInvoice(data) {

         
            this.$router.push({
                name: 'showInvoice',
                params: {
                    id: data.id
                }
            });
        },

        customButtonClicked: function (data) {
            console.log(data);

             this.$router.push({
                name: 'ShowParcel',
                params: {
                    id: data.id
                }
            });
            
        }
    },
    created() {

    },

    data() {
        return {
            invoiceColumns: [
                "id",
                "date",
                "client",
                "status"
            ],
            invoiceColumnsNames: [
                "id",
                "date",
                 "clientNames",
                "status"
               
            ]

        };
    },
};
</script>
