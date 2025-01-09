import { Link } from 'react-router-dom';
import Landing from './Landing';
import "./NavStyle.css";

function Nav() {


  return (
    <nav className="navbar fixed-top">
      <div className="container-fluid">
        <a className="navbar-brand" href="#" id="NavBarTitle">InterStar Travel</a>
        <Link to={"/flights"}>
        <button className="rounded-pill" id="formbutton">
          <img src="./src/assets/luggage.png" alt="booking icon" className="nav-icon"/>
          BOOK A VOYAGE
        </button>
        </Link>
        <button className="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
          <span className="navbar-toggler-icon"></span>
        </button>
          {/* Off-Canvas Menu */}
          <div className="offcanvas offcanvas-end" tabIndex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
          <div className="offcanvas-header">
            <h5 className="offcanvas-title" id="offcanvasNavbarLabel">Menu</h5>
            <button type="button" className="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
          </div>
          <div className="offcanvas-body">
            <ul className="navbar-nav justify-content-end flex-grow-1 pe-3">
              <li className="nav-item">
                <Link className="nav-link" to="/">Home</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="#">Manage Booking</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="#">Destinations</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="#">Space Craft</Link>
              </li>
            </ul>
          </div>
        </div>
        </div>
    </nav>
  );
}

export default Nav;