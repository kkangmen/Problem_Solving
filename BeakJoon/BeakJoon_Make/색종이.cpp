#include <iostream>

using namespace std;

bool a[101][101];

int main(){
    int n;
    cin >> n;

    while (n--){
        int x, y;
        cin >> x >> y;

        for (int i = x; i <= x+10; i++){
            for (int j = y; j <= y+10; j++){
                if (a[i][j] == false){
                    a[i][j] = true;
                }
            }
        }
    }

    int cnt = 0;
    for (int i = 1; i <= 100; i++){
        for (int j = 1;j <= 100; j++){
            if (a[i][j]){
                cnt++;
            }
        }
    }

    cout << cnt << '\n';
    return 0;
}