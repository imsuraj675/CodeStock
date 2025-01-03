#include <iostream>
#include <vector>
#include <string>

using namespace std;

void getLps(const string& pattern, vector<int>& lps) {
    int len = 0;
    lps[0] = 0;

    int i = 1;
    while (i < pattern.length()) {
        if (pattern[i] == pattern[len]) { //characters match, increase len
            len++;
            lps[i] = len;
            i++;
        } else {
            if (len != 0) len = lps[len - 1];
            else {
                lps[i] = 0; //couldn't find a prefix that is also suffix, move forward
                i++;
            }
        }
    }
}

vector<int> search(const string& text, const string& pattern) {
    int n = text.length();
    int m = pattern.length();

    vector<int> ans;
    if (m > n) return ans;   //pattern larger than text, no match can be found. return empty list.

    vector<int> lps(m);
    getLps(pattern, lps);

    int i = 0;
    int j = 0;

    while (i < n) {
        if (text[i] == pattern[j]) {
            i++;
            j++;
            if (j == m) {               //match found
                ans.push_back(i - m);   //add starting index to list
                j = lps[j - 1];         //adjust j using lps to begin finding next match
            }
        } else {
            if (j != 0) j = lps[j - 1];
            else i++;
        }
    }
    return ans; 
}

int main() {
    string text = "ababacabab"; 
    string pattern = "aba"; 

    vector<int> ans = search(text, pattern);
    for (int idx : ans) 
        cout << idx << " ";
    
    return 0;
}