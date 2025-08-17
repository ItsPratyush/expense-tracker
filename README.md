# 💰 Expense Tracker API

A simple **Spring Boot REST API** to manage personal expenses and incomes.  
This project demonstrates building a **CRUD (Create, Read, Update, Delete) application** with Spring Boot, MySQL, and JPA, while also exploring **aggregation queries** like calculating monthly totals.

---

## 📌 Features
- ➕ **Add new expenses** with title, amount, category, and date  
- 📖 **View all expenses** or fetch a single expense by ID  
- ✏️ **Update existing expenses**  
- ❌ **Delete expenses** by ID  
- 📊 **Calculate total expenses per month** (using aggregation queries)  
- 🔍 **Filter expenses** by category or date range  

---

## 🗂️ Entities
### `Expense`
| Field     | Type       | Description                       |
|-----------|-----------|-----------------------------------|
| `id`      | Long      | Unique identifier for each expense |
| `title`   | String    | Name/description of the expense    |
| `amount`  | Double    | Expense amount                    |
| `category`| String    | Category (e.g., Food, Travel)     |
| `date`    | LocalDate | Date of the expense               |

---

## ⚙️ Tech Stack
- **Backend Framework**: Spring Boot (Java)  
- **Database**: MySQL with Spring Data JPA  
- **Build Tool**: Maven  
- **Testing Tool**: Postman for API testing  

---

## 📌 API Endpoints
### Expense CRUD
- **POST** `/expenses` → Create a new expense  
- **GET** `/expenses` → Fetch all expenses  
- **GET** `/expenses/{id}` → Fetch a single expense by ID  
- **PUT** `/expenses/{id}` → Update an expense  
- **DELETE** `/expenses/{id}` → Delete an expense  

### Aggregation & Filters
- **GET** `/expenses/total/{year}/{month}` → Get total expenses for a given month  
- **GET** `/expenses/filter?category=Food&start=2025-08-01&end=2025-08-31` → Filter expenses by category and date range  

---

