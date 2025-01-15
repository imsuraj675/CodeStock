#include <iostream>
#include <vector>
using namespace std;

template <typename T>
void generatePermutations(vector<T>& arr, int l, int r, vector<vector<T>>& result) {
    if (l == r) {
        result.push_back(arr);
    } else {
        for (int i = l; i <= r; i++) {
            swap(arr[l], arr[i]);
            generatePermutations(arr, l + 1, r, result);
            swap(arr[l], arr[i]);
        }
    }
}

template <typename T>
vector<vector<T>> getPermutations(vector<T> arr) {
    vector<vector<T>> result;
    generatePermutations(arr, 0, arr.size() - 1, result);
    return result;
}

int main() {
    vector<int> arr = {1, 2, 4, 3};
    vector<vector<int>> permutations = getPermutations(arr);

    for (const auto& perm : permutations) {
        for (const auto& elem : perm) {
            cout << elem << " ";
        }
        cout << endl;
    }

    return 0;
}
