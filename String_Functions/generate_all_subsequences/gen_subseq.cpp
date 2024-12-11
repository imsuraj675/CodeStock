// C++ Code Example
#include <bits/stdc++.h>
using namespace std;
void helper(string &s, int n,  int i, string &sub, vector<string> &container){
    if(i>=n) {
        container.push_back(sub);
        return;
    }
    sub.push_back(s[i]);
    helper(s, n, i+1, sub, container);
    sub.pop_back();
    helper(s, n, i+1, sub, container);
    return;
}
vector<string> func_body(string &s) {
    // The required function which will be added
    int n = s.size();
    vector<string> ans;
    string sub;
    helper(s, n, 0, sub, ans);
    return ans;
}

int main() {
    // Main function where the function is called and use case is demonstrated
    string s = "abcd";
    vector<string> all_subsequences = func_body(s);
    for(auto x: all_subsequences) cout<<x<<"\n";
    return 0;
}