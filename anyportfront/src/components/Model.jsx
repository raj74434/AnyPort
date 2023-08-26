import React, { useState } from 'react'
import styles from '../stylee/popup/models.module.css'

// It give alert to user on server down



function Model(props) {

     

  return (
    
    < >
      <div className={styles.back}></div>
    <div className={styles.model}>
      <h1>Server is down</h1>
      <h3>Sorry for inconvenience. Please contact to admin</h3>
      <button className={styles.popupBtn} onClick={()=>props.hide()}>OK</button>
    </div>
    </>
    
  )
}

export default Model
