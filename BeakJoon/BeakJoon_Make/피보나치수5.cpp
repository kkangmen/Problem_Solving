#include <iostream>
#include <string>
#include <vector>
using namespace std;

int fib(int x){
    if (x == 0){
        return 0;
    }
    if (x == 1){
        return 1;
    }
    return fib(x-1) + fib(x-2);
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n;
    cin >> n;

    cout << fib(n) << '\n';
    return 0;
}