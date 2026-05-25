# SIBA GPA Calculator

A JavaFX desktop application for calculating GPA based on Sukkur IBA University's grading system.

## Features
- Add subjects with marks, out of (50 or 100), and credit hours
- Automatic grade and grade point calculation
- Weighted GPA calculation using IBA's grading scale
- Remove last row and clear table options
- Input validation with error handling

## Grading Scale (Sukkur IBA University)
| Grade | Percentage (Theory) | Percentage (Practical) | GP |
|-------|--------------------|-----------------------|----|
| A     | 93-100             | 46-50                 | 4.00 |
| A-    | 87-92              | 44-45                 | 3.67 |
| B+    | 82-86              | 42-43                 | 3.33 |
| B     | 77-81              | 39-41                 | 3.00 |
| B-    | 72-76              | 37-38                 | 2.67 |
| C+    | 68-71              | 35-36                 | 2.33 |
| C     | 64-67              | 32-34                 | 2.00 |
| C-    | 60-63              | 30-31                 | 1.67 |
| F     | Below 60           | Below 30              | 0.00 |

## Technologies Used
- Java 26
- JavaFX 21
- Maven

## How to Run
1. Clone the repository
2. Open in IntelliJ IDEA
3. Run `Launcher.java`