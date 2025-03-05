/* 
    리액트 과제1 : 아래 코드들을 사용하여 결과 예시 구현하여 제출
        조건1 : 두개의 컴포넌트 모두 활용
*/
import './Task.css'

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
