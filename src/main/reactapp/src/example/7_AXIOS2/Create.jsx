import { useState } from "react";
import axios from 'axios';
import { Navigate, useNavigate } from "react-router-dom";

export default function Create ( props ){
    
    // 입력받은 데이터를 저장파는 폼 state 변수
    const [ Data , setData ] = useState( { name : '' , price : '' , comment : '' } )
    // 입력받은 데이터를 렌더링 하는 이벤트 함수
    const formDataChange = (e) => {
        console.log( e.target );
        console.log( e.target.name );
        console.log( e.target.value );
        setData( { ...Data , [e.target.name] : e.target.value } );
    } // f end

    const navigate = useNavigate();
    // 버튼 함수 // 현재 state 변수를 스프링 서버에게 보내기 AXIOS
    const onPost = async ( e ) => {
        const response = await axios.post( 'http://192.168.40.77:8080/day08/products' , Data )
        if( response.data == true ){
            alert('등록 성공!');
            navigate('/read');
        }else{
            alert('등록 실패!');
        }
    } // f end

    return(<>
        <div id="create">
            <h3>Create 페이지</h3>
            <form>
                제품명 : <input type="text" value={ Data.name } name="name" onChange={ formDataChange } /> <br/>
                제품가격 : <input type="text" value={ Data.price } name="price" onChange={ formDataChange } /> <br/>
                제품소개 : <input type="text" value={ Data.comment } name="comment" onChange={ formDataChange } /> <br/>
                <button type="button" onClick={ onPost }>등록</button>
            </form>
        </div>
    </>)
} // f end