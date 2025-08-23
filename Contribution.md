# Contribution Guidelines

Welcome to the repository! This project aims to provide a collection of frequently used algorithms and functions in competitive programming (CP) and data structures and algorithms (DSA). We encourage you to contribute and improve the repository.

## How to Contribute to this repo

### Step 1: Fork the repository
1. Fork this repository to your own GitHub account.
2. Clone your forked repository to your local machine.

### Step 2: Choose a Problem
1. Search through the existing directories and check if the function/algorithm you want to add already exists. If it exists, please add your code to the existing folder.
2. If the function/algorithm you wish to add does not exist, feel free to create a new folder with the appropriate name.
3. Raise a new **Issue** and wait till being assigned.

### Step 3: Add Code in Three Languages
For each problem, please provide code in **Java**, **C++**, and **Python**. Ensure that:
- The function is named appropriately.
- The implementation in each language must be correct and efficient.
- Add a sample use case with input-output examples in the main function for each language.

### Step 4: Structure Your Code

For each problem, the folder should contain:
1. `function_name.java` - The Java implementation.
2. `function_name.cpp` - The C++ implementation.
3. `function_name.py` - The Python implementation.
4. `README.md` (**optional**) explaining the algorithm or function, its time and space complexity, and how it can be used.

Each file should contain the required **function** with the following structure:
  
```java
// Java Code Example
public class Main {
    public static void func_body() {
        // The required function which will be added
    }

    public static void main(String[] args) {
        // Main function where the function is called and use case is demonstrated
        func_body();
    }
}
```

```cpp
// C++ Code Example
#include <iostream>
using namespace std;

void func_body() {
    // The required function which will be added
}

int main() {
    // Main function where the function is called and use case is demonstrated
    func_body();
    return 0;
}
```

```python
# Python Code Example
def func_body():
    # The required function which will be added
    pass

if __name__ == "__main__":
    # Main function where the function is called and use case is demonstrated
    func_body()
```

### Step 5: Add the Checkbox in RoadMap.md
Once you've created your PR, make sure to:

- Check the box corresponding to the added function in the **RoadMap.md** file. 
- If no relevant checkbox exists, please **add** a new one under an appropriate section.
- Create an **hyperlink** of the folder in RoadMap.md

### Step 6: Submit a Pull Request
- Push your changes to your forked repository.
- Open a Pull Request (PR) from your forked repository to the original repository.

- Ensure that:
    - The PR description includes a summary of the added function/algorithm.
    - All **three** language files are present.
    - The checkbox in RoadMap.md is checked (or added).

- Important Notes:
    - Naming convention: Name the files according to the problem/algorithm/functional name (e.g., reverse_array.java, binary_search.cpp, factorial.py).
    - Code style: Please make sure your code follows standard coding practices, such as proper indentation, meaningful variable names, and adequate comments where necessary.
    - Tests: Whenever possible, please add edge case tests or example inputs in your main function that showcase the behavior of your function.

**Thanks** for contributing! We appreciate your effort to make this repository better for the competitive programming community.
