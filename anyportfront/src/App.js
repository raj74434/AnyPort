import logo from './logo.svg';
import './App.css';
import { Routes,Route } from 'react-router-dom';
import Order from './pages/Order';
import Homepage from './pages/Homepage';
import Contact from './pages/Contact';
import Login from './pages/Login';
import Signup from './pages/Signup';
import ActiveOrders from './pages/ActiveOrders';
import React from "react"


function App() {
  return (
    <div >
      <Routes>
        <Route path='' element={<Homepage></Homepage>}/>
        <Route path='/order' element={<Order></Order>}/>
        <Route path='/login' element={<Login></Login>}/>
        <Route path='/signup' element={<Signup></Signup>}/>
        <Route path="/support" element={<Contact></Contact>}/>
        <Route path="/activeOrders" element={<ActiveOrders></ActiveOrders>}/>
        <Route path="/activeOrders" element={<Contact></Contact>}/>
      </Routes>
  
    </div>
  );
}

export default App;
