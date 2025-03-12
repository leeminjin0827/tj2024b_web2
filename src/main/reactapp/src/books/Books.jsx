import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

export default function Books( props ){

        // 책 조회
        useEffect( () => {
            console.log('책 전체 조회 실행');
            BookRead();
        } , [] )
        const [ books , setBooks ] = useState([]);
        const BookRead = async ( ) => {
            const response = await axios.get('http://localhost:8081/book0312');
            console.log( response.data );
            setBooks( response.data );
        } // f end
    
        // 책 수정
        const [ bupdate , setBupdate ] = useState( { bno : '' , bname : '' , buser : '' , bmessage : '' , bpassword : '' } )
        const bUpate = async (bpassword) => {
            const inputPassword = prompt('등록할때 입력한 비밀번호를 입력하세요.');
            if( bpassword != inputPassword ){ alert('비밀번호가 틀립니다.'); return; }
            const bno = prompt('수정할 책번호를 입력하세요.');
            const bname = prompt('수정할 책제목를 입력하세요.');
            const buser = prompt('수정할 책저자를 입력하세요.');
            const bmessage = prompt('수정할 책내용를 입력하세요.');
            if( !bno || !bname || !buser || !bmessage ){ return; }
            try{
                const response = await axios.put('http://localhost:8081/book0312' , { bno , bname , buser , bmessage })
                if( response.data == true ){
                    alert('수정완료');
                    location.reload();
                }else{
                    alert('수정실패');
                } // if end
            }catch( error ) { console.log( error ); }
        } // f end
    
        // 책 삭제
        const [ bdelete , setBdelete ] = useState( { bno : '' })
        const bDelete = async (bno , bpassword) => {
            const inputPassword = prompt('등록할때 입력한 비밀번호를 입력하세요.');
            if( bpassword != inputPassword ){ alert('비밀번호가 틀립니다.'); return; }
            try{
                const response = await axios.delete(`http://localhost:8081/book0312?bno=${bno}`)
                if( response.data == true ){
                    alert('삭제완료');
                    location.reload();
                }else{
                    alert('삭제실패');
                } // if end
            }catch( error ) { console.log( error ); }
        } // f end

    return (<>
            <div id="booktable">
                <h1>책 전체 페이지</h1>
                <table>
                    <thead>
                        <tr>
                            <th>책 번호</th><th>책 제목</th><th>책 저자</th><th>기능</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            books.map( ( book , i ) => {
                                return(
                                    <tr key={ i }>
                                        <td><Link to={`/Book?bno=${book.bno}`}>{book.bno}</Link></td>
                                        <td><Link to={`/Book?bno=${book.bno}`}>{book.bname}</Link></td>
                                        <td><Link to={`/Book?bno=${book.bno}`}>{book.buser}</Link></td>
                                        <td>
                                            <button className="button2" onClick={ () => bUpate(book.bpassword) } type="button">수정</button>
                                            <button className="button2" onClick={ () => bDelete(book.bno , book.bpassword) } type="button">삭제</button>
                                        </td>
                                    </tr>
                                )
                            })
                        }
                    </tbody>
                </table>
            </div>
    </>)
} // c end