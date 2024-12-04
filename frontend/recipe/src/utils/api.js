import axios from "axios";

// Base API configuration
const API = axios.create({
  baseURL: process.env.REACT_APP_API_URL || "http://localhost:8080"
});

// Centralized API Call Handler
export const fetchRecipes = async (keyword) => {
  try {
    const response = await API.get(`/recipe/search?keyword=${keyword}`);
    return response.data;
  } catch (error) {
    if (error.response && error.response.status === 404) {
      throw new Error("No recipes found for your search.");
    }
    throw new Error("An error occurred while fetching recipes.");
  }
};

export const fetchAllRecipes = async () => {
  try {
    const response = await API.get("/recipe/all");
    return response.data;
  } catch (error) {
    throw new Error("Failed to fetch all recipes.");
  }
};
