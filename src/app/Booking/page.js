"use client";
import React, { useState } from "react";
import {
  Box,
  Button,
  Typography,
  Grid2,
  Dialog,
  DialogActions,
  DialogContent,
  DialogTitle,
  Snackbar,
  Alert,
} from "@mui/material";

export default function AirlineSeatBookingWithDoubleClick() {
  const rows = 6; // Number of rows
  const seatLabels = ["A", "B", "C", "D", "E", "F"]; // Labels for seats

  // Initializing seats: 0 = available, 1 = booked
  const [seats, setSeats] = useState(
    Array.from({ length: rows }, () => Array(6).fill(0))
  );
  const [selectedSeats, setSelectedSeats] = useState([]);
  const [showDialog, setShowDialog] = useState(false);
  const [snackbarOpen, setSnackbarOpen] = useState(false);
  const [snackbarMessage, setSnackbarMessage] = useState("");

  const handleSeatClick = (row, col) => {
    if (seats[row][col] === 1) {
      setSnackbarMessage(`Seat ${row + 1}${seatLabels[col]} is already booked!`);
      setSnackbarOpen(true);
      return; // Ignore clicks on booked seats
    }

    const newSelectedSeats = [...selectedSeats];
    const seatIndex = newSelectedSeats.findIndex(
      (seat) => seat.row === row && seat.col === col
    );

    if (seatIndex > -1) {
      // Deselect seat on single click
      newSelectedSeats.splice(seatIndex, 1);
    } else {
      // Select seat
      newSelectedSeats.push({ row, col });
    }

    setSelectedSeats(newSelectedSeats);
  };

  const handleSeatDoubleClick = (row, col) => {
    // Deselect only the recently clicked seat
    const newSelectedSeats = selectedSeats.filter(
      (seat) => !(seat.row === row && seat.col === col)
    );
    setSelectedSeats(newSelectedSeats);
  };

  const handleBookSeats = () => {
    const newSeats = seats.map((row, rowIndex) =>
      row.map((seat, colIndex) => {
        if (
          selectedSeats.find(
            (selected) =>
              selected.row === rowIndex && selected.col === colIndex
          )
        ) {
          return 1; // Mark selected seats as booked
        }
        return seat;
      })
    );
    setSeats(newSeats);
    setSelectedSeats([]);
    setShowDialog(false);
  };

  const getSeatColor = (row, col) => {
    if (seats[row][col] === 1) return "red";
    if (
      selectedSeats.find(
        (seat) => seat.row === row && seat.col === col
      )
    )
      return "blue";
    return "green";
  };

  return (
    <Box
      sx={{
        padding: 5,
        maxWidth: 800,
        margin: "auto",
        backgroundColor: "lightgray",
        borderRadius: 2,
        boxShadow: 3,
        textAlign: "center",
      }}
    >
      <Typography variant="h5" sx={{ mb: 3 }}>
        Airline Seat Booking
      </Typography>
      <Typography variant="body1" sx={{ mb: 2 }}>
        Select your preferred seat(s) from the available seats:
      </Typography>
      <Grid2 container direction="column" spacing={2}>
        {seats.map((row, rowIndex) => (
          <Grid2
            container
            key={rowIndex}
            justifyContent="center"
            alignItems="center"
            spacing={1}
          >
            {/* Left Seats */}
            {row.slice(0, 3).map((seat, colIndex) => (
              <Grid2 key={`L-${colIndex}`}>
                <Button
                  onClick={() => handleSeatClick(rowIndex, colIndex)}
                  onDoubleClick={() =>
                    handleSeatDoubleClick(rowIndex, colIndex)
                  }
                  style={{
                    backgroundColor: getSeatColor(rowIndex, colIndex),
                    color: "white",
                    width: 50,
                    height: 50,
                  }}
                >
                  {rowIndex + 1}
                  {seatLabels[colIndex]}
                </Button>
              </Grid2>
            ))}

            {/* Aisle */}
            <Grid2 sx={{ width: 30 }}></Grid2>

            {/* Right Seats */}
            {row.slice(3).map((seat, colIndex) => (
              <Grid2 key={`R-${colIndex + 3}`}>
                <Button
                  onClick={() =>
                    handleSeatClick(rowIndex, colIndex + 3)
                  }
                  onDoubleClick={() =>
                    handleSeatDoubleClick(rowIndex, colIndex + 3)
                  }
                  style={{
                    backgroundColor: getSeatColor(rowIndex, colIndex + 3),
                    color: "white",
                    width: 50,
                    height: 50,
                  }}
                >
                  {rowIndex + 1}
                  {seatLabels[colIndex + 3]}
                </Button>
              </Grid2>
            ))}
          </Grid2>
        ))}
      </Grid2>
      <Box sx={{ mt: 3 }}>
        <Button
          variant="contained"
          color="primary"
          disabled={selectedSeats.length === 0}
          onClick={() => setShowDialog(true)}
        >
          Book Selected Seats
        </Button>
      </Box>

      <Dialog open={showDialog} onClose={() => setShowDialog(false)}>
  <DialogTitle>Confirm Booking</DialogTitle>
  <DialogContent>
    <Typography>You have selected the following seats:</Typography>
    <Box component="ul" sx={{ paddingLeft: 2 }}>
      {selectedSeats.map((seat, index) => (
        <Typography component="li" key={index}>
          Row {seat.row + 1}, Seat {seatLabels[seat.col]}
        </Typography>
      ))}
    </Box>
  </DialogContent>
  <DialogActions>
    <Button onClick={() => setShowDialog(false)} color="secondary">
      Cancel
    </Button>
    <Button onClick={handleBookSeats} color="primary">
      Confirm
    </Button>
  </DialogActions>
</Dialog>


      {/* Snackbar for notifications */}
      <Snackbar
      
        open={snackbarOpen}
        autoHideDuration={3000}
        onClose={() => setSnackbarOpen(false)}
      >
        <Alert onClose={() => setSnackbarOpen(false)} severity="error">
          {snackbarMessage}
        </Alert>
      </Snackbar>
    </Box>
  );
}
