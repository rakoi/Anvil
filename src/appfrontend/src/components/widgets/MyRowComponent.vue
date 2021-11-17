<template>
  <div class="ui container">
   
  
  </div>
</template>

<script>

export default {
       props:['content','column'],
       
       created(){
         let col=this.column;
          let con=this.content;
       
        console.log(con[col]);
      //  for (const key in con) {

      //    if(key===col){
      //      console.log('found'+con[key])
      //    }
         

      //     console.log(`${key}: ${con[key]}`);
      //   }
     
          },
data(){
  return{

  }
}
 

};
</script>