<template>
  <div class="ui container">
    <div class="table">
      <data-table v-bind="bindings" />
    </div>
  </div>
</template>

<script>
import OriginRow from "./ParcelDatatable/LocationRow.vue";
import DestinationRow from "./ParcelDatatable/DestinationRow.vue";
import Update from "./ParcelDatatable/Update.vue";
import ReceiverRow from "./ParcelDatatable/ReceiverRow.vue";
import ReciverPhone from "./ParcelDatatable/ReceiverPhone.vue";
import SenderRow from "./ParcelDatatable/SenderRow.vue";
import Collected from "./ParcelDatatable/Collected.vue";
import Paid from "./ParcelDatatable/Paid.vue";

export default {
  // components:{LocationRow},
  computed: {
    bindings() {
      return {
        text: {
          paginationSearchText: "Skip to page",
        },
        sortingIndexComponent: false,
        data: this.data,
        // columnKeys: ["id","origin","destination","reciever","receiver_phone","sender","sender_phone","kilograms","price","collected","fully_paid"],
        columns: [
          {
            title: "origin",
            component: OriginRow,
          },
          {
            title: "destination",
            component: DestinationRow,
          },
          {
            title: "receiver",
            component: ReceiverRow,
          },
          {
            title: "receiver Phone",
            component: ReciverPhone,
          },
          {
            title: "sender",
            component: SenderRow,
          },

          { key: "price", title: "price" },
          { component: Collected, title: "collected" },
          { component: Paid, title: "fully_paid" },
          { component: Update, title: "Update" },
        ],
      };
    },
  },

  props: ["data"],

  data() {
    return {};
  },
  created() {
    this.columns = this.data;
  },
  methods: {},
};
</script>