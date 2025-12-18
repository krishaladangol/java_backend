import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import MenuBar from "./MenuBar";

const About = () => <div>About Us Page</div>;
const Bookings = () => <div>Bookings Page</div>;
const Services = () => <div>Services Page</div>;
const Contact = () => <div>Contact Page</div>;

export default function App() {
  return (
    <Router>
      <MenuBar />
      <Routes>
        <Route path="/about" element={<About />} />
        <Route path="/bookings" element={<Bookings />} />
        <Route path="/services" element={<Services />} />
        <Route path="/contact" element={<Contact />} />
        <Route path="*" element={<div>404 - Page Not Found</div>} />
      </Routes>
    </Router>
  );
}
