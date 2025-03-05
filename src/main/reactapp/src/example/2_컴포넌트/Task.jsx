/* 
    리액트 과제1 : 아래 코드들을 사용하여 결과 예시 구현하여 제출
        조건1 : 두개의 컴포넌트 모두 활용
*/

const ProductCard = ( props ) => {
    console.log( props );
    return (<>
    </>)
  };
  
  export default function Task( props ) {
    const products = [
      { title: "무선 키보드", price: 45000, inStock: true },
      { title: "게이밍 마우스", price: 32000, inStock: false },
      { title: "27인치 모니터", price: 280000, inStock: true }
    ];
    return (<>
                {
                    products.map(
                        ( item , index ) =>
                        ( <li key = { index } > { item } </li>)
                    )
                }
    </>);
  }
