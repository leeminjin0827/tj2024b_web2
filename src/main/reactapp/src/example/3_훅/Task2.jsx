import { useState } from "react"

/*
    리액트 과제3 : 리액트 전화번호부 만들기
        조건1 : (저장) '이름' 이랑 '전화번호' 입력받아 배열에 저장
        조건2 : (전체출력) 저장된 배열내 모든 정보(이름/전화번호)를 table 또는 ol 또는 ul 로 모두 출력하시오.
        조건3 : useState 사용.
    카카오톡 제출: ip로 제출
*/
const TableValue = ( {name , phone} ) => {
    return(
        <tr>
            <td> {name} </td>
            <td> {phone} </td>
        </tr>
    )
} // f end

export default function Task2(){
    const[ name , setName ] = useState('');
    const[ phone , setPhone ] = useState('');
    const[ count , setCount ] = useState([]);

    const save = ( e ) => {
        setCount( [ ...count , { name , phone} ] )
    } // f end
    const nameValue = ( e ) => {
        setName( e.target.value );
    } // f end
    const phoneValue = ( e ) => {
        setPhone( e.target.value );
    } // f end
    console.log( count );

    return(<>
        이름 : <input value={ name } onChange={ nameValue }/> <br/>
        전화번호 : <input value={ phone } onChange={ phoneValue }/> <br/>
        <button onClick={ save }> 등록 </button>
        <table>
            <thead>
                <tr>
                    <th>이름</th><th>전화번호</th>
                </tr>
            </thead>
            <tbody>
                {
                    count.map(
                        ( value , index ) =>
                        ( <TableValue key = { index } name = {value.name} phone = {value.phone } /> )
                    )
                }
            </tbody>
        </table>
    </>)
}