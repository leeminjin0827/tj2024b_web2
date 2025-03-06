import { useState } from "react"

export default function Task1() {
    
    // (1) 여기에 state 변수 만들기
    // const[ 변수명 , set변수명 ] = useState(초기값);
        // - 변수명 : 아무거나.(임의)
        // - set변수명 : set변수명 (카멜표기법)
        // - = useState( 초기값 ) : 모든 자료 가능(모든타입)
    const[ msg , setMsg ] = useState('');

    const[ count , setCount ] = useState('');
    const 저장함수 = ( e ) => {
        // count.push( msg ); // 입력받은 값이 저장된 state인 'msg'를 count 저장
        // setCount( count ); // 불가능하다.

        // 기본타입 자료는 리터럴이라서 그 값 그자체 -> 기본타입 자료가 변경되면 그 값 그자체 변경
        // 참조타입( 포장지 ) 자료는 안에 있는 자료가 변경해도 -> 참조타입 자체는 변경되지 않았다.
        // 배열 복제 // 자료의 주소값 새롭게 생성 // 1. map | 2. ...스프레드 연산자
        setCount( [...count , msg ] )
        // setCount( (count) => [ ...count , msg ] )
    } // f end

    const handleChange = (event) => {
        // (2) 여기에서 state 변수값 수정하기.
        setMsg ( event.target.value ); // input -> onChange -> handleChange
    } // f end

    console.log( count ); // 확인

    return (
        <>
            <h1> input에 입력하면 실시간으로 글자 수 세기</h1>
            <input value = { msg } onChange = { handleChange } />
            <p>글자 수: { msg.length } </p>

            <h1> 입력받은 값 배열에 저장 </h1>
            <button onClick={ 저장함수 }> 저장 </button>
        </>
    )
}