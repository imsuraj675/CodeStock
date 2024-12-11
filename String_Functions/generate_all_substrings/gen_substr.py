def func_body(input_str):
    # Generating all substrings
    n = len(input_str)
    for i in range(n):             # Starting index
        for j in range(i, n):      # Ending index
            print(input_str[i:j+1])  # Extract and print substring

if __name__ == "__main__":
    # Main function where the function is called and use case is demonstrated
    input_str = "abcd"  # Example input
    func_body(input_str)
