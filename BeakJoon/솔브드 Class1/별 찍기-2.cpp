#include <iostream>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++){
        for (int j = n - i; j > 1; j--){
            cout << " ";

        }
        for (int j = 0; j < i + 1; j++){
            cout << "*";
        }
        cout << '\n';
    }
    
    return 0;
}