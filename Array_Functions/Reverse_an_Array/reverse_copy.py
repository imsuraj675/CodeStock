def reverse_copy(vc):
    return list(reversed(vc))

if __name__ == "__main__":
    vc = [1, 2, 3]
    rev = reverse_copy(vc)
    for i in rev:
        print(i, end=" ")
    print()
