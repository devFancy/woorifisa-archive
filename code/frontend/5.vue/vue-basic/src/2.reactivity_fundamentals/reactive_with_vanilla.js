// 1. Without JS Proxy


// let address = 'Sangam-dong';
// let country = ' of Korea';
// let fullAddress = address + country;

// console.log(fullAddress); // Sangam-dong of Korea

// address = 'Susaek-dong'; // address를 수색동으로 변경
// console.log(fullAddress); // Sangam-dong of Korea, 값이 변하지 않음

// /*
//     우리가 원하는 것은 address를 바꿨을 때 fullAddress가 같이 변경되어야함
//     -> 만약 이것이 가능해진다면 'Reactivity'가 구현되었다고 가정
// */


// 2. Using JS Proxy


// // 각각의 변수들을 하나의 프로퍼티로 모으기
// const info = {
//     address: 'Sangam-dong',
//     country: ' of Korea',
//     fullAddress: '',
// };

// const handler = {};

// const proxy = new Proxy(info, handler);
// // console.log(proxy);

// // proxy 객체로 target 객체가 가진 프로퍼티(info 객체의 address, country)에 접근 가능
// console.log(proxy.address); // Sangam-dong

// // fullAddress 프로퍼티에 접근
// console.log(`fullAddress: ${proxy.fullAddress}`);
// // Proxy 객체를 생성했지만, 어떤 별도의 작업을 수행할 핸들러 객체(handler)에게 별도의 코드를 작성하지 않았기 때문에
// // 기존의 객체 참조 방식과 다르지 않음. ex)

// console.log(info.fullAddress === proxy.fullAddress); // true

// 3. Using JS Proxy with handler

const info = {
    address: 'Sangam-dong',
    country: ' of Korea',
    fullAddress: 'Sangam-dong of Korea',
};

// handler 객체 내부에는 함수 형식으로 별도의 작업을 수행할 트랩(Trap)을 추가할 수 있음
// Ref.https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Proxy/Proxy/get
const handlerWithTrap = {
    
    // 'get' 트랩 - target 객체가 가진 속성 값 접근 시 가로채는 역할
    // -> 위에서 작성했던 proxy.address처럼 target객체가 가진 속성에 접근 시 접근하는 동작 과정을 가로챔
    // get(target, property, receiver) {
    //     // console.log(`target:`, target); // 원본 객체
    //     // console.log(`property: ${property}`); // proxy객체로 접근된 원본 객체 내 프로퍼티, 가져올 속성의 이름 또는 Symbol
    //     // console.log(`receiver:`, receiver);// 프락시 또는 프락시에서 상속되는 객체

    //     // return '한국'; // 어떤 값이든 반환 가능
    // },

    set(target, property, value, receiver) {
        // console.log(`target:`, target); // Proxy()에 전달한 data Obj
        // console.log(`property: ${property}`); // data Obj의 프로퍼티명, firstname
        // console.log(`value: `, value); // 새로 할당하려는 값, Modified Code
        // console.log(`receiver`, receiver); // 할당이 지시된 원래 객체
        // const result = Reflect.set(target, property, value, receiver); // set이 반환하는 boolean값 확인방법
        // console.log(result); // set은 작업 수행 성공 시 boolean 반환

        if (property === 'address') {
            target.address = value;
            target.fullAddress = value + target.country;
        }
        // 다른 프로퍼티 수정 시에는 별도로 추가 구현 필요
    }
};

const proxy = new Proxy(info, handlerWithTrap);

// console.log(proxy.address); // 'get' 트랩 없이 접근 시, address 프로퍼티가 가진 값 출력

// 'get'트랩 작성 시 proxy 내부의 코드 재정의
// console.log(proxy.address); // get에 구현된 코드가 동작

// 'set'트랩으로 address 값 변경 시 fullAddress값도 변경하도록 구현

console.log(info.fullAddress); // 기존 값
proxy.address = 'Susaek-dong'; // address 변경

console.log(info.fullAddress); // address가 변경됨에 따라 fullAddress도 같이 변경됨