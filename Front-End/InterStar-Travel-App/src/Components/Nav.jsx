import { Link } from 'react-router-dom';
import Landing from './Landing';
import "./NavStyle.css";

function Nav() {


  return (
    <nav className="navbar fixed-top">
      <div className="container-fluid">
        <a className="navbar-brand" href="#" id="NavBarTitle">InterStar Travel</a>
        <Link to={"/"}>
        <button className="rounded-pill" id="formbutton">
          BECOME A VOYAGER 
        </button>
        </Link>
        <Link to={"/"}>
        <button className="navbar-toggler" type="button">
          <span className="navbar-toggler-icon"></span>
        </button>
        </Link>
        </div>
    </nav>
  );
}

export default Nav;