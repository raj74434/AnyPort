import React from 'react'
import Navbar from '../components/Navbar'
import styles from '../stylee/login.module.css'

function Login() {
  return (
    <div>
       <Navbar></Navbar>
       
      <div className='Loginbody'>
      <h1>Happy to see you</h1>
       <form className='loginform'>
        <input required="true" placeholder='Enter phone number' />
        <br/>
        <input required="true" placeholder='Enter password'/>
        <br/>
        <button type='submit'>Login</button>
       </form>
      </div>
      
    </div>
  )
}

export default Login
