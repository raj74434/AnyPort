import React, { useEffect, useRef, useState } from 'react'
import Navbar from '../components/Navbar'
import styles from '../stylee/signup.module.css'
function Signup() {

  const[form,setForm]=useState({
    name:"",
    phone:"",
    gender:"",
    password:""
  });

  const fillForm=(e)=>{

    e.preventDefault();
    const {name,value}=e.target;
    
    setForm({...form,[name]:value});
    
  }

  useEffect(()=>{console.log(form)},[form])

  const doSignup=(e)=>{
    e.preventDefault();
    console.log(form);

   

    const d= fetch("http://localhost:8080/signup",
    {
      method:"POST",
      
      headers:{"content-type":"application/json"},
      body:JSON.stringify(
        form
        // name:form.name,
        // phone:form.name,
        // gender:form.gender,
        // password:form.password
      )
       
      
    }
    )
    .then((r)=>r.json())
    .then((d)=>{console.log(d)  })
    .catch((m)=>{console.log(m)});
   

  }
    
    
  //   fetch("http://localhost:8080/check")
  //   .then((response) => response.json())
  //   .then((data) => {
  //     console.log(data);
  //   })
  //   .catch((error) => {
  //     console.log(error);
  //   });

  // 



  return (
    <div>
      <div className={styles.signupbody}>
      <Navbar></Navbar>
      <h1>Signup</h1>
      <form className={styles.signupform}>
        <input name="name" onChange={fillForm} required="true" type='text' placeholder='Enter your name'/>
        <br/>
        <input name='phone' onChange={fillForm} required="true" type='number' placeholder='Enter your number' />
        <br/>
        <select onChange={fillForm} name="gender">
          <option value=""  >Choose gender</option>
          <option value="Male">Male</option>
          <option value="Female">Female</option>
        </select>
        <br/>
        <input name='password' onChange={fillForm} required="true" type='password' placeholder='Enter your password' />
        <br/>
        <button type='submit' onClick={doSignup} >Signup</button>
      </form>
      </div>
    </div>
  )
}

export default Signup
