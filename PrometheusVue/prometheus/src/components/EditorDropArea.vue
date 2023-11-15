<template>
    <div>
        <div @drop="onDrop($event, listNumber)" @dragenter.prevent @dragover.prevent>
            <q-card class="q-pa-md">
                <editor-drag-element class="drop-zone" :items="items" :listNumber="listNumber">
                    <template v-slot:object>
                        <slot name="object"></slot>
                    </template>
                </editor-drag-element>
            </q-card>
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
            //item.list = list
            createObject(props.items, list)
            console.log(props.items)
        }

        const createObject = (items, listNumber) => {
            items.push({id: generateUniqueId(items), title: '', list: listNumber});
        }

        const generateUniqueId = (items) => {
            if(items.lenght === 0) {
                return undefined
            }
            let id = items[0].id;
            for(let i = 1; i < items.length; i++) {
                if(items[i].id > id) {
                    id = items[i].id
                }
            }
            id++
            return id;
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
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: center;
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