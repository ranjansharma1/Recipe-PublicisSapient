import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

const RecipeGrid = ({ recipes }) => {
  const [selectedTags, setSelectedTags] = useState([]);

  const uniqueTags = [
    ...new Set(recipes.flatMap((recipe) => recipe.tags || [])),
  ];

  const toggleTag = (tag) => {
    setSelectedTags((prevTags) =>
      prevTags.includes(tag)
        ? prevTags.filter((t) => t !== tag)
        : [...prevTags, tag]
    );
  };

  const filteredRecipes = recipes.filter((recipe) =>
    selectedTags.length === 0
      ? true
      : (recipe.tags || []).some((tag) => selectedTags.includes(tag))
  );

  return (
    <div>
      <div className="mb-3">
        <h5>Filter by Tags:</h5>
        {uniqueTags.map((tag) => (
          <button
            key={tag}
            className={`btn btn-sm ${
              selectedTags.includes(tag) ? "btn-primary" : "btn-outline-primary"
            } m-1`}
            onClick={() => toggleTag(tag)}
          >
            {tag}
          </button>
        ))}
      </div>

      <div className="row">
        {filteredRecipes.map((recipe) => (
          <div key={recipe.id} className="col-md-4 mb-3">
            <div className="card " >
              <div className="card-body">
                <h5 className="card-title">{recipe.name}</h5>
                <p className="card-text">Cuisine: {recipe.cuisine}</p>
                <p className="card-text">
                  Cook Time: {recipe.cookTimeMinutes} minutes
                </p>
                <p className="card-text">
                  Tags: {(recipe.tags || []).join(", ")}
                </p>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default RecipeGrid;
