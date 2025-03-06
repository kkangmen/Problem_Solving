#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<long long> v;

int main(){
    long long k, n;
    cin >> k >> n;
    for (int i = 0; i < k; i++){
        int x;
        cin >> x;
        v.push_back(x);
    }

    long long left = 1;
    long long right = *max_element(v.begin(), v.end());
    long long ans = 0;
    while (left <= right){
        long long mid = (left+right)/2;
        long long cnt = 0;

        for (int i = 0; i < v.size(); i++){
            cnt += v[i]/mid;
        }
        if (cnt < n){
            right = mid-1;
        }
        else {
            ans = mid;
            left = mid+1;
        }
    }

    cout << ans << '\n';
    return 0;
}