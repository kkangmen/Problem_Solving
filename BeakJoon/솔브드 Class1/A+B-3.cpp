#include <iostream>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);

    int t;
    int a, b;

    cin >> t;

    while (t--){
        cin >> a >> b;
        cout << a + b << endl;
    }

    
    return 0;
}