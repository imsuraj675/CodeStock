// C++ Code Example
#include <iostream>
using namespace std;

void func_body(string &s) {
    // The required function which will be added
    int n = s.size();
    for(int i = 0; i<n; i++){
        for(int j = i; j<n; j++){
            cout<<s.substr(i, j-i+1)<<"\n";
        }
    }
}

int main() {
    // Main function where the function is called and use case is demonstrated
    string s = "abcd";
    func_body(s);
    return 0;
}