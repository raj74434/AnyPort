import React, { useEffect, useState } from 'react'
import Navbar from '../components/Navbar'
import styles from '../stylee/login.module.css'
import { json } from 'react-router-dom';

function Login() {

  const[loginKey,setLoginKey]=useState();

  const [loginForm,setLoginForm]=useState({phone:"",
   password:""});

  const fillForm =(e)=>{
    const{name,value}=e.target;
    setLoginForm({...loginForm,[name]:value})
  }

  const doLogin=(e)=>{
    e.preventDefault();

    console.log(loginForm)

    const credentials = `${loginForm.phone}:${loginForm.password}`;
    const encodedCredentials = btoa(credentials);

   const key= fetch("http://localhost:8080/signIn",{
      method:"GET",
      headers:{
        "content-type":"application/json",
        'Authorization': `Basic ${encodedCredentials}`

      },
      
    })
    .then((r)=>{
      console.log(r.headers);
      console.log(r.headers.get("sessionId"));
      return r.json()})
    .then((d)=>{console.log(d)})
    .catch((m)=>{console.log(m)})
    // const sessionId = localStorage.getItem('sessionId');
    
    
    setLoginKey(key);

  }

  // useEffect(()=>{console.log(loginKey)},[loginKey])

  return (
    <div>
       <Navbar></Navbar>
       
      <div className={styles.Loginbody}>
      <h1>Happy to see you</h1>
       <form className={styles.loginform}>
        <input name='phone' onChange={fillForm} required="true" placeholder='Enter phone number' />
        <br/>
        <input name='password' onChange={fillForm} required="true" placeholder='Enter password'/>
        <br/>
        <button type='submit' onClick={doLogin}>Login</button>
       </form>
      </div>
      
    </div>
  )
}

export default Login
