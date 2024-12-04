## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.

The page will reload when you make changes.\
You may also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.\
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.\
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.\
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

# Recipe Search App

This is a React-based frontend for searching recipes using a Spring Boot backend.

## Features
- Search recipes by name or cuisine.
- Client-side sorting by cook time.
- Displays recipes in a grid format.

## Setup

### Prerequisites
- Backend API running at `http://localhost:8080`

### Steps to Run
1. Clone the repository:
   ```bash
   git clone <repo-url>



# Project Structure:

   ```bash
      src/
      ├── recipe/
      │   ├── RecipeGrid.js       // Component to display recipe cards
      ├── App.js                  // Main app file
      ├── page/
      │   ├── HomePage.js         // Component with search and grid logic
      ├── utils/
      │   ├── api.js              // API layer for handling backend calls
      ├── index.js                // ReactDOM entry point
