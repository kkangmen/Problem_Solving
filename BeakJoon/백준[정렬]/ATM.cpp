#include <iostream>
#include <algorithm>

using namespace std;

int a[1001];
int ps[1001];

int main(){
    int n;
    cin >> n;

    for (int i = 1; i <= n; i++){
        cin >> a[i];
    }

    sort(a, a+n+1);

    for (int i = 1; i <= n; i++){
        ps[i] = ps[i-1] + a[i];
    }

    int sum = 0;
    for (int i = 1; i <= n; i++){
        sum += ps[i];
    }
    cout << sum << '\n';
    return 0;
}