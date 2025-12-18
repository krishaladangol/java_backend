import React from "react";
import {
  Box,
  Button,
  FormLabel,
  TextField,
  MenuItem,
  Grid2,
} from "@mui/material";

export default function Form() {
  const states = [
    "Bharatpur",
    "Bhaktapur",
    "Biratnagar",
    "Birgunj",
    "Chitwan",
    "Dhangadhi",
    "Itahari",
    "Janakpur",
    "Kathmandu",
    "Lumbini",
    "Narayangarh",
    "Nepalgunj",
    "Patan",
    "Pokhara",
  ];
  const genders = ["Male", "Female", "Others"];
  const airlines = [
    "Nepal Airlines",
    "Buddha Air",
    "Yeti Airlines",
    "Shree Airlines",
    "Tara Air",
  ];

  return (
    <Box
      sx={{
        padding: 4,
        maxWidth: 1000,
        margin: "auto",
        backgroundColor: "lightpink",
        borderRadius: 2,
        boxShadow: 3,
        height: "100vh",
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
      }}
    >
      <form style={{ width: "100%" }}>
        <Grid2 container direction="column" spacing={3}>
          {/* First Name */}
          <Grid2 item xs={12}>
            <FormLabel>First Name</FormLabel>
            <TextField
              size="small"
              fullWidth
              variant="outlined"
              required
              margin="normal"
            />
          </Grid2>

          {/* Middle Name */}
          <Grid2 item xs={12}>
            <FormLabel>Middle Name</FormLabel>
            <TextField
              size="small"
              fullWidth
              variant="outlined"
              required
              margin="normal"
            />
          </Grid2>

          {/* Last Name */}
          <Grid2 item xs={12}>
            <FormLabel>Last Name</FormLabel>
            <TextField
              size="small"
              fullWidth
              variant="outlined"
              required
              margin="normal"
            />
          </Grid2>

          {/* Address */}
          <Grid2 item xs={12}>
            <FormLabel>Address</FormLabel>
            <TextField
              size="small"
              fullWidth
              variant="outlined"
              required
              margin="normal"
            />
          </Grid2>

          {/* Email */}
          <Grid2 item xs={12}>
            <FormLabel>Email</FormLabel>
            <TextField
              size="small"
              fullWidth
              variant="outlined"
              required
              margin="normal"
              type="email"
            />
          </Grid2>

          {/* Phone Number */}
          <Grid2 item xs={12}>
            <FormLabel>Phone Number</FormLabel>
            <TextField
              size="small"
              fullWidth
              variant="outlined"
              required
              margin="normal"
              type="tel"
            />
          </Grid2>

          {/* Gender */}
          <Grid2 item xs={12} sm={6}>
            <FormLabel>Gender</FormLabel>
            <TextField
              size="small"
              fullWidth
              select
              variant="outlined"
              required
              margin="normal"
            >
              {genders.map((gender) => (
                <MenuItem key={gender} value={gender}>
                  {gender}
                </MenuItem>
              ))}
            </TextField>
          </Grid2>

          {/* Age */}
          <Grid2 item xs={12} sm={6}>
            <FormLabel>Age</FormLabel>
            <TextField
              size="small"
              fullWidth
              variant="outlined"
              required
              margin="normal"
              type="number"
            />
          </Grid2>

          {/* Source State */}
          <Grid2 item xs={12} sm={6}>
            <FormLabel>Source State</FormLabel>
            <TextField
              size="small"
              fullWidth
              select
              variant="outlined"
              required
              margin="normal"
            >
              {states.map((state) => (
                <MenuItem key={state} value={state}>
                  {state}
                </MenuItem>
              ))}
            </TextField>
          </Grid2>

          {/* Destination State */}
          <Grid2 item xs={12} sm={6}>
            <FormLabel>Destination State</FormLabel>
            <TextField
              size="small"
              fullWidth
              select
              variant="outlined"
              required
              margin="normal"
            >
              {states.map((state) => (
                <MenuItem key={state} value={state}>
                  {state}
                </MenuItem>
              ))}
            </TextField>
          </Grid2>

          {/* Airline */}
          <Grid2 item xs={12}>
            <FormLabel>Airlines</FormLabel>
            <TextField
              size="small"
              fullWidth
              select
              variant="outlined"
              required
              margin="normal"
            >
              {airlines.map((airline) => (
                <MenuItem key={airline} value={airline}>
                  {airline}
                </MenuItem>
              ))}
            </TextField>
          </Grid2>

          {/* Number of Seats */}
          <Grid2 item xs={12} sm={6}>
            <FormLabel>Number of Seats</FormLabel>
            <TextField
              size="small"
              fullWidth
              variant="outlined"
              required
              margin="normal"
              type="number"
            />
          </Grid2>

          {/* Next Button */}
          <Grid2 item xs={12}>
            <Button
              variant="contained"
              color="primary"
              fullWidth
              size="large"
              sx={{ marginTop: 2 }}
            >
              Next
            </Button>
          </Grid2>
        </Grid2>
      </form>
    </Box>
  );
}
