<script setup>

// 1. Template Syntax
import Basic1TextInterpolation from './1.template_syntax/Basic1TextInterpolation.vue';
import Basic2RawHTML from './1.template_syntax/Basic2RawHTML.vue';
import Basic3AttributeBinding from './1.template_syntax/Basic3AttributeBinding.vue';
import Basic4Directives from './1.template_syntax/Basic4Directives.vue';

// 2. reactivity fundamentals
import Basic1DeclaringReactiveState from './2.reactivity_fundamentals/Basic1DeclaringReactiveState.vue';
import Basic2UsingSetupHook from './2.reactivity_fundamentals/Basic2UsingSetupHook.vue';

// 3. computed properties
import Basic1ComputedProperties from './3.computed_properties/Basic1ComputedProperties.vue'
import Basic2ComputedPractice from './3.computed_properties/Basic2ComputedPractice.vue'

// 4. class style bindings
import Basic1BindingHTML from './4.class_style bindings/Basic1BindingHTML.vue';

// 5. conditional rendering
import Basic1ConditionalRendering from './5.conditional_rendering/Basic1ConditionalRendering.vue'
import Basic2ConditionalPractice from './5.conditional_rendering/Basic2ConditionalPractice.vue'

// 6. list rendering
import Basic1ListRendering from './6.list_rendering/Basic1ListRendering.vue'
import Basic2ListRenderingPractice from './6.list_rendering/Basic2ListRenderingPractice.vue';

// 7. event handling
import Basic1EventHandling from './7.event_handling/Basic1EventHandling.vue'
import Basic2EventModifier from './7.event_handling/Basic2EventModifier.vue'

// 8. form binding
import Basic1FormBinding from './8.form_binding/Basic1FormBinding.vue';

// 9. life cycle
// import { KeepAlive } from 'vue';
// HomeView에서 진행

// 10. watchers
import Basic1Watch from './10.watchers/Basic1Watch.vue';
import Basic2WatchPractice from './10.watchers/Basic2WatchPractice.vue';
import Basic3WatchNWatchEffect from './10.watchers/Basic3WatchNWatchEffect.vue';
import Basic4UsingWatchEffect from './10.watchers/Basic4UsingWatchEffect.vue';

</script>

<template>
  <!-- 1. Template Syntax -->
  <!-- <Basic1TextInterpolation /> -->
  <!-- <Basic2RawHTML /> -->
  <!-- <Basic3AttributeBinding /> -->
  <!-- <Basic4Directives /> -->

  <!-- 2. reactivity fundamentals -->
  <!-- <Basic1DeclaringReactiveState /> -->
  <!-- <Basic2UsingSetupHook /> -->

  <!-- 3. computed properties -->
  <!-- <Basic1ComputedProperties /> -->
  <!-- <Basic2ComputedPractice /> -->

  <!-- 4. class style bindings -->
  <!-- <Basic1BindingHTML /> -->

  <!-- 5. conditional rendering -->
  <!-- <Basic1ConditionalRendering /> -->
  <!-- <Basic2ConditionalPractice /> -->

  <!-- 6. list rendering -->
  <!-- <Basic1ListRendering /> -->
  <!-- <Basic2ListRenderingPractice /> -->

  <!-- 7. event handling -->
  <!-- <Basic1EventHandling /> -->
  <!-- <Basic2EventModifier /> -->

  <!-- 8. form binding -->
  <!-- <Basic1FormBinding /> -->

  <!-- 9. lifecycle hooks -->
  <!-- Lifecycle은 HomeView에서 진행 -->

  <nav>
    <RouterLink to="/">Home</RouterLink>
    <RouterLink to="/about">About</RouterLink>
  </nav>

  <RouterView v-slot="{ Component }">
    <KeepAlive>
      <component :is="Component" />
    </KeepAlive>
  </RouterView>

  <!-- 10. watchers -->
  <!-- <Basic1Watch /> -->
  <!-- <Basic2WatchPractice /> -->
  <!-- <Basic3WatchNWatchEffect /> -->
  <!-- <Basic4UsingWatchEffect /> -->
</template>

<style scoped>
nav {
  width: 100%;
  font-size: 1rem;
  text-align: center;
  margin-top: 2rem;
}

nav a {
  display: inline-block;
  padding: 0 1rem;
  border-left: 1px solid var(--color-border);
}

nav a:first-of-type {
  border: 0;
}
</style>