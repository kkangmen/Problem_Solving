#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int n, k;
vector<int> v;
int cnt = 0;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n >> k;
    for (int i = 0; i < n; i++){
        int m;
        cin >> m;
        v.push_back(m);
    }

    reverse(v.begin(), v.end());

    while (k != 0){
        for (int i = 0; i < n; i++){
            if (v[i] <= k){
                k -= v[i];
                i--;
                cnt++;
            }
        }
    }

    cout << cnt << '\n';
    return 0;
}