# Python Code Example
def helper(s, n, i, sub, container):
    # Base case: when we reach the end of the string
    if i >= n:
        container.append(sub)
        return
    
    # Include the current character in the subsequence
    helper(s, n, i + 1, sub + s[i], container)
    
    # Exclude the current character from the subsequence
    helper(s, n, i + 1, sub, container)

def func_body(s):
    n = len(s)
    result = []
    helper(s, n, 0, "", result)
    return result

if __name__ == "__main__":
    # Main function where the function is called and use case is demonstrated
    s = "abcd"  # Example input
    all_subsequences = func_body(s)

    # Print all subsequences
    for subsequence in all_subsequences:
        print(subsequence)
