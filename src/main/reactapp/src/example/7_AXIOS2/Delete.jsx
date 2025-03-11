import axios from "axios";
import { useState } from "react"
import { Navigate, useNavigate } from "react-router-dom";

export default function Delete ( props ){

    const [ Data , setData ] = useState('');
    const formDataChange = (e) => {
        console.log( e.target );
        console.log( e.target.name );
        console.log( e.target.value );
        setData( e.target.value );
    } // f end

    const navigate = useNavigate();

    const onDelete = async ( e ) => {
        console.log( Data );
        try{
            const response = await axios.delete( `http://192.168.40.77:8080/day08/products?id=${ Data }`)
            console.log( response );
            if( response.data == true ){
                alert('삭제 성공!');
                navigate('/read');
            }else{
                alert('삭제 실패!');
            }
        }catch( error ) { console.log( error ); } 
    } // f end

    return(<>
        <div id="delete">
            <h3>Delete 페이지</h3>
            <form>
                삭제할 제품 번호 : <input type="text" value={ Data } name="id" onChange={ formDataChange }/><br/>
                <button type="button" onClick={ onDelete }>삭제</button>
            </form>
        </div>
    </>)
} // f end