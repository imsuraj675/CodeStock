#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

int mex(vector<int>& arr)
{

	sort(arr.begin(), arr.end());

	int mex = 0;
	for (int i = 0; i < arr.size(); i++)
	{
		if (arr[i] == mex)
		{
			mex += 1;
		}
	}
	return mex;
}

int main()
{
	vector<int> arr = { 1, 0, 2, 4 };
	cout << mex(arr) << endl;
	return 0;
}

