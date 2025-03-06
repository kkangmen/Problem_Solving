#include <iostream>
#include <vector>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    
    int n;
    cin >> n;
    vector<int> v(10001);
    for(int i = 0; i < n; i++){
        int x;
        cin >> x;
        v[x]++;
    }

    for (int i = 1; i < 10001; i++){
        for (int j = 0; j < v[i]; j++){
            cout << i << '\n';
        }
    }
    return 0;
}