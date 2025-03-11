import { useState } from "react"
import axios from "axios";
import { Navigate, useNavigate } from "react-router-dom";

export default function Update ( props ){

    // 저장하는 폼 변수
    const [ Data , setData ] = useState( { id : '' , name : '' , price: '' , comment: '' } );
    // 입력받은 데이터를 렌더링 하는 함수
    const formFromData = ( e ) => {
        console.log( e.target );
        console.log( e.target.name );
        console.log( e.target.value );
        setData( { ...Data , [e.target.name] : e.target.value } );
    } // f end

    const navigate = useNavigate();
    // 현재 state 변수를 스프링서버에게 보내기.AXIOS
    const onPut = async ( e ) => {
        try{
            const response = await axios.put( 'http://192.168.40.77:8080/day08/products' , Data )
            console.log( response );
            if( response.data == true ){
                alert('수정 성공!');
                navigate('/read');
            }else{
                alert('수정 실패!');
            }
        }catch( error ) { console.log( error ); }
    } // f end

    return(<>
        <div id="update">
            <h3>Update 페이지</h3>
            <form>
                제품번호 : <input type="text" name="id" onChange={ formFromData }/><br/>
                제품명 : <input type="text" name="name" onChange={ formFromData }/><br/>
                제품가격 : <input type="text" name="price" onChange={ formFromData }/><br/>
                제품소개 : <input type="text" name="comment" onChange={ formFromData }/><br/>
                <button type="button" onClick={ onPut } >수정</button>
            </form>
        </div>
    </>)
} // f end