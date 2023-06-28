/* 원문(en)

https://typescript-kr.github.io/

Intro:

    We are starting a small community of users. For performance
    reasons we have decided to store all users right in the code.
    This way we can provide our developers with more
    user-interaction opportunities. With user-related data, at least.
    All the GDPR-related issues will be solved some other day.
    This would be the base for our future experiments during
    these exercises.

Exercise:

    Given the data, define the interface "User" and use it accordingly.

*/


/*
    1번

    주어진 데이터에서 'User'라는 이름의 interface를 정의,
    작성한 인터페이스를 코드 내에서 적절하게 사용하기
*/

export type User = {
    name : string;
    age : number;
    occupation : string;
};

export const users: User[] = [
    {
        name: 'Max Mustermann',
        age: 25,
        occupation: 'Chimney sweep'
    },
    {
        name: 'Kate Müller',
        age: 23,
        occupation: 'Astronaut'
    }
];

export function logPerson(user: User) {
    console.log(` - ${user.name}, ${user.age}`);
}

console.log('Users:');
users.forEach(logPerson);


/* In case if you are stuck:

// https://www.typescriptlang.org/docs/handbook/2/objects.html
*/
