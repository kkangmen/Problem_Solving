#include <iostream>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);

    int a[9];
    for (int i = 0; i < 9; i++){
        cin >> a[i];
    }

    while (1){
        int ans = 100;
        int sum = 0;

        for (int i = 0; i < 9; i++){
            for (int j = i+1; j < 9; j++){
                for (int k = 0; k < 9; k++){
                    if (k == i || k == j){
                        continue;
                    }
                    else {
                        sum += a[k];
                    }
                }
                if (sum == ans){
                    for (int l = 0; l < 9; l++){
                        if (l == i || l == j){
                            continue;
                        }
                        else {
                            cout << a[l] << '\n';
                        }
                    }
                    break;
                }
            }
        }
    }
    return 0;
}