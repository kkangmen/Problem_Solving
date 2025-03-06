#include <iostream>
#include <string>
#include <vector>
using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    vector<pair<int, int>> v;
    for (int i = 0; i < 3; i++){
        int x, y;
        cin >> x >> y;
        v.push_back(make_pair(x, y));
    }

    if (v[0].first == v[1].first){
        cout << v[2].first << ' ';
    }
    else if (v[0].first == v[2].first){
        cout << v[1].first << ' ';
    }
    else{
        cout << v[0].first << ' ';
    }

    if (v[0].second == v[1].second){
        cout << v[2].second << '\n';
    }
    else if (v[0].second == v[2].second){
        cout << v[1].second << '\n';
    }
    else{
        cout << v[0].second << '\n';
    }
    return 0;
}
