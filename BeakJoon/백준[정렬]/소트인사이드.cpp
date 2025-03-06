#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(int,int);

int main(){
    vector<int> v;
    int n;
    cin >> n;

    while (n != 0){
        v.push_back(n%10);

        n = n/10;
    }

    sort(v.begin(), v.end(), compare);

    for (int i = 0; i < v.size(); i++){
        cout << v[i];
    }
    return 0;
}

bool compare(int a, int b){
    return a > b;
}