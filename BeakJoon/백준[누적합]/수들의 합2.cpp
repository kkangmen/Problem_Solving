#include <iostream>
#include <algorithm>

using namespace std;

//int a[10001];
//int p[10001];

int main(){
    int n, m;
    cin >> n >> m;
    int a[n] = {0,};
    int p[n] = {0, };

    for (int i = 1; i <= n; i++){
        cin >> a[i];
    }

    for (int i = 1; i <= n; i++){
        p[i] = p[i-1] + a[i];
    }

    int l = 1;
    int r = 1;
    int cnt = 0;
    while (r < n+1){
        if (p[r] - p[l-1] > m){
            l++;
        }
        else if (p[r] - p[l-1] < m){
            r++;
        }
        else {
            cnt++;
            l++;
        }
    }

    cout << cnt << '\n';
    return 0;
}