#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    vector<pair<string, int>> v;
    string sem;
    int vol;

    for (int i = 0; i < 7; i++){
        cin >> sem >> vol;
        v.push_back(make_pair(sem, vol));
    }

    int max_num = 0;
    int index = 0;
    for (int i = 0; i < 7; i++){
        if (max_num < v[i].second){
            max_num = v[i].second;
            index = i;
        }
    }

    cout << v[index].first << '\n';
    return 0;
}