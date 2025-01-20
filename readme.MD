# Journal App

## Overview
The Journal App is a RESTful application designed to manage journal entries. It uses Spring Boot for the backend and MongoDB as the database. The application allows users to create, read, update, and delete journal entries.

## Features
- **Create Journal Entries**: Add new entries with a title, content, and an automatically generated timestamp.
- **Read Journal Entries**: Retrieve all entries or a specific entry by its ID.
- **Update Journal Entries**: Modify the title or content of an existing entry.
- **Delete Journal Entries**: Remove a journal entry by its ID.

## Technologies Used
- **Spring Boot**: Backend framework.
- **MongoDB**: NoSQL database for storing journal entries.
- **Java**: Programming language.
- **Maven**: Dependency management.

## Prerequisites
- Java 17 or later.
- Maven 3.8 or later.
- MongoDB installed and running on `localhost:27017`.

## Configuration
The application requires a MongoDB database named `journaldb`. Update the `application.properties` file if the database configuration needs to be changed:

```properties
spring.application.name=Journal App
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=journaldb
```

## API Endpoints

### Base URL
`/journal`

### Endpoints

#### Get All Entries
**GET** `/journal`
- **Description**: Retrieve all journal entries.
- **Response**: List of journal entries.

#### Create Entry
**POST** `/journal`
- **Description**: Add a new journal entry.
- **Request Body**:
  ```json
  {
    "title": "Sample Title",
    "content": "Sample Content"
  }
  ```
- **Response**: The created journal entry with a generated ID and timestamp.

#### Get Entry By ID
**GET** `/journal/{id}`
- **Description**: Retrieve a journal entry by its ID.
- **Path Variable**: `id` (ObjectId of the entry).
- **Response**: The journal entry, or `null` if not found.

#### Update Entry By ID
**PUT** `/journal/{id}`
- **Description**: Update an existing journal entry.
- **Path Variable**: `id` (ObjectId of the entry).
- **Request Body**:
  ```json
  {
    "title": "Updated Title",
    "content": "Updated Content"
  }
  ```
- **Response**: The updated journal entry.

#### Delete Entry By ID
**DELETE** `/journal/{id}`
- **Description**: Delete a journal entry by its ID.
- **Path Variable**: `id` (ObjectId of the entry).
- **Response**: `true` if the entry was successfully deleted.

## Running the Application
1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```bash
   cd journalApp
   ```
3. Build the application using Maven:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```
5. The application will be available at `http://localhost:8080`.

## Directory Structure
- `controller/`: Contains the REST controller (`JournalEntityController`) for handling API requests.
- `service/`: Contains the service layer (`JournalEntryService`) for business logic.
- `repository/`: Contains the MongoDB repository interface (`JournalEntityRepository`).
- `entity/`: Contains the data model (`JournalEntry`) representing a journal entry.

## Example MongoDB Document
```json
{
  "_id": "64e63c2f8d95c0fa8b3e",
  "title": "Sample Title",
  "content": "Sample Content",
  "date": "2025-01-20T10:00:00"
}
```

## Future Enhancements
- Add authentication and authorization.
- Implement pagination for retrieving journal entries.
- Add search functionality by title or content.
- Create a frontend application to interact with the backend.

## License
This project is licensed under the MIT License.

---

For any questions or contributions, feel free to reach out.

