#include <iostream>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);

    int c;
    cin >> c;

    for (int i = 0; i < c; i++){
        int n;
        cin >> n;

        double a[n] = {0, };

        for (int j = 0; j < n; j++){
            cin >> a[j];
        }

        int sum = 0;
        for (int j = 0; j < n; j++){
            sum += a[j];
        }
        double avg = sum / n;

        double cnt = 0;
        for (int j = 0; j < n; j++){
            if (a[j] > avg){
                cnt++;
            }
        }

        double ans = cnt / n * 100;
        cout << fixed;
        cout.precision(3);
        cout << ans << '%' << '\n';
    }
    return 0;
}