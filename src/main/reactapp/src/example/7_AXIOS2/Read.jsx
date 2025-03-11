import { useEffect, useState } from "react"
import axios from 'axios';

export default function Read ( props ){
    
    // [1] 컴포넌트 최초 실행될때 (딱 1번) 실행하는 생명주기 함수 , useEffect( () => {} , [] )
    useEffect( () => {
        console.log('여기는 컴포넌트 실핼될때 딱 1번만 호출됩니다.');
        onRead(); // 컴포넌트가 열릴때 AXIOS 통신하여 데이터를 가져온다.
    } , [] )

    // [2] axios 이용하여 서버와 통신한다.
    const onRead = async ( ) => {
        const response = await axios.get( 'http://192.168.40.77:8080/day08/products')
        console.log( response.data );
        setproducts( response.data ); // 서버로부터 받은 모든 제품정보를 상태변수에 저장한다.
    } // end


    // [3] 서버로 부터 받은 결과를 저장하는 상태 변수
    const [ products , setproducts ] = useState([]);
    console.log( products ); 

    return(<>
        <div id="read">
            <h3>Read 페이지</h3>
            <table>
                <thead><tr><th>제품번호</th><th>제품명</th><th>가격</th><th>내용</th></tr></thead>
                <tbody>
                    {
                        products.map( ( product , index ) => {
                            return(
                                <tr key={ index }>
                                    <td> { product.id }</td>
                                    <td> { product.name }</td>
                                    <td> { product.price }</td>
                                    <td> { product.comment }</td>
                                </tr>
                            )
                        })
                    }
                </tbody>
            </table>
        </div>
    </>)

} // f end