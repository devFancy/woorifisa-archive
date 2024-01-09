import { defineStore } from 'pinia';
import { computed, ref } from 'vue';

// use~ : 일반적인 네이밍 컨벤션
// defineStroe('store 이름', store에서 관리될 state, getter, actions)
export const useTodoStore = defineStore('todoStore', () => {
  // state - ref, reactive와 같은 반응형 속성
  const todos = ref([
    {
      id: 1,
      title: '물 마시기',
      summary: '물을 마신다',
      category: 'todo'
    },
    {
      id: 2,
      title: '콜라 마시기',
      summary: '콜라를 마신다',
      category: 'progress'
    },
    {
      id: 3,
      title: '우유 마시기',
      summary: '우유를 마신다',
      category: 'done'
    }
  ]);
  const selectedCategory = ref('all');

  // actions - state를 변경하는 함수
  // todo 추가 - addTodo
  const addTodo = (newTodo) => todos.value.push(newTodo);

  // todo 수정 - editTodo
  const editTodo = (todo) => {
    // todos.value = todos.value.filter((t) => t.title !== todo.title);
    // todo 값을 찾아서 변경

    // console.log(todo.summary);

    const editTodoData = todos.value.findIndex((t) => t.id === todo.id);
    // todos[editTodoData].value = todos.value.filter((t) => t.title !== todo.title);

    console.log(editTodoData);

    // editTodoData.title = todo.title;
    // editTodoData.summary = todo.summary;
    // editTodoData.category = todo.category;
  };

  // todo 삭제 - deleteTodo
  const deleteTodo = (title, summary) => {
    todos.value = todos.value.filter((todo) => todo.title !== title);
    // todos.value = todos.value.filter((todo) => todo.summary !== summary);
  };

  // todo 필터링 - filterTodo
  const filterTodos = (category) => {
    selectedCategory.value = category;
  };

  // getter(compute()와 동일)
  // 필터링된 todo 목록 - filteredTodosByCategory
  const filteredTodosByCategory = computed(() => {
    const currentCategory = selectedCategory.value;

    if (currentCategory === 'all') return todos.value;
    return todos.value.filter((todo) => todo.category === currentCategory);
  });

  return {
    todos,
    addTodo,
    editTodo,
    deleteTodo,
    filterTodos,
    filteredTodosByCategory
  };
});
