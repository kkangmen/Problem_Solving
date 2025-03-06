#include <iostream>
#include <vector>
#define MAX 10001
using namespace std;

vector<bool> v(MAX, true);


int main(){
    for (int i = 1; i < MAX; i++){
        int num = i;
        int sum = 0;
        while (num != 0){
            sum += num % 10;
            num /= 10;
        }
        if (i + sum < 10001){
            v[i+sum] = false;
        }
    }
    for (int i = 1; i < MAX; i++){
        if (v[i]){
            cout << i << '\n';
        }
    }
    return 0;
}