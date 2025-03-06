/* 
    리액트 과제1 : 아래 코드들을 사용하여 결과 예시 구현하여 제출
        조건1 : 두개의 컴포넌트 모두 활용
*/
import './Task.css'


// 컴포넌트란? 1.클래스형컴포넌트 | 2.함수형컴포넌트(*)
// ProductCard 컴포넌트 : 하나의 제품정보를 표현하는 UI 구역      (하위)
// Task 컴포넌트 : 여러개의 ProductCard 컴포넌트 포함하는 UI 구역 (상위)
// 1. 샘플 데이터로 간단한 화면구현
// 2. 'ProductCard' 재사용(재호출) 함으로써 HTML 코드 양 줄일 수 있다.
// 3. props : 하위 컴포넌트의 속성(매개변수) 전달
// 4. 반복문 이용한 하위 컴포넌트 호출
// 5. 목록 마크업들 에는 항상 key 속성 필수 ( 리액트는 ket 속성의 변화에 따라 자동으로 재렌더링(새로고침) ) - 주로 식별이 가능한 데이터
const ProductCard = ( {title , price , inStock } ) => {
    console.log( title , price , inStock );
    return (<>
      <li>
          <h2>{title}</h2>
          <p>가격: {price}</p>
          <div> {inStock ? <p className="on">재고 있음</p> : <p className="no">재고 없음</p> } </div>
      </li>
    </>)
  };

  export default function Task( props ) {
    const products = [
      { title: "무선 키보드", price: 45000, inStock: true },
      { title: "게이밍 마우스", price: 32000, inStock: false },
      { title: "27인치 모니터", price: 280000, inStock: true }
    ];
    return (<ul className="tasks">
                {
                    products.map(
                        ( item , index ) =>
                        ( <ProductCard key = { index } title = {item.title} price = {item.price} inStock = {item.inStock} ></ProductCard>)
                    )
                }
    </ul>);
  }
