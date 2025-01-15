#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

template <typename T>
vector<vector<T>> generatePermutations(vector<T> arr) {
    vector<vector<T>> permutations;
    sort(arr.begin(), arr.end());
    permutations.push_back(arr);
    while (true) {
        int i = arr.size()-2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i < 0) break;
        int j = arr.size()-1;
        while (arr[j] <= arr[i]) {
            j--;
        }
        swap(arr[i], arr[j]);
        reverse(arr.begin() + i + 1, arr.end());
        permutations.push_back(arr);
    }
    return permutations;
}

int main() {
    vector<int> arr = {1, 3, 2};
    vector<vector<int>> permutations = generatePermutations(arr);

    for (const auto& perm : permutations) {
        for (const auto& elem : perm) {
            cout << elem << " ";
        }
        cout << endl;
    }

    return 0;
}
