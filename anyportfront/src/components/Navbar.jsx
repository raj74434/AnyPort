import React from 'react'
import {Link} from "react-router-dom"
import styles from "../stylee/navbar.module.css"

function Navbar() {
  return (
    <div className={styles.nav}>
      <div>
      <Link to="/" className={styles.link} > <h2>Anyport</h2></Link>
      </div>

      <div className={styles.navright}>
        <Link to="/support" className={styles.link}><h3 >Contact our team</h3></Link>
        <Link to="/order" className={styles.link} > <h3>Order</h3></Link>
        <Link to="/login" className={styles.link}><h3>Login</h3></Link>
        <Link to="/signup" className={styles.link}><h3>Signup</h3></Link>
      </div>
      
    </div>
  )
}

export default Navbar
