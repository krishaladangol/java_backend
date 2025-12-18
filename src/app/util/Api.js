import axios from "axios";
import { getToken, saveToken, removeToken } from "./authUtil"; // Utility functions for token handling

const API_BASE_URL = "http://localhost:8080";  // Replace with your backend URL

// Generic API call function
export async function makeApiCall(endpoint, method = "GET", body = null) {
  try {
    const headers = {
      "Content-Type": "application/json",
    };

    // Add token to headers if available
    const token = getToken();
    if (token) {
      headers["Authorization"] = `Bearer ${token}`;
    }

    const config = {
      method,
      url: `${API_BASE_URL}${endpoint}`,
      headers,
    };

    // Add body for POST/PUT requests
    if (body) {
      config.data = body;
    }

    const response = await axios(config); // Make API call with axios
    return response.data;
  } catch (error) {
    console.error(`Error in API call to ${endpoint}:`, error);

    if (error.response) {
      throw new Error(error.response.data.message || "API error");
    } else {
      throw new Error(error.message);
    }
  }
}

// Login API call
export async function login(data) {
  try {
    const response = await makeApiCall("/auth/login", "POST", data);  // POST request to login
    if (response.token) {
      saveToken(response.token);  // Save token in storage
    }
    return response;
  } catch (error) {
    throw new Error("Login failed: " + error.message);
  }
}

// Signup API call
export async function signup(data) {
  try {
    const response = await makeApiCall("/users/add", "POST", data);  // POST request to signup
    return response;
  } catch (error) {
    throw new Error("Signup failed: " + error.message);
  }
}

// Fetch users list (example GET request)
export async function getUsers() {
  try {
    return await makeApiCall("/users/list", "GET");  // GET request to fetch users
  } catch (error) {
    throw new Error("Failed to fetch users: " + error.message);
  }
}
export async function update(id) {
  try {
    return await makeApiCall(`/users/${id}`, "Update");  // DELETE request to delete user
  } catch (error) {
    throw new Error("Failed to update user: " + error.message);
  }}

// Delete user (example DELETE request)
export async function deleteUser(id) {
  try {
    return await makeApiCall(`/users/${id}`, "DELETE");  // DELETE request to delete user
  } catch (error) {
    throw new Error("Failed to delete user: " + error.message);
  }

}
export async function getAboutUs() {
  return await makeApiCall("/about", "GET");
}

// Fetch Bookings
export async function getBookings() {
  return await makeApiCall("/bookings", "GET");
}

// Create a new booking
export async function createBooking(bookingData) {
  return await makeApiCall("/bookings", "POST", bookingData);
}

// Fetch Services
export async function getServices() {
  return await makeApiCall("/services", "GET");
}

export async function addSignUpData(data) {
  return await makeApiCall("/users/add", "POST",data);
}





