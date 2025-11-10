# Ecommerce Platform Backend

A Spring Boot application that provides the backend services and REST APIs for an e-commerce platform. This project handles product management, user authentication, order processing, and more.

## Features
* **User Authentication:** Secure user registration and login using Spring Security (and JWT).
* **Product Management:** Full CRUD (Create, Read, Update, Delete) operations for products and categories.
* **Shopping Cart:** APIs to add, remove, and view items in a user's cart.
* **Order Processing:** Logic to create new orders from a shopping cart.
* **Payment Integration:** (Add details here, e.g., "Stripe payment processing.")

## Technologies Used
* **Core:** [Java 17](https) (or your version)
* **Framework:** [Spring Boot](https://spring.io/projects/spring-boot)
* **Security:** [Spring Security](https://spring.io/projects/spring-security)
* **Database:** [MySQL](https://www.mysql.com/) (or your database, e.g., PostgreSQL)
* **Database Migration:** [Flyway](https://flywaydb.org/) / [Liquibase](https://www.liquibase.org/) (if used)
* **API Documentation:** [Swagger / OpenAPI](https://swagger.io/) (if used)

## Getting Started

Follow these instructions to get a local copy up and running for development and testing.

### Prerequisites

* JDK (Java Development Kit) 17 or newer
* Gradle
* A running instance of MySQL (or your chosen database)

### Installation & Setup

1.  **Clone the repository:**
    ```sh
    git clone [https://github.com/MRPERFECT0603/Ecommerce.git](https://github.com/MRPERFECT0603/Ecommerce.git)
    cd Ecommerce
    ```

2.  **Configure the Database:**
    * Create a new database in MySQL:
        ```sql
        CREATE DATABASE ecommerce_db;
        ```
    * Update the database connection settings in `src/main/resources/application.properties`:
        ```properties
        # Database Configuration
        spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
        spring.datasource.username=YOUR_DATABASE_USERNAME
        spring.datasource.password=YOUR_DATABASE_PASSWORD
        spring.jpa.hibernate.ddl-auto=update
        
        # Add other properties (e.g., JWT secret key)
        # jwt.secret.key=your-super-secret-key
        ```

3.  **Run the application:**
    ```sh
    ./gradlew bootRun
    ```
    The application will start on `http://localhost:8080`.

## API Endpoints

This project uses REST APIs to communicate. Once the server is running, you can find the full API documentation at:

* **Swagger UI:** `http://localhost:8080/swagger-ui.html`

(If you aren't using Swagger, list a few key API endpoints here)

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/api/v1/auth/register` | Register a new user |
| `POST` | `/api/v1/auth/login` | Authenticate a user |
| `GET` | `/api/v1/products` | Get a list of all products |
| `GET` | `/api/v1/products/{id}` | Get a single product by ID |
| `POST` | `/api/v1/cart/add` | Add a product to the cart |