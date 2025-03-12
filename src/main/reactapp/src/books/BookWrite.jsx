import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

export default function BookWrite( props ){

    // 책 등록
    const [ bvalue , setBvalue ] = useState( { bname : '' , buser : '' , bmessage : '' , bpassword : '' } )
    const navigate = useNavigate();
    const formChange = ( e ) => {
        console.log( e.target );
        console.log( e.target.name );
        console.log( e.target.value );
        setBvalue( { ...bvalue , [e.target.name] : e.target.value } );
        } // f end
        const onPost = async ( e ) => {
        const response = await axios.post('http://localhost:8080/book0312' , bvalue)
        if( response.data ) {
            alert('책 등록 완료');
            navigate('/Books');
        }else{
            alert('책 등록 실패');
        }
    } // f end

    return(<>
            <div id="bInput">
                    <h1>책 등록</h1>
                    <form>
                        제목 : <input name="bname" onChange={ formChange } type="text"/> <br/>
                        저자 : <input name="buser" onChange={ formChange } type="text"/> <br/>
                        비밀번호 : <input name="bpassword" onChange={ formChange } type="text"/> <br/>
                        소개 : <textarea name="bmessage" onChange={ formChange }/> <br/>
                        <button className="button3" onClick={ onPost } type="button">등록</button>
                    </form>
            </div>
    </>)
} // f end