#include <iostream>
#include <vector>

using namespace std;

template <typename T>

void reverse_in_place(vector<T> &arr){
    int n = arr.size();
    for (int i = 0; i < n/2; i++){
        T temp = arr[i];
        arr[i] = arr[n-1-i];
        arr[n-1-i] = temp;
    }
    return;
}

int main()
{
    vector<int> arr = {1, 2, 3};
    reverse_in_place(arr);
    for (int num : arr)
        cout << num << " ";
    cout << endl;
    return 0;
}