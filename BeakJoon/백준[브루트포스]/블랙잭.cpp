#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<long long int> v;

int main(){
    long long int n, m;
    cin >> n >> m;

    for (int i = 0; i < n; i++){
        long long int x;
        cin >> x;
        v.push_back(x);
    }

    int ans = 300001;
    int ans_ans;
    for (int i = 0; i < v.size() - 2; i++){
        for (int j = i+1; j < v.size() - 1; j++){
            for (int k = j+1; k < v.size(); k++){
                if (abs((v[i] + v[j] + v[k]) - m)  < ans && v[i]+v[j]+v[k] <= m){
                    ans = abs((v[i] + v[j] + v[k]) - m);
                    ans_ans = (v[i] + v[j] + v[k]);
                }
            }
        }
    }

    cout << ans_ans << '\n';
    return 0;
}