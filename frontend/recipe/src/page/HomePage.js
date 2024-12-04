import React, { useState, useEffect } from "react";
import RecipeGrid from "../recipe/RecipeGrid";
import "bootstrap/dist/css/bootstrap.min.css";
import { fetchAllRecipes, fetchRecipes } from "../utils/api";

function HomePage() {
  const [keyword, setKeyword] = useState("");
  const [recipes, setRecipes] = useState([]);
  const [error, setError] = useState(null);
  const [sortOrder, setSortOrder] = useState("asc"); // 'asc' or 'desc'

  // Fetch all recipes on initial render
  useEffect(() => {
    const loadRecipes  = async () => {
      try {
        const data = await fetchAllRecipes();
        setRecipes(data);
        setError(null);
      } catch (err) {
        setRecipes([]);
        setError("Failed to fetch recipes.");
      }
    };

    loadRecipes ();
  }, []);

  const handleSearch = async () => {
    if (keyword.length < 3) {
      alert("Please enter at least 3 characters to search.");
      return;
    }
    try {
      const data = await fetchRecipes(keyword);
      setRecipes(data);
      setError(null);
    } catch (err) {
      alert(err.getMessage());
      setRecipes([]);
      setError("No recipes found for your search.");
    }
  };

  const sortRecipes = () => {
    const sorted = [...recipes].sort((a, b) =>
      sortOrder === "asc"
        ? a.cookTimeMinutes - b.cookTimeMinutes
        : b.cookTimeMinutes - a.cookTimeMinutes
    );
    setRecipes(sorted);
    setSortOrder(sortOrder === "asc" ? "desc" : "asc");
  };

  return (
    <div className="container my-4">
      <h1 className="text-center">Recipe Search</h1>
      <div className="d-flex justify-content-center mb-3">
        <input
          type="text"
          className="form-control w-50"
          placeholder="Enter recipe name or cuisine..."
          value={keyword}
          onChange={(e) => setKeyword(e.target.value)}
          onKeyUp={(e) => e.key === "Enter" && handleSearch()}
        />
        <button className="btn btn-primary ml-2" onClick={handleSearch}>
          Search
        </button>
      </div>
      {error && <div className="alert alert-danger text-center">{error}</div>}
      {recipes.length > 0 ? (
        <div>
          <button className="btn btn-secondary mb-3" onClick={sortRecipes}>
            Sort by Cook Time (
            {sortOrder === "asc" ? "Ascending" : "Descending"})
          </button>
          <h1>Showing recipe</h1>
          <RecipeGrid recipes={recipes} />
        </div>
      ) : (
        <div className="alert alert-info text-center">
          No recipes found. Please try a different search term or check back
          later.
        </div>
      )}
    </div>
  );
}

export default HomePage;
