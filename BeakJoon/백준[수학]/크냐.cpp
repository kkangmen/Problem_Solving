#include <iostream>
#include <string>
#include <vector>
using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int x, y;
    while (1){
        cin >> x >> y;
        if (x == 0 && y == 0 ){
            break;
        }
        else{
            if (x > y ){
                cout << "Yes" << '\n';
            }
            else{
                cout << "No" << '\n';
            }
        }
    }
    return 0;
}