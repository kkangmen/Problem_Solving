#include <iostream>
#include <algorithm>

using namespace std;

int main(){
    int n;
    cin >> n;

    int arr[n];
    for (int i = 0; i < n; i++){
        cin >> arr[i];
    }

    sort(arr, arr+n, greater<>());

    for (int i : arr){
        cout << i << '\n';
    }
    return 0;
}