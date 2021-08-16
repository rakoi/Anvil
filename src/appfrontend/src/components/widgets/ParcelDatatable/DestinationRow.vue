<template>
    <div>
       {{this.data.destination.name}}
    </div>
</template>
<script>
export default {
    name:"DestinationRow",
    props:["data"]
}
</script>