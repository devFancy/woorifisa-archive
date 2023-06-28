<template>
    <h2>1. Text Input</h2>
    <input v-model.trim="text"><span>{{ text }}</span><br/>
    <!-- trim modifier: 공백 자동 제거 -->

    <input v-model="age" type="number"> <span>{{ typeof age }}</span><br/>
    <input v-model.number="age" type="text"> <span>{{ typeof age }}</span><br/>
    <!-- number modifier: 숫자 값으로 자동 변환 -->
    <hr>
    <h2>2. Checkbox</h2>
    <input type="checkbox" id="checkbox" v-model="checked">
    <label for="checkbox">Checked: <span>{{ checked }}</span></label>
    <hr>
    <!--
    multiple checkboxes can bind to the same array v-model value -->
    <h2>3. Multi Checkbox</h2>
    <input type="checkbox" id="jack" value="Jack" v-model="checkedNames">
    <label for="jack">Jack</label>
    <input type="checkbox" id="john" value="John" v-model="checkedNames">
    <label for="john">John</label>
    <input type="checkbox" id="mike" value="Mike" v-model="checkedNames">
    <label for="mike">Mike</label>

    <p>Checked names:
    <span>{{ checkedNames }}</span>
    </p>

    <hr>
    <h2>4. Radio</h2>
    <input type="radio" id="one" value="One" v-model="picked">
    <label for="one">One</label>
    <br>
    <input type="radio" id="two" value="Two" v-model="picked">
    <label for="two">Two</label>
    <br>
    <span>Picked: {{ picked }}</span>
    <hr>
    <h2>5. Select</h2>
    <select v-model="selected">
        <option disabled value="">Please select one</option>
        <option>A</option>
        <option>B</option>
        <option>C</option>
    </select>
    <span>Selected: {{ selected }}</span>

    <h2>6. Multi Select</h2>
    <select v-model="multiSelected" style="width:100px">
        <option>A</option>
        <option>B</option>
        <option>C</option>
    </select>
    <span>Selected: {{ multiSelected }}</span>
</template>

<script setup>
import { ref } from 'vue'

const text = ref('Edit me');
const age = ref(0);
const checked = ref(true);
const checkedNames = ref(['Jack']);
const picked = ref('One');
const selected = ref('A');
const multiSelected = ref(['A']);
</script>

<style scoped>
hr {
    margin: 1rem 0;
}

label {
    display: inline;
    margin: 0.5rem;
}

span {
    font-size: 1.25rem;
    color: rgb(19, 197, 19);
}
</style>