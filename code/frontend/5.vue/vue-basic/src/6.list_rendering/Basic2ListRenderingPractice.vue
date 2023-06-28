<template>
    <div>
        <ul>
            <li v-for="item in items" :key="item.id">
                <!-- item 접근 가능 -->
                <p>{{ item.name }}</p>
                <ul>
                    <li>설명: {{ item.details.description }}</li>
                    <li>가격: {{ item.details.price }}원</li>
                </ul>
            </li>
        </ul>
    </div>
</template>
  
<script setup>
import { ref } from 'vue';

const items = ref([
    {
        id: 1,
        name: '고산지 재배 사과',
        details: {
            description: '달콤한 맛을 충분히 맛볼 수 있도록 초음속미사일프레시에서 엄선한 사과입니다. 선명한 붉은빛이 감돌아 보기만 해도 먹음직스러워요. 신선하고 아삭아삭한 식감은 물론, 진한 단맛이 매력이랍니다. 입안 가득 상큼하게 퍼지는 과즙을 즐겨보세요.',
            price: 1000
        }
    },
    {
        id: 2,
        name: '진짜 돌(Rock) 바나나',
        details: {
            description: '부드럽고 달달한 풍미로 사랑받는 바나나. 돌 바나나로 골라보세요. 껍질을 벗겨내면 기분 좋은 향미와 함께 희고 깨끗한 과육을 만날 수 있어요. 간편하고 맛있는 간식으로 제격이랍니다.',
            price: 2000
        }
    },
]);
</script>


<style scoped>
p {
    font-size: 1.5rem;
}

ul {
    list-style: none;
    padding: 0;
}

li {
    display: flex;
    flex-direction: column;
    margin-bottom: 20px;
    padding: 20px;
    border-radius: 4px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 2px 4px rgba(0, 0, 0, 0.24);
}

li h3 {
    margin: 0;
    font-size: 24px;
    font-weight: bold;
    color: #333;
}

li ul {
    list-style: none;
    padding: 0;
    margin: 20px 0 0 0;
}

li ul li {
    display: flex;
    margin-bottom: 10px;
}

li ul li span {
    font-size: 16px;
    color: #666;
}
</style>