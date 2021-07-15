<template>
  <div id="table">
    <datatable :columns="columns" :data="this.data.content" ></datatable>
  </div>
</template>

<script>
export default {
  //https://www.npmjs.com/package/vuejs-datatable
  //https://gerkindev.github.io/vuejs-datatable/tutorials/basic.html
  //
  props: ["data"],
  created() {
  
  },

  data() {
    return {
      columns: [
        { label: "id", field: "id" },
        { label: "sender", field: "sender.first_name" },
        { label: "receiver", field: "reciever.first_name" },
        { label: "phone", field: "reciever.first_name" },
        { label: "origin", field: "origin" },
        { label: "destination", field: "destination" },
        { label: "price", field: "price" },
        { label: "amount_paid", field: "amount_paid" },
      ],
    };
  },
};
</script>