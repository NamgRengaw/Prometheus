<template>
    <div class="red-box" :style="customStyle"></div>
  </template>
  
  <script>
  export default {
    name: 'RedBox',
    props: {
      customStyle: Object,
    },
  }
  </script>
  
  <style scoped>
  .red-box {
    width: 100px;
    height: 100px;
    background-color: red;
    border: 2px solid black;
  }
  </style>