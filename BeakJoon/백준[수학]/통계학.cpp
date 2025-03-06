#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric>
#include <cmath>

using namespace std;

int arr[10000];

int func(vector<int>& v){
    for (int i = 0; i < v.size(); i++){
        if (v[i] >= 0){
            arr[v[i]]++;
        }
        else {
            arr[abs(v[i]) + 4000]++;
        }
    }

    int max = arr[0];
    int index = 0;
    for (int i = 0; i < 10000; i++){
        if (max < arr[i]){
            index = i;
            max = arr[i];
        }
    }

    vector<int> v2;
    for (int i = 0; i < 10000; i++){
        if (max == arr[i]){
            if (i <= 4000){
                v2.push_back(i);
            }
            else {
                v2.push_back((i-4000)*(-1));
            }
        }
    }

    sort(v2.begin(), v2.end());
    if (v2.size() == 1){
        return v2[0];
    }
    else {
        return v2[1];
    }
}
int main(){
    long long n;
    cin >> n;

    vector<int> v(n);

    for (int i = 0; i < n; i++){
        cin >> v[i];
    }

    sort(v.begin(), v.end());

    double sum = 0;
    for (int i = 0; i < v.size(); i++){
        sum += v[i];
    }

    sum = round(sum/n);
    if (sum == -0){
        sum = 0;
    }

    cout << sum << '\n';
    cout << v[n/2] << '\n';
    cout << func(v) << '\n';
    cout << *max_element(v.begin(), v.end()) - *min_element(v.begin(), v.end()) << '\n';
    return 0;
}