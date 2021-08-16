<template>
    <div>
       {{this.data.origin.name}}
    </div>
</template>
<script>
export default {
    name:"OriginRow",
    props:["data"]
}
</script>