#include <iostream>
#include <vector>

using namespace std;

template <typename T>
void reverse_in_place(vector<T> &vc)
{
    int n = vc.size();
    int low = 0, high = n - 1;
    while (low < high)
    {
        swap(vc[low], vc[high]);
        low++;
        high--;
    }
}

int main()
{
    vector<int> vc = {1, 2, 3};
    reverse_in_place(vc);
    for (int i : vc)
        cout << i << " ";
    cout << endl;
    return 0;
}
