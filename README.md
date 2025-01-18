# Grade Management System

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Usage](#usage)
- [Examples](#examples)
- [Contributing](#contributing)
- [License](#license)

## Introduction
The **Grade Management System** is a simple Java-based application designed to manage student scores, calculate averages, and assign ranks. It provides a structured and extensible system for handling student data, subjects, and grades in a classroom environment.

## Features
- Add students and their scores for multiple subjects.
- Calculate average scores for individual students.
- Rank students based on their average scores.
- Calculate class averages for each subject.
- User-friendly console-based input and output.
- Input validation to ensure data integrity.

## Technologies Used
- **Java**: Core programming language.
- **Object-Oriented Programming (OOP)**: For modular and maintainable code.
- **Java Collections**: Used for managing student and score data.
- **Streams and Lambdas**: Simplify data processing and calculations.

## Project Structure
```
src/
└── com/
    └── grademanagement/
        ├── model/
        │   ├── Student.java       # Represents a student and their scores.
        │   ├── Score.java         # Represents a score for a specific subject.
        │   └── Subject.java       # Enum defining available subjects.
        ├── service/
        │   └── GradeManagementService.java  # Core logic for managing grades.
        └── ui/
            └── GradeManagementUI.java      # Handles user interaction and input.
```

## Usage
1. **Compile the Code**:
   Navigate to the `src` directory and compile the files:
   ```bash
   javac com/grademanagement/**/*.java
   ```

2. **Run the Application**:
   Execute the main class:
   ```bash
   java com.grademanagement.ui.GradeManagementUI
   ```

3. **Follow the Prompts**:
   - Enter the number of students.
   - Provide scores for each student in all subjects.
   - View calculated averages, rankings, and class averages.

## Examples
### Sample Input
```
How many students are in this class? : 2
STD01 Student's Java Score : 85
STD01 Student's SQL Score : 90
STD01 Student's Math. Score : 80
STD01 Student's English Score : 88
STD02 Student's Java Score : 78
STD02 Student's SQL Score : 84
STD02 Student's Math. Score : 92
STD02 Student's English Score : 89
```

### Sample Output
```
-------------------------------------------
[STD01] Student's Score Status
Java 85, SQL 90, Math. 80, English 88
-------------------------------------------
Avg. : 85.75, Rank : 1
-------------------------------------------

-------------------------------------------
[STD02] Student's Score Status
Java 78, SQL 84, Math. 92, English 89
-------------------------------------------
Avg. : 85.75, Rank : 1
-------------------------------------------

Final Rankings:
STD01 : => Avg. : 85.75, Rank : 1
STD02 : => Avg. : 85.75, Rank : 1

===============================
Java Class Avg. : 81.50
SQL Class Avg. : 87.00
Math. Class Avg. : 86.00
English Class Avg. : 88.50
===============================
```

