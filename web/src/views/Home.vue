<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
        
      <div :style="{ background: 'rgb(190, 200, 200)', padding: '26px 16px 16px' }">
        <a-button ghost>Default</a-button>
      </div>

    <HelloWorld msg="Welcome to Your Vue.js + TypeScript App"/>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import HelloWorld from '@/components/HelloWorld.vue'; // @ is an alias to /src

export default defineComponent({
  name: 'Home',
  components: {
    HelloWorld,
  },
});
</script>
