# include <iostream>
# include <vector>
# include <cmath>
using namespace std;

vector<int> get_factors(int n){
    vector<int> ans;
    int root = sqrt(n);
    for(int i=1; i<=root;i++){
        if (n%i ==0){
            ans.push_back(i); //pushing the factors <= root into a vector
            if ( i != (n/i)){
                ans.push_back(n/i); // pushing the corresponding factors which are greater than root(n)
            }

        }
    }
    return ans;
}

int main(){
    vector<int> a = get_factors(20); //sample input 1
    vector<int> a = get_factors(4); // sample input 2
    return 0;
}
