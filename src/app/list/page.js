"use client";

import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { useEffect, useState } from 'react';
import { getUsers, updateUser } from "../util/Api";
import { IconButton } from '@mui/material';
import { Delete, Edit } from '@mui/icons-material';
import { deleteUser } from "../util/Api";
import {  Dialog, DialogActions, DialogContent, DialogTitle, TextField, Button } from '@mui/material';



export default function BasicTable() {

  const [users, setUsers] = useState([]);
  const [openEditDialog, setOpenEditDialog] = useState(false);
  const [editUserData, setEditUserData] = useState(null);

  const fetchUsers = async () => {
    try {
      const response = await getUsers(); // Fetch data
      setUsers(response); // Update state
      console.log(response); // Log the fetched response directly
    } catch (error) {
      console.log("Error fetching users:", error);
    }
  };

useEffect(() => {
    
    fetchUsers();//call the async function inside use effect
},[]);
// const updatedData = {
//   gender:"",
//   address:"",
//   age:"",
//   firstname: "",
//   lastname:"",
//   password:"",
//   phone_number: "",
//   username:"",
// };


  const handledelete=async(id)=>{
    const response = await deleteUser(id); // Fetch data
   if(response){
    fetchUsers();
   }
  };
  const handleEditOpen = (user) => {
    setEditUserData(user); // Set the user data to edit
    setOpenEditDialog(true); // Open the dialog
  };

  const handleEditClose = () => {
    setOpenEditDialog(false); // Close the dialog
  };

  const handleUpdate = async () => {
    try {
      const response = await updateUser(editUserData.id, editUserData); // Call updateUser
      console.log("API Response:", response);
      if (response && response.message === "User updated successfully") {
        console.log("User updated successfully:", response);
        fetchUsers(); // Refresh the user list
        handleEditClose(); // Close the dialog
      } else {
        console.log("Update failed:", response.message);
        alert("Update failed: " + response.message);
      }
    } catch (error) {
      console.log("Error updating user");
      alert("There was an error updating the user.");
    }

const handleEditOpen = (user) => {
  setEditUserData({ ...user }); // Ensure the user object includes the `id` field
  setOpenEditDialog(true); // Open the dialog
};
  };
const handleInputChange = (e) => {
  setEditUserData({
    ...editUserData,
    [e.target.name]: e.target.value,
  });
};


  
  return (
    <>
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
          <TableCell align="right"> id </TableCell>
          <TableCell align="right"> gender </TableCell>
          <TableCell align="right">address</TableCell>
          <TableCell align="right"> age </TableCell>
          <TableCell align="right">email </TableCell>
          <TableCell align="right"> firstname </TableCell>
          <TableCell align="right">lastname</TableCell>
          <TableCell align="right">password</TableCell>
          <TableCell align="right">phone_number</TableCell>
          <TableCell align="right">Username</TableCell>
          <TableCell align="right">Action</TableCell>

          </TableRow>
        </TableHead>
        <TableBody>
          {users.map((row) => (
            <TableRow
              key={row.id}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
             
              <TableCell align="right">{row.id}</TableCell>
              <TableCell align="right">{row.gender}</TableCell>
              <TableCell align="right">{row.address}</TableCell>

              <TableCell align="right">{row.age}</TableCell>
              <TableCell align="right">{row.email}</TableCell>

              <TableCell align="right">{row.firstname}</TableCell>
              <TableCell align="right">{row.lastname}</TableCell>
              <TableCell align="right">{row.password}</TableCell>
              <TableCell align="right">{row.phone_number}</TableCell>
              <TableCell align="right">{row.username}</TableCell>
              <TableCell>
                <IconButton onClick={()=> handleEditOpen(row)}>
                  <Edit></Edit>
                </IconButton>
                <IconButton onClick={()=>row.id && handledelete(row.id)}>
                  <Delete>
                  </Delete>
                  </IconButton>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  
    {editUserData && (
      <Dialog open={openEditDialog} onClose={handleEditClose}>
        <DialogTitle>Edit User</DialogTitle>
        <DialogContent>
        <TextField
  autoFocus
  margin="dense"
  label="id"
  type="number"
  fullWidth
  name="id"
  value={editUserData.id}
  onChange={handleInputChange}
/>
        <TextField
  autoFocus
  margin="dense"
  label="Gender"
  type="text"
  fullWidth
  name="gender"
  value={editUserData.gender}
  onChange={handleInputChange}
/>
<TextField
  margin="dense"
  label="Address"
  type="text"
  fullWidth
  name="address"
  value={editUserData.address}
  onChange={handleInputChange}
/>
<TextField
  margin="dense"
  label="Age"
  type="number"
  fullWidth
  name="age"
  value={editUserData.age}
  onChange={handleInputChange}
/>
<TextField
  margin="dense"
  label="First Name"
  type="text"
  fullWidth
  name="firstname"
  value={editUserData.firstname}
  onChange={handleInputChange}
/>
<TextField
  margin="dense"
  label="Last Name"
  type="text"
  fullWidth
  name="lastname"
  value={editUserData.lastname}
  onChange={handleInputChange}
/>
<TextField
  margin="dense"
  label="Password"
  type="password"
  fullWidth
  name="password"
  value={editUserData.password}
  onChange={handleInputChange}
/>
<TextField
  margin="dense"
  label="Phone Number"
  type="text"
  fullWidth
  name="phone_number"
  value={editUserData.phone_number}
  onChange={handleInputChange}
/>
<TextField
  margin="dense"
  label="Username"
  type="text"
  fullWidth
  name="username"
  value={editUserData.username}
  onChange={handleInputChange}
/>

        </DialogContent>
        <DialogActions>
          <Button onClick={handleEditClose} color="primary">
            Cancel
          </Button>
          <Button onClick={handleUpdate} color="primary">
            Save
          </Button>
        </DialogActions>
      </Dialog>
    )}
    </>
  );
}
 