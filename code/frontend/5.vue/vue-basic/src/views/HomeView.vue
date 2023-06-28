<template>
    <div class="home">
      
      <h2 ref="appTitleRef">{{ appTitle }}</h2>
  
      <h3>{{ counterData.title }}</h3>
      <div>
        <button @click="decreaseCounter(1)" class="btn">-</button>
        <span class="counter">{{ counterData.count }}</span>
        <button @click="increaseCounter(1)" class="btn">+</button>
      </div>
  
      <p>This counter is {{ oddOrEven }}</p>
  
      <div class="edit">
        <h4>Edit counter title:</h4>
        <input v-model="counterData.title" type="text"/>
      </div>
  
    </div>
  </template>
  
  <script setup>
    import { ref, onMounted, onUnmounted, computed, watch, onBeforeMount, onBeforeUnmount, onBeforeUpdate, onUpdated, onActivated, onDeactivated } from 'vue'
    
    const appTitle = 'Counter App';
  
    const appTitleRef = ref(null);

    const counterData = ref({
      count: 0,
      title: 'My Counter',
    });

    watch(() => counterData.value.count, (newCount) => {
      if (newCount === 10) {
        alert('10 combo!');
      }
    });

    const oddOrEven = computed(() => {
      if (counterData.value.count % 2 === 0) return 'even'
      return 'odd'
    });

    const increaseCounter = amount => counterData.value.count += amount;
    const decreaseCounter = amount => counterData.value.count -= amount;
    
    // LifeCycle Hooks
    // CompositionAPI에서 created, beforeCreated hooks는 없고, 해당 단계는 setup 내에서 수행됨
    // appTitle ~ decreaseCount에 작성된 코드들은 컴포넌트가 생성되기 전(BeforeCreated)에 수행됨
    
    onBeforeMount(() => {
      // 추후 마운트 되기 전에 필요한 코드 작성 부분
      console.log('beforeMount');
    });

    onMounted(() => {
      console.log('mounted');
      console.log('The app title is', appTitleRef.value);
    });

    onBeforeUpdate(() => {
      console.log('onBeforeUpdate');
    });

    onUpdated(() => {
      console.log('onUpdated');
    });

    onBeforeUnmount(() => {
      console.log('onBeforeUnmount');
    });
  
    onUnmounted(() => {
      console.log('unmounted');
    });

    // 만약 컴포넌트가 kept alive로 되었을 때 호출
    // -> 컴포넌트가 페이지에서 보이지 않지만, 백그라운드에서 동작되고 있을 때
    onActivated(() => {
      console.log('onActivated');
    });

    onDeactivated(() => {
      console.log('onDeactivated');
    });

  </script>
  
  <style>
  .home {
    text-align: center;
    padding: 20px;
  }
  .btn, .counter {
    font-size: 40px;
    margin: 10px;
  }
  .edit {
    margin-top: 60px;
  }
  </style>