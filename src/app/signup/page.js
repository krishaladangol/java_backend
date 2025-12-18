"use client"

import { useState } from "react";
import { Box, Button, IconButton, TextField, Typography } from "@mui/material";
import axios from "axios";
import PersonIcon from '@mui/icons-material/Person';
import Visibility from '@mui/icons-material/Visibility'; // For showing password
import VisibilityOff from '@mui/icons-material/VisibilityOff'; // For hiding password
import { InputAdornment } from "@mui/material";
import { addSignUpData } from "../util/Api";
export default function Signup() {
  const [formData, setFormData] = useState({ username: "", email: "", password: "" });
  const [error, setError] = useState("");
  const [success, setSuccess] = useState("");
  const [showPassword, setShowPassword] = useState(false); 

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
    setError("");
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post("/signup", formData); // Adjust your backend endpoint
      setSuccess(response.data.message);
    } catch (err) {
      setError(err.response?.data?.message || "An error occurred.");
    }
    const response = await addSignUpData(formData);
  };
  const handleClickShowPassword = () => {
    setShowPassword(!showPassword);
  };
  

  return (
    <Box
      display="flex"
      justifyContent="center"
      alignItems="center"
      height="100vh"
      bgcolor="#f4f6f8" // Light background color for the page
      position="relative"
    >
      {/* Background Image */}
      <Box
        position="absolute"
        top={0}
        left={0}
        right={0}
        bottom={0}
        zIndex={-1}
        sx={{
         
           backgroundSize: "cover",
          backgroundPosition: "center",
          opacity: 0.5,
        }}
      />
      
      {/* Signup Form */}
      <Box
        bgcolor="white"
        p={4}
        borderRadius={3}
        boxShadow={3}
        width={400}
        sx={{
          display: 'flex',
          flexDirection: 'column',
          justifyContent: 'center',
        }}
      >
        {/* Person Icon at the top */}
        <Box textAlign="center" mb={3}>
          <IconButton
            sx={{
              backgroundColor: '#1976d2', // Blue background for the icon
              borderRadius: '50%',
              padding: 2,
              boxShadow: 2,
            }}
          >
            <PersonIcon sx={{ fontSize: 60, color: 'white' }} />
          </IconButton>
        </Box>
        <Typography variant="h4" align="center" gutterBottom>
          Sign Up
        </Typography>

        {/* Username Field */}
        <TextField
          label="Username"
          variant="outlined"
          name="username"
          fullWidth
          margin="normal"
          value={formData.username}
          onChange={handleChange}
        />

        {/* Email Field */}
        <TextField
          label="Email"
          variant="outlined"
          name="email"
          fullWidth
          margin="normal"
          value={formData.email}
          onChange={handleChange}
        />

       {/* Password Field */}
       <TextField
          label="Password"
          variant="outlined"
          name="password"
          type={showPassword ? "text" : "password"} // Toggle password visibility
          fullWidth
          margin="normal"
          value={formData.password}
          onChange={handleChange}
          InputProps={{
            endAdornment: (
              <InputAdornment position="end">
                <IconButton onClick={handleClickShowPassword}>
                  {showPassword ? <VisibilityOff /> : <Visibility />} {/* Toggle icon */}
                </IconButton>
              </InputAdornment>
            ),
          }}
        />

        {/* Error or Success Message */}
        {error && <Typography color="error" align="center">{error}</Typography>}
        {success && <Typography color="primary" align="center">{success}</Typography>}

        {/* Submit Button */}
        <Button
          variant="contained"
          color="primary"
          fullWidth
          onClick={handleSubmit}
          style={{ marginTop: "20px" }}
        >
          Sign Up
        </Button>

        {/* Login Link */}
        <Box mt={2} textAlign="center">
          <Typography variant="body2" color="textSecondary">
            Already have an account?{" "}
            <Button
              variant="text"
              color="primary"
              onClick={() => window.location.href = "/login"} // Adjust to your login page route
            >
              Login
            </Button>
          </Typography>
        </Box>
      </Box>
    </Box>
  );
}