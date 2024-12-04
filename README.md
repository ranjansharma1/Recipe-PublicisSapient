# Recipe Management Web Application

### **Overview**

This project is a Recipe Management Web Application developed as part of an assignment from **Publicis Sapient**. The goal of this project is to provide a user-friendly interface where users can search for recipes based on names or cuisine, view detailed recipe information, and interact with the recipe data through sorting and filtering features. 

### **Key Features**
1. **Recipe Search**: The user can search for recipes by entering partial text (minimum 3 characters) in the search bar. The frontend makes an API call to the backend to fetch matching recipes.
  
2. **Dynamic Recipe Grid**: Recipes are displayed in a grid layout. Each recipe is shown with key details like name, cuisine, and cook time. Users can easily browse through the available recipes.
  
3. **Sorting**: Users can sort the recipe list based on the cooking time, either in ascending or descending order, without needing to make another backend call.

4. **Filtering by Tags**: The grid can be filtered based on recipe tags, allowing users to narrow down results according to categories like "Vegan," "Gluten-Free," "Desserts," etc.

5. **Responsive Design**: The application is designed to be responsive, providing a seamless user experience across different devices such as desktops, tablets, and mobile phones.

### **Tech Stack**

- **Frontend**: Built with **React.js** and **Bootstrap** for UI components, ensuring a modern and responsive design.
- **Backend**: **Spring Boot** for building the RESTful API that handles recipe data.
- **API Integration**: Axios is used to make HTTP requests to the backend API.
- **Environment**: The project uses an `.env` file to manage environment variables and configurations.
- **Database**: In-Memory Database (H2 Databse)

### **How to Run the Project**

#### **Frontend:**
1. Install the required dependencies:
   ```bash
   npm install
2. Run UI page
   - npm start
   - Open http://localhost:3000 to view it in your browser.
### **Backend:**
1. Run The Server   
2. API documentation available at: http://localhost:8080/swagger-ui/index.html

### **Database:**
  Check http://localhost:8080/h2-console to view data
