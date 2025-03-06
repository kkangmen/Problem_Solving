#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int compare(int, int);

int main(){
    int n;
    cin >> n;
    vector<int> v(n);
    for (int i = 0; i < n; i++){
        cin >> v[i];
    }
    sort(v.begin(), v.end(), compare);

    for (int i : v){
        cout << i << '\n';
    }
    return 0;
}

int compare(int a, int b){
    return a < b;
}