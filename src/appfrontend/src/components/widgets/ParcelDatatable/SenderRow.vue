<template>
    <div>
       {{this.data.sender.first_name}}  {{this.data.sender.last_name}}
    </div>
</template>
<script>
export default {
    name:"SenderRow",
    props:["data"]
}
</script>