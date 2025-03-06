#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> v;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    
    int real_divisor_num;
    cin >> real_divisor_num;

    for (int i = 0; i < real_divisor_num; i++){
        int real_divisor;
        cin >> real_divisor;
        v.push_back(real_divisor);
    }

    cout << *max_element(v.begin(), v.end()) * *min_element(v.begin(), v.end()) << '\n';
    return 0;
}