# (c) Aritro 'sortira' Shome
def generate_permutations(s):
    def backtrack(path, used, result):
        if len(path) == len(s):
            result.append("".join(path))
            return
        for i, char in enumerate(s):
            if used[i]:
                continue
            used[i] = True
            path.append(char)
            backtrack(path, used, result)
            path.pop()
            used[i] = False

    result = []
    backtrack([], [False] * len(s), result)
    return result

# Example usage:
print(generate_permutations("abc"))
