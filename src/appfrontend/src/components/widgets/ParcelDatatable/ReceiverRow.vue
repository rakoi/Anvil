<template>
    <div>
       {{this.data.reciever.first_name}}  {{this.data.reciever.last_name}}
    </div>
</template>
<script>
export default {
    name:"ReceiverRow",
    props:["data"]
}
</script>