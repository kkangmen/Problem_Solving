#include <iostream>

using namespace std;

long long int d[101];

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);

    int t;
    cin >> t;

    d[1] = d[2] = d[3] = 1;
    d[4] = d[5] = 2;

    for (int i = 6; i <= 100; i++){
        d[i] = d[i-1] + d[i-5];
    }

    while (t--){
        int n;
        cin >> n;

        cout << d[n] << '\n';
    }
    return 0;
}