#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>
#include <numeric>
#include <string>
#include <cctype>

using namespace std;

class SparseTable {
private:
    vector<vector<int>> lookup;           //Sparse table
    vector<int> bin_log;                   // Array to store logarithmic values
    int n;                                 //Size 
    string func_name;                      // Function name (min, max, gcd, etc.)

    int operation(int x, int y) {
        switch (func_name[0]) { 
            case 'm': // min, max
                if (func_name == "min") return min(x, y);
                if (func_name == "max") return max(x, y);
                break;
            case 'g': // gcd
                if (func_name == "gcd") return gcd(x, y);
                break;
            case 'l': // lcm
                if (func_name == "lcm") return lcm(x, y);
                break;
            case 'a': // and
                if (func_name == "and") return x & y;
                break;
            case 'o': // or
                if (func_name == "or") return x | y;
                break;
        }
        throw invalid_argument("Unsupported function name: " + func_name);
    }

    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b); 
    }

    int lcm(int a, int b) {
        if (a == 0 || b == 0) return 0;
        return abs(a * b) / gcd(a, b);
    }

public:
    // Build function to preprocess the array and build the sparse table
    void build(vector<int>& arr, int size, string func) {
        transform(func.begin(), func.end(), func.begin(), ::tolower);
        func_name = func;
        n = size;

        // Precompute the logarithmic values for each index
        bin_log.resize(n + 1);
        bin_log[1] = 0;
        for (int i = 2; i <= n; i++) {
            bin_log[i] = bin_log[i / 2] + 1;
        }

        int max_log = bin_log[n];
        lookup.assign(n, vector<int>(max_log + 1));           // Base case: single elements

        for (int i = 0; i < n; i++) {
            lookup[i][0] = arr[i];
        }

        for (int k = 1; k <= max_log; k++) {
            for (int i = 0; i + (1 << k) <= n; i++) {
                lookup[i][k] = operation(lookup[i][k - 1], lookup[i + (1 << (k - 1))][k - 1]);
            }
        }
    }

    // Query function
    int query(int L, int R) {
        int k = bin_log[R - L + 1];
        return operation(lookup[L][k], lookup[R - (1 << k) + 1][k]);
    }
};

int main() {
    int n;
    cin >> n;
    vector<int> arr(n);
    for (int i = 0; i < n; i++)
        cin >> arr[i];

    string func_name;
    cin >> func_name;

    SparseTable st;
    st.build(arr, n, func_name);

    int q;
    cin >> q;
    while (q--) {
        int L, R;
        cin >> L >> R;
        cout << st.query(L, R) << "\n";
    }
    return 0;
}


/*int main() {
    vector<int> arr = {7, 8, 9, 4, 5, 6, 7, 4, 1};
    int n = arr.size();
    string func_name = "min";

    SparseTable st;
    st.build(arr, n, func_name);

    vector<pair<int, int>> queries = {{0, 4}, {4, 7}, {7, 8}};
    cout << "Function: " << func_name << endl;
    for (auto [L, R] : queries) {
        cout << "Query (" << L << ", " << R << ") -> " << st.query(L, R) << endl;
    }

    return 0;
}*/