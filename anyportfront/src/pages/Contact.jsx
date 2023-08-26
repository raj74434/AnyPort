import React from 'react'
import Navbar from '../components/Navbar'
import Footer from '../components/Footer'
import styles from '../stylee/contact.module.css'

function Contact() {
  return (
    <div> 
      <Navbar></Navbar>
      <div  >
        
        <div className={styles.contactBody} >
          <h1>Sorry for inconvenience</h1>
          <h3> - We will soon handle your request</h3>
          <img src='https://ggca.us/wp-content/uploads/Sad-Emoji.png.webp'/>       
           </div>
      </div>
      <Footer></Footer>
    </div>
  )
}

export default Contact
