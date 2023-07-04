import logo from './logo.svg';
import './App.css';
import Navbar from './components/Navbar';
import { Route, Router } from 'react-router-dom';
import Order from './pages/Order';
import React from "react"


function App() {
  return (
    <div >

      <Router>
        <Route path='' element={<Order></Order>}/>
        <Route path='/login' element={<Login></Login>}/>
        <Route path='/signup' element={<Signup></Signup>}/>
        <Route path="/support" element={<Contact></Contact>}/>
      </Router>
  
    </div>
  );
}

export default App;
