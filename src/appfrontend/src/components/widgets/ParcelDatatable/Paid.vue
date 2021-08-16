<template>
  <div>
    <div v-if="(this.data.amount_paid/this.data.price)>1">Y</div>
    <div v-else>N</div>
  </div>
</template>
<script>
export default {
  name: "Paid",
  props: ["data"],
};
</script>