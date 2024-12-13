def u_bound(a, key):
    l, r = 0, len(a) - 1
    ans = -1
    while l <= r:
        mid = (l + r) // 2
        if a[mid] <= key:
            ans = max(ans, mid)
            l = mid + 1
        else:
            r = mid - 1
    if ans != -1 and a[ans] == key:
        return ans
    return -1

if __name__ == "__main__":
    a = [1, 2, 2, 2, 2, 3, 5]
    key = 2
    UBound = u_bound(a, key)
    if UBound == -1:
        print("The number does not exist.")
    else:
        print(f"Upper Bound of '{key}' = {UBound}")