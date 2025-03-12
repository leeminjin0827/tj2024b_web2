import axios from "axios";
import { useEffect, useState } from "react"

export default function Book( props ){

    // 책 개별 조회
    useEffect( () => {
        oneBook();
    } , [] )
    const [ books , setBooks ] = useState('');
    const oneBook = async ( ) => {
        const response = await axios.get(`http://localhost:8080/book0312/view?bno=${bno}`)
    }

    // 댓글 조회
    useEffect( () => {
        console.log( '개별조회 실행');
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
                <p>책번호</p>
                <p>책제목</p>
                <p>책저자</p>
                <p>책소개</p>
            </span>
            <div>
                <p>댓글번호</p>
                <p>댓글내용</p>
            </div>
        </div>
    </>)
} // f end