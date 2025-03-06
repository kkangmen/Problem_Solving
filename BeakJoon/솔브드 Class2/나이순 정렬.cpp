#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(pair<int, string> a, pair<int, string> b){
    return a.first < b.first;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);

    vector<pair<int, string>> v;
    int n;
    cin >> n;

    while (n--){
        int age;
        string name;
        cin >> age >> name;
        v.push_back(make_pair(age, name)); 
    }

    stable_sort(v.begin(), v.end(), compare);

    for (int i = 0; i < v.size(); i++){
        cout << v[i].first << ' ' << v[i].second << '\n';
    }
    return 0;
}