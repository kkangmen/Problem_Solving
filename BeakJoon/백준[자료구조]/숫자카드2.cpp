#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> v;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    int n;
    cin >> n;

    for (int i = 0; i < n; i++){
        int x;
        cin >> x;
        v.push_back(x);
    }

    sort(v.begin(), v.end());

    int m;
    cin >> m;

    for (int i = 0; i < m; i++){
        int k;
        cin >> k;

        cout << upper_bound(v.begin(), v.end(), k) - lower_bound(v.begin(), v.end(), k) << ' ';
    }
    return 0;
}
