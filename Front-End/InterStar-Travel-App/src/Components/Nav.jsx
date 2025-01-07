import { Link } from 'react-router-dom';
import Landing from './Landing';
import "./NavStyle.css";

function Nav() {
  return (
    <nav className="navbar fixed-top">
      <div className="container-fluid">
        <a className="navbar-brand" href="#" id="NavBarTitle">InterStar Travel</a>
        <button className="rounded-pill" id="formbutton">
          BECOME A VOYAGER 
        </button>
        <button className="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
          <div className="offcanvas-header">
            <h5 className="offcanvas-title" id="offcanvasNavbarLabel">InterStar Travel</h5>
            <button type="button" className="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
          </div>
          <div className="offcanvas-body">
            <ul className="navbar-nav nav-pills justify-content-end flex-grow-1 pe-3">
              <li className="nav-item">
                <Link className="nav-link active rounded-pill" to="/sign-in">
                  Sign In
                </Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link rounded-pill" to="/book-flight">
                  Book a Flight
                </Link>
              </li>
              <li className="nav-item dropdown">
                <Link className="nav-link rounded-pill" to="#">
                  Destinations
                </Link>
              </li>
              <li className="nav-item dropdown">
                <Link className="nav-link rounded-pill" to="#">
                  Space Craft
                </Link>
              </li>
            </ul>
            <form className="d-flex mt-3" role="search">
              <input className="form-control me-2" type="search" placeholder="Search" aria-label="Search" />
              <button className="btn btn-outline-success" type="submit">Search</button>
            </form>
          </div>
        </div>
      </div>
    </nav>
  );
}

export default Nav;