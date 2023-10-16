<template>
    <q-card class="q-pa-md">
        <div v-for="item in getList(listNumber)" :key="item.id" class="drag-el" draggable="true"
            @dragstart="startDrag($event, item)">
            {{ item.title }}
        </div>
    </q-card>
</template>

<script>
export default {
    props: {
        listNumber: Number,
        items: Array
    },
    setup(props) {
        const getList = (list) => {
            return props.items.filter((item) => item.list == list)
        }

        const startDrag = (event, item) => {
            event.dataTransfer.dropEffect = 'move'
            event.dataTransfer.effectAllowed = 'move'
            event.dataTransfer.setData('itemID', item.id)
        }

        return {
            getList,
            startDrag,
        }
    }
}
</script>

<style lang="scss" scoped>
.drag-el {
    text-align: center;
    background-color: #3498db;
    color: white;
    padding: 5px;
    margin-bottom: 10px;
}

.drag-el:nth-last-of-type(1) {
    margin-bottom: 0;
}
</style>