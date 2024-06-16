import React, { useEffect, useState } from "react";
import Navbar from "../components/Navbar";
import Cookies from 'js-cookie';
import style from "../stylee/activeOrders.module.css"
const axios = require('axios');

function ActiveOrders() {
  const [orders, setOrders] = useState([]);

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const authCookie = Cookies.get("anyauth");
      const response = await axios.get('http://localhost:8080/customer/all/oldOrd', {
        headers: {
          'Authorization': `Bearer ${authCookie}`,
          'Content-Type': 'application/json'
        }
      });
      setOrders(response.data);
      console.log('API response on page load:', response.data);
    } catch (error) {
      console.error('Error fetching data on page load:', error);
    }
  };

  return (
    <div>
      <Navbar />
      <div>
        <div>
          <table>
            <thead>
              <tr>
                <th>Order ID</th>
                <th>Time</th>
                <th>Payment By</th>
                <th>Payment Type</th>
                <th>Price</th>
                <th>Status</th>
              </tr>
            </thead>
            <tbody>
              {orders.map((order) => (
                <tr key={order.orderId}>
                  <td className={style.td}>{order.orderId}</td>
                  <td className={style.td}>{order.orderPlacedTime}</td>
                  <td className={style.td}>{order.payment_by}</td>
                  <td className={style.td}>{order.payment_method}</td>
                  <td className={style.td}>{order.price}</td>
                  <td className={style.td}>{order.status}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
}

export default ActiveOrders;
