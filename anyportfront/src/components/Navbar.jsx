import React from 'react'
import {Link} from "react-router-dom"

function Navbar() {
  return (
    <div className={StyleSheet.nav}>
      <div>
      <Link to="/contact"> <h1>Anyport</h1></Link>
      </div>

      <div>
        <Link to="/contact"><h2>Contact our team</h2></Link>
        <Link to="/order" > <h2>Order</h2></Link>
        <Link to="/login"><h2>Login</h2></Link>
        <Link to="/signup"><h2>Signup</h2></Link>
      </div>
      
    </div>
  )
}

export default Navbar
