import { BrowserRouter, Link, Route, Routes } from "react-router-dom";

import './app.css'
import Books from "./Books";
import BookWrite from "./BookWrite";
import Home from "./Home";
import Book from "./BookView";
export default function App( props ){

    return(<>
        <BrowserRouter>
            <div id="wrap">
                <button className="button1"><Link to="/">메인으로</Link></button>
                <button className="button1"><Link to="/BookWrite">책 등록하기</Link></button>
                <button className="button1"><Link to="/Books">책 둘러보기</Link></button>
                <Routes>
                    <Route path="/" element={ <Home /> } />
                    <Route path="/BookWrite" element={ <BookWrite /> } />
                    <Route path="/Books" element={ <Books /> } />
                    <Route path="/Book" element={ <Book /> } />
                </Routes>
            </div>
        </BrowserRouter>
    </>)
} // f end