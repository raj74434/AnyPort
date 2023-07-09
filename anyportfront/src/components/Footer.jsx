import React from 'react'
import styles from '../stylee/footer.module.css'

function Footer() {
  return (
    <div>
      <div className={styles.footerbody}>  


        <div className={styles.footer1}>
          <h2>AnyPort</h2>
          <h3>Cities</h3>
          <h4>Delhi/NCR</h4>
          <h4>Banglore</h4>
          <h4>Pune</h4>
          <h4>Ahemdabad</h4>
        </div>
        
        <div>
          <h4>Become a deliver patner</h4>
          <h4>Privacy Policy</h4>
          <h4>Refund and Cancellation Resolution</h4>
        </div>

        <div>

          <h4>Business Inquery</h4>
          <h4>API Integartion</h4>
          <h4>FAQs</h4>
          <h4>Contacts</h4>
          <h4>Pricing</h4>
          <h4>Term and Conditions</h4>
        </div>



      </div>
      
    </div>
  )
}

export default Footer
