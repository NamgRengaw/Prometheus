import { ref } from 'vue';

const availableObjects = ref([
  { id: 1, title: 'Square', list: 0},
  { id: 2, title: 'Circle', list: 0},
]);

const items = ref([
  { id: 0, title: '', list: 0 },
]);

export {items, availableObjects};
