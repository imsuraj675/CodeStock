#include <bits/stdc++.h>
using namespace std;

vector<long long> factorial(int n, int p) {
    vector<long long> res(n+1, 1);
    for(int i=1;i<=n;i++) {
        res[i] = (1LL * res[i-1] * i) % p;
    }

    return res;
}

int main() {
    int n = 25, p = 29;
    vector<long long> res = factorial(n, p);

    for(auto i:res) {
        cout<<i<<" ";
    }
}