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
                    <editor-drag-element :items="availableObjects" :listNumber="0">
                        <template v-slot:object>
                            <red-box customStyle="background-color: purple;"/>
                        </template>
                    </editor-drag-element>
                </template>
            </editor-drawer>
            <q-page-container>
                <q-page>
                    <div v-for="index in 1" :key="index">
                        <editor-drop-area :listNumber="index" :items="dragItems">
                            <template v-slot:object>
                                <blue-ball/>
                            </template>
                        </editor-drop-area>
                    </div>
                </q-page>
            </q-page-container>
        </q-layout>
    </div>
</template>

<script>
import EditorDrawer from '@/components/EditorDrawer.vue'
import EditorDropArea from '@/components/EditorDropArea.vue';
import EditorDragElement from '@/components/EditorDragElement.vue';
import {items, availableObjects} from '../scripts/dragObjectsTest.js';
import RedBox from '@/components/test_components/RedBox';
import BlueBall from '@/components/test_components/BlueBall';
import GreenTriangle from '@/components/test_components/GreenTriangle';

export default {
    components: {
        EditorDrawer, EditorDropArea, EditorDragElement, RedBox, BlueBall, GreenTriangle
    },
    data() {
        return {
            availableObjects: availableObjects,
            dragItems: items,
            drawerOpen: false,
        }
    }
}
</script>

<style lang="scss" scoped></style>