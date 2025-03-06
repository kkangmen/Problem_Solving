#include <iostream>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    
    int div_arr[42] = {0,};
    int num;
    int cnt = 0;

    for (int i = 0; i < 10; i++){
        cin >> num;

        div_arr[num % 42]++;
    }

    for (int i = 0; i < 42; i++){
        if (div_arr[i] > 0){
            cnt++;
        }
    }

    cout << cnt << '\n';
    return 0;
}