import logo from './logo.svg';
import './App.css';
import Navbar from './components/Navbar';
import { Route, Router } from 'react-router-dom';

function App() {
  return (
    <div >
      <Routers>

        <Route path='/login'/>
        <Route path='/signup'/>
        <Route path='/contact'/>
        <Route path='/order'/>


      </Routers>
    </div>
  );
}

export default App;
