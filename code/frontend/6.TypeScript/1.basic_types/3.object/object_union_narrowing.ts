export {}

type CookieWithCompany = {
    name: string,
    company: string,
}

type CookieWithTaste = {
    name: string,
    taste: string,
}

// Union타입. Cookie 타입은 company 혹은 Taste 타입을 받을 수 있는 타입니다.
type Cookie = CookieWithCompany | CookieWithTaste;

const firstCookie : Cookie = Math.random() > 0.5 ? {name : 'OREO', company : 'Nabisco'} : {name : 'OREO', taste : 'Choco'};

console.log(firstCookie.name); // company든, Taste든, 둘 다 name 프로퍼티는 존재

firstCookie.company;
// Property 'company' does not exist on type 'Cookie'. // Taste타입일 때는 company가 존재하지 않을 수 있기 때문에
// Property 'company' does not exist on type 'CookieWithTaste'.

// 타입 좁히기 ( Narrowing )
if('company' in firstCookie) {
    // firstCookie에 company 프로퍼티가 존재할 경우, 접근 가능
    firstCookie.company;
}

if('taste' in firstCookie) firstCookie.taste;

// or
if('company' in firstCookie) {
    firstCookie.company;
} else {
    // CookieWithCompany 타입이 아니면, Taste 타입일 것
    firstCookie.taste;
}