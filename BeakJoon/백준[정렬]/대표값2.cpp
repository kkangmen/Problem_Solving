#include <iostream>
#include <algorithm>

using namespace std;

int main(){
    int a[5];
    for (int i = 0; i < 5; i++){
        cin >> a[i];
    }

    sort(a, a+5);

    int sum = 0;
    for (int i = 0; i < 5; i++){
        sum += a[i];
    }

    cout << sum / 5 << '\n';
    cout << a[2] << '\n';
    return 0;
}