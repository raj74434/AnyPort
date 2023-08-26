import React, { useEffect, useRef, useState } from 'react'
import Navbar from '../components/Navbar'
import Footer from '../components/Footer'
import styles from '../stylee/signup.module.css'
import Model from '../components/Model';
function Signup() {


  const [alert,setAlert]=useState(false);

  const hideAlert=()=>setAlert(false)
  // const showAlert=()=>setAlert(true)

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
      )
       
      
    }
    )
    .then((r)=>r.json())
    .then((d)=>{console.log(d)  })
    .catch((m)=>{
      setAlert(true)
      // console.log(m)
    });
   

  }
    
    


  return (
    <div>
      {alert && <Model hide={hideAlert}/>}
      <Navbar></Navbar>

      {alert && <Model hide={hideAlert} />}
      
      <div className={styles.signupbody}>
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

      <Footer></Footer>

    </div>
  )
}

export default Signup
