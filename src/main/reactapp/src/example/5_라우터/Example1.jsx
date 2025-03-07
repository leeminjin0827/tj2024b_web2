/*
    [리액트 라우터]
        - 리액트는 SPA(싱글페이지애플리케이션) = HTML1개 = HTML 전환 X
            -> 컴포넌트 전환/변경 지원한다. --> React Router
        - 리액트는 폴더내 index.html 이라는 html 1개 존재 : HTTP URL 1개 이다. localhost:1537
            -> 컴포넌트의 HTTP 가상 URL 만들고 가상URL 요청하므로써 컴포넌트 전환/변경 지원한다.

        1. 정의 : 싱글 페이지 애플리케이션(SPA) 방식에서 화면 이동 시 새로고침 없이 컴포넌트 변경 지원
        2. 설치 : npm( node.js 제공하는 외부 라이브러리 설치/관리 프로글매 <---> 그레이들과 비슷 )
            (서버 꺼져있는 상태) 리액트 프로젝트 터미널 'npm i react-router-dom' 입력한다.
            설치후 서버 재실행
        3. 사용법
            1. 모든 컴포넌트 연결 할수 있는 (라우터)컴포넌트 필요하다.

                            -------> A컴포넌트
            (라우터)컴포넌트 -------> B컴포넌트
                            -------> C컴포넌트
            
            2. 라우터 관련 컴포넌트 import

            3. 연결할 컴포넌트들을 <BrowerRouter> 로 감싼다.

            4. 연결할 각 컴포넌트들의 가상 URL 정의한다.

            5. <a> 대신에 <Link> 컴포넌트 이용한 이동 이벤트
                - 일반방식 <a href="이동할경로"> </a> : HTTP GET 방식 적용되므로 우선위가 라우터가 아닌 REST 적용
                - 라우터방식 <Link to="(가상)이동할경로"> </Link> : HTTP GET 방식 아닌 리액트라우터가 적용된다.
*/
import { BrowserRouter , Routes , Route , Link, useNavigate } from 'react-router-dom';
function Home( props ){ return(<> 메인페이지 </>) }
function About( props ){ return (<> 소개페이지 </>)}

import{ useSearchParams , useParams } from 'react-router-dom';

function Mypage( props ){

    // 기존 queryString 방식
        // const name = new URL( location.href ).searchParams.get("name");
        // const age = new URL( location.href ).searchParams.get("age");
    // 리액트 queryString 방식
    // 1. import { useSearchParams } from 'react-router-dom';
    // 2. const [ searchParams ] = useSearchParams();
    // 3. searchParams.get('key');      // localhost:1537?hey=value&key=value
    const [ searchParams ] = useSearchParams(); // 쿼리스트링 가져오기
    const name = searchParams.get('name');
    const age = searchParams.get('age');

    return(<>
        <h3> 마이 페이지 </h3>
        <p> 이름 : {name || '정보 없음' } </p>
        <p> 나이 : {age || '정보 없음' } </p>
    </>)
}
function Product( props ){
    // 리액트 path 방식
    // 1. import { useSearchParams } from 'react-router-dom';
    // 2. const { 변수명1 , 변수명2 } = useParams(); 
        // path 방식 : localhost:5173/product/코카콜라/1500             -> useParams()
        // queryString 방식 : localhost:5173?name=코카콜라&price=1500   -> useSearchParams()
    const { name , price } = useParams();
    return(<>
        <h3> 제품 상세 페이지 </h3>
        <p> 제품명 : { name || '정보 없음' } </p>
        <p> 가격 : { price || '정보 없음' } </p>
    </>)
} 
function Page404() { // HTTP의 404 오류는 '경로가 존재하지 않다.'

    // (1) 기존방식 : location.href = ''
    const onHome1 = ( ) => { location.href='/' }
    // (2) 리액트 라우터방식 :
        // 1. import { useNavigate } from 'react-router-dom';
        // 2. const navigate = useNavigate();
        // 3. navigate('이동할경로')
    const navigate = useNavigate();
    const onHome2 = ( ) => { navigate('/') }

    return(<>
        <h3> 존재하지 않는 페이지 입니다. </h3>
        <button onClick={ onHome1 } > 홈으로1 </button>
        <button onClick={ onHome2 } > 홈으로2 </button>
        <a href="/"> 홈으로3 </a>
        <Link to="/"> 홈으로4 </Link>
    </>)
}

// 전체를 연결하는 컴포넌트 = 라우터 컴포넌트
export default function App( props ){
    return(<>
        <BrowserRouter>
            <ul>
                <a href="/"> 메인페이지(HOME) </a> <br/>
                <a href="/about"> 소개페이지(aboug) </a> <br/>
                <Link to="/" > 메인페이지(HOME / 라우터방식) </Link> <br/>
                <Link to="/about" > 소개페이지(about / 라우터방식) </Link> <br/>
                <Link to="/mypage?name=유재석&age=40"> 마이페이지</Link> <br/>
                <Link to="/product/cola/1500" > 제품상세 </Link>
            </ul>
            <Routes>
               <Route path="/" element = { <Home /> } />            { /* localhost:5137 요청하면 home 컴포넌트가 열린다. */}
               <Route path="/about" element = { <About /> } />      { /* localhost:5137 요청하면 About 컴포넌트가 열린다. */ } 
               <Route path="/mypage" element = { <Mypage /> } />
               <Route path="/product/:name/:price" element = { <Product /> } />
               
               { /* 만약에 존재하지 않는 가상URL 요청하면 Page404 컴포넌트가 열린다. // path="*" = 모든URL */}
               <Route path="*" element = { <Page404 /> }> </Route>
               
            </Routes>
            
        </BrowserRouter>
    </>)
}