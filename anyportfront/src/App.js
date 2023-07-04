import logo from './logo.svg';
import './App.css';
import { Route, Router } from 'react-router-dom';
import Order from './pages/Order';
import Homepage from './pages/Homepage';
import Contact from './pages/Contact';
import Login from './pages/Login';
import Signup from './pages/Signup';
import React from "react"


function App() {
  return (
    <div >

      <Router>
        <Route path='' element={<Homepage></Homepage>}/>
        <Route path='/order' element={<Order></Order>}/>
        <Route path='/login' element={<Login></Login>}/>
        <Route path='/signup' element={<Signup></Signup>}/>
        <Route path="/support" element={<Contact></Contact>}/>
      </Router>
  
    </div>
  );
}

export default App;
