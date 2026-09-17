TaskFlow API is a small REST API for managing task

### ** Prerequisites:**  Minimum requirements(JDK 17+, Maven 3.8+,IDE/Terminal,cURL/Postman)

### **PROJECT STRUCTURE
### **1. `controller` Package (Web / Interface Layer)**
* **Role**: Contains web-facing classes annotated with `@RestController` that receive incoming HTTP requests, map endpoint paths, extract inputs, delegate work to the service layer, and return HTTP responses with status codes.
* **Example File**: `TaskController.java`.
* 
### **2. `dto` Package (Data Transfer Object Layer)**
* **Role**: Contains lightweight classes designed specifically for transferring data into or out of REST API endpoints. DTOs restrict input to only the fields a client is allowed to supply, protecting internal models from unintended modifications.
* **Example File**: `CreateTaskRequest.java`.
* 
### **3. `model` Package (Domain / Entity Layer)**
* **Role**: Defines internal application objects that represent the full state and structure of data managed by the system.
* **Example File**: `Task.java` (containing `id`, `title`, `description`, `status`).

### **4. `service` Package (Business Logic Layer)**
* **Role**: Contains classes annotated with `@Service` that execute core application logic, decision-making, filtering, and data manipulation. It keeps heavy loops, calculations, and rules separated from web/HTTP concerns.
* **Example File**: `TaskService.java`.



### **Package Structure Summary**
```
com.example.taskflow/            
├── controller/                 
│   └── TaskController.java     
├── dto/                    
│   └── CreateTaskRequest.java     
├── model/                      
│   └── Task.java               
├── service/                        
│   └──  TaskService.java    
└── TaskflowApiApplication.java
```

***

 ### Step-by-step instructions for compiling (mvn clean compile) and 
####  starting the app (mvn spring-boot:run) on port 8080


### **Step 1: Open Terminal in the Project Root Directory**
Open your terminal or command prompt and navigate to the root directory of your project (`taskflow-api`), where the `pom.xml` file is located:

```bash
cd /path/to/taskflow-api
```

### **Step 2: Clean and Compile the Code**
Execute the Maven clean and compile command:

```bash
mvn clean compile
```

* **Expected Output**: A `BUILD SUCCESS` message at the bottom of the terminal output.

---

### **Step 3: Start the Application on Port 8080**
Launch the Spring Boot application using the Spring Boot Maven plugin:

```bash
mvn spring-boot:run
```

* **Expected Output**: Startup logs ending with port confirmation:
  ```text
  Tomcat started on port 8080 (http) with context path ''
  Started TaskflowApiApplication in X.XXX seconds (process running)
  ```

---

### **Step 4: Test the Endpoint**
While `mvn spring-boot:run` is active in your terminal, open a second terminal window or browser to test your endpoints on port 8080:

```bash
curl http://localhost:8080/api/tasks
```

---

### **Step 5: Stop the Server**
When you want to shut down the server, press **`Ctrl + C`** in the terminal where the application is running.



### **TaskFlow API CRUD Endpoints**

| Operation | HTTP Method | Endpoint Path | Request Body / Parameters | Success Status | Error Status Codes |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Create Task** | `POST` | `/api/tasks` | **JSON Body (`CreateTaskRequest`)**: <br>`{"title": "Learn Spring Boot", "description": "Build REST API"}` | **`201 Created`** | **`400 Bad Request`** (if title is blank or invalid) |
| **List All Tasks** | `GET` | `/api/tasks` | *None* | **`200 OK`** | N/A |
| **Get Task by ID** | `GET` | `/api/tasks/{id}` | *None* (ID supplied in URL path) | **`200 OK`** | **`404 Not Found`** (if task ID does not exist) |
| **Update Task Status** | `PATCH` | `/api/tasks/{id}/status` | **Query Param**: <br>`?status=COMPLETED` | **`200 OK`** | **`404 Not Found`** (if task ID does not exist) |
| **Delete Task** | `DELETE` | `/api/tasks/{id}` | *None* (ID supplied in URL path) | **`200 OK`** | **`404 Not Found`** (if task ID does not exist) |

---

### **Status Code Summary**
* **`200 OK`**: Standard success response for fetching, updating, or deleting resources.
* **`201 Created`**: Indicates that a new resource was successfully created.
* **`400 Bad Request`**: Indicates client input validation failed (e.g., `@Valid` rejecting a blank title).
* **`404 Not Found`**: Indicates the requested task ID could not be located in memory.

***

