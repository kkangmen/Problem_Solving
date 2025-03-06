#include <iostream>

using namespace std;

bool isprime[10000001];

int main(){
    int n;
    cin >> n;

    for (int i = 2; i*i <= n; i++){
        if (isprime[i] == false){
            for (int j = i*2; j <= n; j+=i){
                isprime[j] = true;
            }
        }
    }

    while (n != 1){
        for (int i = 2; i <= n; i++){
            if (isprime[i] == false && n % i == 0){
                cout << i << '\n';
                n /= i;
                break;
            }
        }
    }
    return 0;
}