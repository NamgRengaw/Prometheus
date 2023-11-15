<template>
    <div>
        <q-drawer v-if="isOpen" show-if-above :width="200" :breakpoint="700" elevated class="bg-grey-5 text-black">
            <q-scroll-area class="fit">
                <div class="q-pa-lg">
                    <slot name="objects"></slot>
                </div>
            </q-scroll-area>
        </q-drawer>
    </div>
</template>

<script>
import { ref } from 'vue'

export default {
    props: {
        isOpen: Boolean
    },
    setup() {
        return {
            drawer: ref(false)
        }
    }
}
</script>


<style lang="scss" scoped></style>