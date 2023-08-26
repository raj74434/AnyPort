import React,{useState} from 'react'
import Navbar from '../components/Navbar'
import styles from '../stylee/Order.module.css'
import Footer from '../components/Footer'
import Model from '../components/Model'

function Order() {

  const [alert,setAlert]=useState(false);

  const hideAlert=()=>setAlert(false)


  const orderNow=()=>{
    setAlert(true);
  }


  return (
    <div>
      {alert && <Model hide={hideAlert}/>}
      <div className={styles.orderbody}>
      <Navbar></Navbar>
      <div className={styles.orderComponents} >
        <h1>Order </h1>
        <div className={styles.orderTimeSelect}>
          <div className={styles.orderTime}>
            <h3> Deliver Now</h3>
            <p>This parcel assigned to nearest driver</p>
            <h2> Start from ₹ 50 </h2>
          </div>
        </div>

        <h2 className={styles.weightSelecttext}> Select Order Weight</h2>
        <select className={styles.weightSelect}>
          <option>upto 1kg</option>
          <option>upto 5kg</option>
          <option>upto 10kg</option>
          <option>upto 15kg</option>
        </select>

        <div className={styles.orderpickup}>
          <h3>Pickup Address</h3>
          <input placeholder=' House number and Socity '></input>
          <br/>
          <input className={styles.wholeAddress} placeholder='Enter land mark and Note for driver'  ></input>
          <h3>Active Mobile number</h3>
          <input placeholder='Enter mobile number'></input>
          <br/>
          
          <h3>Enter pincode of area</h3>
          <input placeholder='Enter picode here'></input>

        </div>

        <h1 className={styles.devideLine}>Sender |  <br/> |  <br/> | <br/> |  <br/> | <br/> | Reciver</h1>

{/* --------------------------- drop address */}

        <div className={styles.orderdrop}>
          <h3>Reciver Address</h3>
          <input placeholder=' House number and Socity '></input>
          <br/>
          <input className={styles.wholeAddress} placeholder='Enter land mark and Note for driver'  ></input>
          <h3>Active Mobile number</h3>
          <input placeholder='Enter mobile number'></input>
          <br/>
          
          <h3>Enter pincode of area</h3>
          <input placeholder='Enter picode here'></input>

        </div>
        
      </div>
      


    <button className={styles.submitOrder} onClick={()=>orderNow()}>Order Now</button>
      {/* order body ended here */}
      </div> 
      
      <Footer/>
      
    </div>
    
  )
}

export default Order
