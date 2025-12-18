"use client";

import React from "react";
import {
  Box,
  Button,
  ButtonGroup,
  FormLabel,
  TextField,
  MenuItem,
  Grid2,
} from "@mui/material";
   
  
export default function Form() {

  const countries = [
"Afghanistan",
"Australia",
"Argentina",
"Brazil",
"Canada",
"China",
"Chile",
"Denmark",
"Egypt",
"Finland",
"Germany",
"Greece",
"Honduras",
"India",
"Japan",
"Kenya",
"Lebanon",
"Mexico",
"Nepal",
"Norway",
"Portugal",
"South Korea",
"Turkey",
"United States",
"United Kingdom",
"Vietnam",
"Zimbabwe",


  ];
  const genders = ["Male", "Female", "Others"];

  return (
    <Box
      sx={{
        padding: 5,
        maxWidth: 1000,
        display:"flex",
        justifyContent:"center",
        alignItems:"center",
        height:"100vh" ,    
           margin: " auto",
        backgroundColor: "lightpink",
        borderRadius: 2,
        boxShadow: 3,
      }}
    >
      
      <form>
        <Grid2 container direction="column" spacing={2}>
          {/* First Name */}
          <Grid2 item xs={12} >
            <FormLabel>First Name</FormLabel>
            <TextField size="small" fullWidth />
          </Grid2>
          {/* Middle Name */}
          <Grid2 item xs={12} >
            <FormLabel>Middle Name</FormLabel>
            <TextField size="small" fullWidth />
          </Grid2>
          {/* Last Name */}
          <Grid2 item xs={12}>
            <FormLabel>Last Name</FormLabel>
            <TextField size="small" fullWidth />
          </Grid2>
          {/* Address */}
          <Grid2 item xs={12} >
            <FormLabel>Address</FormLabel>
            <TextField size="small" fullWidth />
          </Grid2>
          {/* Username
          <Grid2 item xs={12}>
            <FormLabel>Username</FormLabel>
            <TextField size="small"fullWidth />
          </Grid2> */}
          {/* Email */}
          <Grid2 item xs={12}>
            <FormLabel>Email</FormLabel>
            <TextField size="small"fullWidth />
          </Grid2>
          {/* Phone Number */}
          <Grid2 item xs={12} >
            <FormLabel>Phone Number</FormLabel>
            <TextField size="small"fullWidth />
          </Grid2>
         
          {/* Gender */}
          <Grid2 item xs={12} sm={3}>
            <FormLabel>Gender</FormLabel>
            <TextField size="small" select fullWidth>
              {genders.map((gender) => (
                <MenuItem key={gender} value={gender}>
                  {gender}
                </MenuItem>
              ))}
            </TextField>
          </Grid2>
          {/* Age */}
          <Grid2 item xs={12} sm={3}>
            <FormLabel>Age</FormLabel>
            <TextField size="small" type="number" fullWidth />
          </Grid2>
          {/* State Source */}
          <Grid2 item xs={12}>
            <FormLabel>Source State</FormLabel>
            <TextField size="small"select fullWidth>
              {countries.map((countries) => (
                <MenuItem key={countries} value={countries}>
                  {countries}
                </MenuItem>
              ))}
            </TextField>
          </Grid2>
          {/* State Destination */}
          <Grid2 item xs={12} >
            <FormLabel>Destination State</FormLabel>
            <TextField size="small"select fullWidth>
              {countries.map((countries) => (
                <MenuItem key={countries} value={countries}>
                  {countries}
                </MenuItem>
              ))}
            </TextField>
          </Grid2>
          <Button
          variant="contained"
          color="primary"
          fullWidth
          style={{ marginTop: "20px" }}
          
        >
          Next
        </Button>
        </Grid2>
      </form>
    </Box>
  );
}
