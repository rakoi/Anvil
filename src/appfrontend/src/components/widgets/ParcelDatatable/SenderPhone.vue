<template>
    <div>
       {{this.data.sender.phone}} 
    </div>
</template>
<script>
export default {
    name:"SenderPhone",
    props:["data"]
}
</script>