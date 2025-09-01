#include <bits/stdc++.h>
using namespace std;

vector<int> prefixSum(vector<int>& arr, int n) {
    vector<int> res(n);
    res[0] = arr[0];
    for(int i=1;i<n;i++) {
        res[i] = res[i-1] + arr[i];
    }
    return res;
}

int main() {
    int n = 5;
    vector<int> arr = {1, 2, 3, 4, 5};
    
    vector<int> preSum = prefixSum(arr, n);

    for(int i=0;i<n;i++) {
        cout<<preSum[i]<<" ";
    }
    cout<<endl;
}