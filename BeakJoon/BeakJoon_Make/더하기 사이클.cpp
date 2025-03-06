#include <iostream>

using namespace std;

int main(){
    int n;
    cin >> n;

    int cnt = 0;
    int ans = n;
    while(1){
        int ten = n/10;
        int one = n%10;

        n = one*10 + (ten+one)%10;
        cnt++;

        if (n == ans){
            cout << cnt << '\n';
            break;
        }
    }
    return 0;
}