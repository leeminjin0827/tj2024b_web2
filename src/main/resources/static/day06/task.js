// 1. let과 const를 사용해서 name(이름)과 age(나이)를 저장하고 값을 출력해 보세요.
let name1 = '이순신'
let age1 = 40;
console.log( "[1] " + name1 );
console.log( "[1] " + age1 );
// 2. 숫자 두 개를 받아서 곱한 값을 반환하는 화살표 함수를 작성하세요.
const fun1 = ( param1 , param2 ) => {
    let result = param1 * param2;
    return result;
}
// 3. name과 age를 활용해서 "저는 [이름]이고, [나이]살입니다." 를 출력하세요.
const name = "Alice";
const age = 25;

console.log( `[3] 저는 ${name} 이고 , ${age}살입니다.`)
// 4. user 객체에서 name과 email 값을 추출해 변수를 만들고 출력하세요.
const user = { name: "Alice", email: "alice@example.com", age: 25 };

let name3 = user.name;
let email3 = user.email;
console.log( "[4] " + name3 );
console.log( "[4] " + email3 );
// 5. arr1과 arr2를 합쳐 result 배열을 만드세요.
const arr1 = [1, 2, 3];
const arr2 = [4, 5, 6];

const result2 = [ ...arr1 , ...arr2 ]
console.log( "[5] " +result2 );
// 6. greet 함수가 name 값을 받지 않으면 "Guest" 라고 출력하도록 만드세요.
const greet = (name) => `Hello, ${name}!`;

// 7. 객체를 만들 때 name, age 변수를 그대로 사용하세요.
const name2 = "Alice";
const age2 = 25;

const obj2 = { name2 , age2 }
// 8. 첫 번째 값을 first, 나머지를 rest에 저장하세요.
const numbers = [10, 20, 30, 40];

const [ first , ...rest ] = numbers;
// console.log( first );
// console.log( rest );
// 9. isLoggedIn이 true면 "Welcome!", false면 "Please log in."을 출력하세요.
const isLoggedIn = true;

console.log( isLoggedIn == true ? '[9] Welcome!' : '[9] Please login.');
// 10. 동기 fetch를 사용해서 JSONPlaceholder API에서 https://jsonplaceholder.typicode.com/posts/1 데이터를 가져오세요.
const fun2 = async ( ) => {
    try{
        const response = await axios.get(`https://jsonplaceholder.typicode.com/posts/1`);
        const data = response.data;
    }catch( error ) { console.log( error ); }
}
// 11. 배열 ages에서 각 나이를 기준으로 "성인" 또는 "미성년자"를 판단하여 새로운 배열을 만들어 출력하세요.
const ages = [25, 12, 20, 8];

const arr11 = ages.filter( ( value , index ) => {
    return value > 18;
} )
const arr12 = ages.filter( ( value , index ) => {
    return value <= 18;
} )
console.log( "[11] 성인배열 : " + arr11 );
console.log( "[11] 미성년자배열 : " + arr12 );
