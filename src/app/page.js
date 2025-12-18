import Image from "next/image";
import styles from "./page.module.css";
import React from "react";
import TopNav from "./components/TopNav";

 function App() {
  return (
   <div className="APP">
    <TopNav/>
    <h1>Welcome to my Booking Site</h1>
   </div>
  );
}
