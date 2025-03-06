#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main(){
    int n;
    cin >> n;

    vector<int> v;
    vector<int> v_sort;
    for (int i = 1; i <= n; i++){
        int x;
        cin >> x;
        v.push_back(x);
        v_sort.push_back(x);
    }

    sort(v_sort.begin(), v_sort.end());
    v_sort.erase(unique(v_sort.begin(), v_sort.end()), v_sort.end());

    for (int i = 1; i <= n; i++){
        v[i];
    }
    return 0;
}