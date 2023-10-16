<template>
    <div>
        <div class="drop-zone" @drop="onDrop($event, listNumber)" @dragenter.prevent @dragover.prevent>
            <editor-drag-element :items="items" :listNumber="listNumber"/>
        </div>
    </div>
</template>

<script>
import EditorDragElement from './EditorDragElement.vue'

export default {
    components: {
        EditorDragElement
    },
    props: {
        listNumber: Number,
        items: Array
    },
    setup(props) {

        const startDrag = (event, item) => {
            console.log(item)
            event.dataTransfer.dropEffect = 'move'
            event.dataTransfer.effectAllowed = 'move'
            event.dataTransfer.setData('itemID', item.id)
        }

        const onDrop = (event, list) => {
            const itemID = event.dataTransfer.getData('itemID')
            const item = props.items.find((item) => item.id == itemID)
            item.list = list
        }

        return {
            onDrop,
            startDrag,
        }
    }
}
</script>

<style lang="scss" scoped>
.drop-zone {
    width: 50%;
    margin: 50px;
    background-color: #ecf0f1;
    padding: 10px;
    min-height: 10px;
}

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