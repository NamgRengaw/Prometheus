<template>
    <q-layout view="hHh Lpr lff" container style="height: 100vh" class="shadow-2">
        <HeaderLayout />
    </q-layout>
</template>

<script>
import HeaderLayout from '../layouts/HeaderLayout.vue'

export default {
    components: {
        HeaderLayout
    },

    setup() {


        return {}
    }
}
</script>

<style lang="scss" scoped></style>