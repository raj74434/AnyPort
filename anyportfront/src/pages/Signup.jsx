import React from 'react'
import Navbar from '../components/Navbar'
import styles from '../stylee/signup.module.css'
function Signup() {
  return (
    <div>
      <div className='signupbody'>
      <Navbar></Navbar>
      <h1>Signup</h1>
      <form className='signupform'>
        <input required="true" type='text' placeholder='Enter your name'/>
        <br/>
        <input required="true" type='number' placeholder='Enter your number' />
        <br/>
        <select>
          <option>Male</option>
          <option>Female</option>
        </select>
        <br/>
        <input required="true" type='password' placeholder='Enter your password' />
        <br/>
        <button type='submit' >Signup</button>
      </form>
      </div>
    </div>
  )
}

export default Signup
