import React from 'react'
import Navbar from '../components/Navbar'
import styles from'../stylee/homepage.module.css'
import Footer from '../components/Footer'

function Homepage() {
  return (
    <div className={styles.homebody}>
      <Navbar></Navbar>
      <div className={styles.homecomponents}>
      <div className={styles.head}>

        <div className={styles.headleft}>
          <h1>Hello Anyport family</h1>
         <form action="" className={styles.homeparcelform}>
          <input type='text' placeholder='Parcel Pickup location' />

          <br/>
          <input type='text' placeholder='Parcel Drop location'/>
          <br/>
          <button type='submit'><h3>Get fair</h3></button>
         </form>
        </div>

         <div className={styles.headright}>
          <img src='https://img.freepik.com/premium-vector/gray-icon-free-delivery-white-background-vector-illustration_476325-185.jpg?w=740' alt='logo' />
        </div>
      </div>


      {/* Middle part of home page start from here */}

      <div className={styles.homemiddle}>
        <h1>Deliver What you want and When you want</h1>
        <div className={styles.services}>
          <img src='https://thumbs.dreamstime.com/b/stacking-parcels-boxes-kraft-paper-isolated-white-42028852.jpg?w=992' alt='parcel logo'/>
          <img src='https://www.shutterstock.com/image-vector/birthday-cake-chocolate-creme-red-260nw-1350965693.jpg' alt='cake photo'/>
          <img src='https://static.vecteezy.com/system/resources/previews/008/025/077/original/flower-icon-clipart-with-outline-in-cartoon-animation-lotus-image-using-white-background-vector.jpg' alt='flower image'/>
          <img src='https://previews.123rf.com/images/esheluxina/esheluxina1802/esheluxina180200064/96441665-vector-cartoon-illustration-of-a-guy-showing-documents-in-a-flat-style.jpg' alt='documents'/>
        </div>
        <h1>Avalable payment methods</h1>
      <div className={styles.payment}>
        <img src='data:image/png;base64,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'/>
        <img src='https://www.svgrepo.com/show/113443/credit-card-payment.svg' alt='card'/>
        <img src='https://pic.onlinewebfonts.com/svg/img_281585.png' alt='wallet'/>
      </div>
      </div>

      <Footer></Footer>
     

{/* ------------- */}

      </div>


    </div>
  )
}

export default Homepage
