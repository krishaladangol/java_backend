"use client";
import { Box, Button, TextField, Typography,IconButton} from "@mui/material";
import { useState } from "react";
import { login } from "../util/Api"; // Ensure you have this utility function correctly set up
import { useRouter } from "next/navigation";
import Visibility from '@mui/icons-material/Visibility'; // For showing password
import VisibilityOff from '@mui/icons-material/VisibilityOff'; // For hiding password
import { InputAdornment } from "@mui/material";
import PersonIcon from '@mui/icons-material/Person';


export default function Login() {
  // State for login data
  const [loginData, setLoginData] = useState({
    username: "",
    password: "",
  });

  // State for errors
  const [errors, setErrors] = useState({
    username: "",
    password: "",
  });
  const [showPassword, setShowPassword] = useState(false); // Ensure showPassword is defined


  const router = useRouter();

  // Handle input changes
  const handleChange = (e) => {
    const { name, value } = e.target;
    setLoginData({
      ...loginData,
      [name]: value,
    });

    setErrors({
      ...errors,
      [name]: "",
    });
  };
  const handleClickShowPassword = () => {
    setShowPassword(!showPassword);
  };
  

  const handleSubmit = async (e) => {
    e.preventDefault();

    let isValid = true;
    const newErrors = {};

    // Username validation
    if (!loginData.username.trim()) {
      newErrors.username = "Username is required.";
      isValid = false;
    }

    // Password validation
    if (!loginData.password || loginData.password.length < 8) {
      newErrors.password = "Password must be at least 8 characters long.";
      isValid = false;
    }

    // If validation fails, update the errors state
    if (!isValid) {
      setErrors(newErrors);
      return;
    }

   
    // If validation passes, proceed with login
    console.log("Login Data:", loginData);
    const response = await login (loginData);
    console.log(response);
  
  if(response.token){
    router.push("/airlines");
  }

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
      <Box bgcolor="whitesmoke" p={4} borderRadius={3} boxShadow={3} width={400}>
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
          Login
        </Typography>

        {/* Username Field */}
        <TextField
          label="Username"
          variant="outlined"
          name="username"
          fullWidth
          value={loginData.username}
          margin="normal"
          onChange={handleChange}
          error={Boolean(errors.username)}
          helperText={errors.username}
        />

         {/* Password Field with show/hide functionality */}
         <TextField
          label="Password"
          variant="outlined"
          name="password"
          type={showPassword ? "text" : "password"} // Toggle password visibility
          fullWidth
          value={loginData.password}
          margin="normal"
          onChange={handleChange}
          error={Boolean(errors.password)}
          helperText={errors.password}
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

         {/* Forgot Password */}
         <Box display="flex" justifyContent="flex-end" width="100%" mt={1}>
          <Typography variant="body2">
            <a href="#" style={{ textDecoration: "none", color: "#1976d2" }}>
              Forgot password? <u>Click here</u>
            </a>
          </Typography>
        </Box>

        {/* Submit Button */}
        <Button
          variant="contained"
          color="primary"
          fullWidth
          style={{ marginTop: "20px" }}
          onClick={handleSubmit}
        >
          Login
        </Button>
      </Box>
    </Box>
  );
}
