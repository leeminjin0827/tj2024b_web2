import axios from "axios";
import { useEffect, useState } from "react"

export default function Book( props ){

    const params = new URLSearchParams(window.location.search);
    const bno = params.get('bno');
    console.log( bno );

    // 책 개별 조회
    useEffect( () => {
        console.log( '책조회 실행');
        oneBook();
    } , [] )
    const [ books , setBooks ] = useState('');
    const oneBook = async ( ) => {
        const response = await axios.get(`http://localhost:8080/book0312/view?bno=${bno}`)
        setBooks( response.data );
    } // f end

    // 댓글 조회
    useEffect( () => {
        console.log( '댓글조회 실행');
        oneRead();
    } , [] )
    const [ reads , setReads ] = useState([]);
    const oneRead = async ( ) => {
        const response = await axios.get(`http://localhost:8080/book0312/comment?bno=${bno}`)
        console.log( response.data );
        setReads( response.data );
    } // f end

    return(<>
        <h1>책 개별조회</h1>
        <div id="book">
            <span>
                <p>책 번호 : {books.bno}</p>
                <p>책 제목 : {books.bname}</p>
                <p>책 저자 : {books.buser}</p>
                <p>책 소개<br/><br/>{books.bmessage}</p>
            </span>
            <div className="comment">
                <h2>댓글</h2>
                    {
                        reads.map( ( read , i ) => {
                            return(
                                <div>
                                    <p>리뷰번호 : { read.cno }</p>
                                    <p>리뷰내용 : { read.cmessage }</p>
                                </div>
                            )
                        })                        
                    }
            </div>
        </div>
    </>)
} // f end