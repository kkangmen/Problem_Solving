#include <iostream>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    
    int a, b, c;
    int arr[10] = {0, };
    int index;

    cin >> a >> b >> c;

    int mult = a * b * c;

    while (mult != 0){
        int index = mult % 10;
        arr[index]++;
        mult = mult / 10;
    }

    for (int i = 0; i < 10; i++){
        cout << arr[i] << '\n';
    }
    return 0;
}