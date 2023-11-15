<template>
   <div class="green-triangle"></div>
</template>
  
<script>
 export default {
  name: 'GreenTriangle',
}
</script> 
  
<style scoped>
.green-triangle {
  width: 0;
  height: 0;
  border-left: 50px solid transparent;
  border-right: 50px solid transparent;
  border-bottom: 100px solid green;
}
</style>