#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

bool compare(int a, int b){
    return a < b;
}
int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);

    vector<int> v;
    for (int i = 0; i < 3; i++){
        int x;
        cin >> x;
        v.push_back(x);
    }

    sort(v.begin(), v.end(), compare);

    cout << v[1] << '\n';
    return 0;
}