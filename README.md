# 🛍️ MiniStore - Inventory and Shopping System (Java + OOP)

## 📌 Project Overview
This project is a **mini Java application** developed using **Object-Oriented Programming (OOP)** and **data structures**.  
It manages a small **product inventory** and simulates **shopping operations** through an interactive **JOptionPane menu**.

The application demonstrates the use of:
- **OOP principles**: encapsulation, inheritance, polymorphism, abstraction.
- **Data structures**: `ArrayList`, `HashMap`, and arrays.
- **Interactive GUI dialogs** with `JOptionPane`.

---

## 🎯 User Story Goal
Develop a **MiniStore system** that allows managing products, stock, and purchases.  
The system must handle different **product categories** (Food and Appliances), maintain stock control, and generate purchase tickets.

---

## 🛠️ Features

### 1. Data Model with OOP
- Abstract class **`Product`** with:
    - Attributes: `name`, `price`.
    - Abstract method: `getDescription()`.
- Subclasses:
    - **`Food`**
    - **`Appliance`**
- Each subclass overrides `getDescription()` (polymorphism).
- Attributes are private (encapsulation) with **getters/setters**.

### 2. Data Structures
- **`ArrayList<Product>`** → stores products.
- **`HashMap<String, Integer>`** → stores stock by product name.
- **`double[]`** → optional array for quick statistics (max/min price).

### 3. Interactive Menu (JOptionPane)
- **Add Product**: Choose type (Food/Appliance), enter name, price, and stock. Prevent duplicates.
- **List Inventory**: Shows product list with name, price, stock, and description.
- **Buy Product**: Enter product name and quantity. Validates stock, updates inventory, and generates a partial ticket.
- **Statistics**: Finds the most expensive and cheapest product.
- **Search Product**: Allows partial name matching.
- **Exit**: Shows the **final purchase ticket** with the total amount spent.

### 4. Validations
- Handle invalid inputs (`NumberFormatException`).
- Prevent empty or negative values.
- Error/confirmation messages using `showMessageDialog`.

---

## ✅ Acceptance Criteria
- Abstract `Product` class implemented with encapsulation.
- Subclasses (`Food`, `Appliance`) override `getDescription()`.
- Full menu navigation with `JOptionPane`.
- Proper input validation and error handling.
- Final purchase summary displayed before exiting.

---

## 🚀 How to Run
1. Clone the repository or download the source code.
2. Open the project in **IntelliJ IDEA** (or any Java IDE).
3. Run the `Main.java` file.
4. Use the **interactive dialogs** to manage inventory and simulate purchases.

---

## 📂 Suggested Modularization
```
src/
├── model/
│ ├── Product.java
│ ├── Food.java
│ └── Appliance.java
├── service/
│ └── InventoryService.java
└── ui/
│ └── Menu
└── Main.java
```


---

## 📖 Example Workflow
1. Add products (e.g., "Milk", "Washing Machine").
2. List inventory to confirm details.
3. Buy a product (updates stock).
4. Check statistics (most expensive/cheapest).
5. Exit and view final purchase ticket.

---

## 🎓 Learning Objectives
- Apply **OOP in Java** with inheritance, abstraction, encapsulation, and polymorphism.
- Use **collections** (`ArrayList`, `HashMap`) and arrays in practical scenarios.
- Build **interactive applications** with `JOptionPane`.
- Implement **validation and exception handling** in user inputs.
