import React, { useEffect, useState,useContext } from 'react'
import Navbar from '../components/Navbar'
import Footer from '../components/Footer'
import styles from '../stylee/login.module.css'
import { json } from 'react-router-dom';
import Model from '../components/Model';
import {AuthContext} from "../context/AuthContext"
import Cookies from 'js-cookie';
const axios = require('axios');


function Login() {

  const {login,isAuth}=useContext(AuthContext);

  const [alert,setAlert]=useState(false);

  const hideAlert=()=>setAlert(false)

 

  const [loginForm,setLoginForm]=useState({phone:"",
   password:""});

  const fillForm =(e)=>{
    const{name,value}=e.target;
    setLoginForm({...loginForm,[name]:value})
  }



  const setCookie = (name, value, days) => {
    Cookies.set(name, value, { expires: 7 });
  };

  const doLogin=(e)=>{
    e.preventDefault();

    console.log(loginForm)

    const credentials = `${loginForm.phone}:${loginForm.password}`;
    const encodedCredentials = btoa(credentials);

  axios.get("http://localhost:8080/signIn", {
  headers: {
    "content-type": "application/json",
    'Authorization': `Basic ${encodedCredentials}`
  }
})
    .then((r)=>{
      console.log(r.headers.authorization);   
      if(r.headers.authorization != undefined )
      login(r.headers.authorization)
      setCookie("anyauth", r.headers.authorization, 7);
      window.location.href="http://localhost:3000/order"
    })
    .then((d)=>{console.log(d)})
    .catch((m)=>{console.log(m)})
    

  }

  // useEffect(()=>{console.log(loginKey)},[loginKey])

  return (
    <div>
       <Navbar></Navbar>
       {alert && <Model hide={hideAlert}/>}
      <div className={styles.Loginbody}>
        <h2>{isAuth}</h2>
      <h1>Happy to see you</h1>
       <form className={styles.loginform}>
        <input name='phone' onChange={fillForm} required="true" placeholder='Enter phone number' />
        <br/>
        <input name='password' onChange={fillForm} required="true" placeholder='Enter password'/>
        <br/>
        <button type='submit' onClick={doLogin}>Login</button>
       </form>
      </div>
      <Footer></Footer>
    </div>
  )
}

export default Login
