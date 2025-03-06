#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int compare(pair<int,int>, pair<int,int>);

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);

    vector<pair<int, int>> v;
    int n;
    cin >> n;

    for(int i = 0; i < n; i++){
        int a, b;
        cin >> a >> b;
        v.push_back(make_pair(a, b));
    }

    sort(v.begin(), v.end());
    stable_sort(v.begin(), v.end(), compare);

    cout << "After sort" << '\n';
    for (int i = 0; i < n; i++){
        cout << v[i].first << ' ' << v[i].second << '\n';
    }
    return 0;
}

int compare(pair<int, int> a, pair<int,int> b){
    return a.second < b.first;
}