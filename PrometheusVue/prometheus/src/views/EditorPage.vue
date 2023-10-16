<template>
    <div>
        <q-layout view="hHh Lpr lff" container style="height: 100vh" class="shadow-2">
            <q-header elevated :class="$q.dark.isActive ? 'bg-secondary' : 'bg-black'">
                <q-toolbar>
                    <q-btn icon="menu" @click="drawerOpen = !drawerOpen" />
                    Editor Page
                </q-toolbar>
            </q-header>
            <editor-drawer :isOpen="drawerOpen">
                <template v-slot:objects>
                    <editor-drag-element :items="dragItems" :listNumber="0" />
                </template>
            </editor-drawer>
            <q-page-container>
                <q-page>
                    <div v-for="index in 7" :key="index">
                        <editor-drop-area :listNumber="index" :items="dragItems" />
                    </div>
                </q-page>
            </q-page-container>
        </q-layout>
    </div>
</template>

<script>
import EditorDrawer from '@/components/EditorDrawer.vue'
import EditorDropArea from '@/components/EditorDropArea.vue';
import EditorDragElement from '@/components/EditorDragElement.vue'
import items from '../scripts/dragObjectsTest.js'

export default {
    components: {
        EditorDrawer, EditorDropArea, EditorDragElement
    },
    data() {
        return {
            dragItems: items,
            drawerOpen: false,
        }
    }
}
</script>

<style lang="scss" scoped></style>