#include <iostream>
#include <vector>
using namespace std;

int u_bound(vector<int>& a, int key) {
    int l=0, r=a.size()-1;
    int ans = -1;
    while(l<=r) {
        int mid = (l+r)/2;
        if(a[mid] <= key) {
            ans = max(ans,mid);
            l = mid+1;
        }
        else    r = mid-1;
    }
    if(ans != -1 && a[ans] == key)   return ans;
    return -1;
}

int main() {

    vector<int> a = {1,2,2,2,2,3,5};
    int key = 2;
    int UBound = u_bound(a,key);
    if(UBound == -1)    printf("The number does not exist.\n");
    else    printf("Upper Bound of \'%d\' = %d\n",key,UBound);

    return 0;
}