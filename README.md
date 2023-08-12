# Contact Us Page
## ContactusServlet.java
- `doGet()`
  - Show contact us form using `contactus.jsp`
- `doPost()`
  - Form data: Name, email, message
  - Process form data using `Request.java`
  - Create an instance of `Request` and populate with data
  - Use `RequestDao.java` to save the request to the database

### Files
- `contactus.jsp`
- `ContactusServlet.java`

# Login Page
## LoginServlet.java
- `doGet()`
  - Show login form using `login.jsp`
- `doPost()`
  - Form data: Name, password
  - Process form data using `User.java`
  - Use `UserData.java` to validate user credentials
  - Redirect to `/dashboard` if valid, show error message and refresh if not

### Files
- `login.jsp`
- `LoginServlet.java`

# Dashboard Page
## DashboardServlet.java
- `doGet()`
  - Show list of all active and archive requests
  - Use `RequestDao.java` to fetch requests based on status
- `doPost()`
  - Process request status change (requestId, status)
  - Use `RequestDao.java` to change request status
  - Redirect user back to `/dashboard`

### Files
- `Dashboard.jsp`
- `DashboardServlet.java`

# Data Access Objects (DAO)
## RequestDao.java
- Responsible for handling request-related database operations
- `fetchRequests(boolean status)` retrieves requests based on status
- `changeStatus(String requestId, boolean status)` changes request status

## UserDao.java
- Responsible for handling user-related database operations
- `isValidUser(User user)` validates user credentials

# Model Classes
## Request.java
- Represents a contact us request
- Contains properties for Name, Email, Message

## User.java
- Represents a user
- Contains properties for Name, Password
