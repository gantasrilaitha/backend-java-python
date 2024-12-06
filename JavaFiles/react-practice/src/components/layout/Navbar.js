import React, { Component } from 'react';
import { Link } from 'react-router-dom';
class Navbar extends Component {
  render() {
    return (
      <nav
        className="navbar navbar-expand-lg"
        style={{ backgroundColor: 'red' }}
      >
        <div className="container-fluid">
          <a
            className="navbar-brand d-flex align-items-center text-white"
            href="/"
          >
            <i className="fab fa-github fa-2x me-2"></i> {/* GitHub Icon */}
            <span style={{ fontSize: '1.5rem' }}>Github Finder</span> {/* Navbar Text */}
          </a>
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarNav"
            aria-controls="navbarNav"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav ms-auto">
              <li className="nav-item">
              <Link to='/'>Home</Link>
              </li>
              <li className="nav-item">
              <Link to='/about'>About</Link>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    );
  }
}

export default Navbar;
