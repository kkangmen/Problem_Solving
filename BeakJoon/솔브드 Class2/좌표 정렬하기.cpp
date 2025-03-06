#include <iostream>

using namespace std;

int main(){
    int n;
    int min_x = 100001;
    int min_y = 100001;
    int index;

    cin >> n;

    int x[n] = {0, };
    int y[n] = {0, };

    for (int i = 0; i < n; i++){
        cin >> x[i];
        cin >> y[i];
    }

    for (int i = 0; i < n; i++){
        if (x[i] < min_x){
            min_x = x[i];
            index = i;
        }
        else if (x[i] == min_x){
            if (y[index] < y[i]){
                min_x = x[index];
            }
            else {
                min_x = x[i];
            }
        }
    }
    return 0;
}