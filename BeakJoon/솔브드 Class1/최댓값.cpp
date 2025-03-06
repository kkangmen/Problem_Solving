#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main(){
    vector<int> v;
    int num;

    for (int i = 0; i < 9; i++){
        cin >> num;
        v.push_back(num);
    }

    int max_num = v[0];
    int max_index = 0;

    for (int i = 1; i < 9; i++){
        max_num = max(max_num, v[i]);
    }

    cout << max_num << '\n';
    for (int i = 0; i < 9; i++){
        if (v[i] == max_num){
            cout << i+1 << '\n';
        }
    }
   
    

    return 0;
}