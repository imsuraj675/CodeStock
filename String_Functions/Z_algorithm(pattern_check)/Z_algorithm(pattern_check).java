#include <iostream>
#include <vector>
#include <string>

using namespace std;

void zfunction(const string& text, const string& pattern) {
    // Create concatenated string "P$T"
  //At every instance,we are matching the contents of the given string with the beginning of the concatenated string which contains the pattern,
  //if the length of window equals to the pattern length then we have located the presence of given pattern in the string at certain index
    string concat = pattern + "$" + text;
    int n = concat.length();

    // Z-array to store lengths of the longest prefix substring starting from each position
    vector<int> Z(n, 0);
    int l = 0, r= 0;

    for (int i = 1; i < n; ++i) {
        if (i <= r)
            Z[i] = min(r - i + 1, Z[i - l]);
        while (i + Z[i] < n && concat[Z[i]] == concat[i + Z[i]])
            ++Z[i];
        if (i + Z[i] - 1 > r) {
            l = i;
            r = i + Z[i] - 1;
        }
    }

    // Search for the pattern in the text using the Z-array
    for (int i = 0; i < n; ++i) {
        if (Z[i] == pattern.length()) {
            cout << "Pattern found at index " << i - pattern.length() - 1 << endl;
        }
    }
}

int main() {
    string givenstring = "WORLD PEACE";
    string pattern = "PEACE";

    // Perform pattern search using Z algorithm
    zfunction(givenstring, pattern);

    return 0;
}
