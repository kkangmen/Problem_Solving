#include <iostream>
#include <vector>

using namespace std;

int main(){
    int n;
    cin >> n;

    vector<pair<int, int>> v(n);

    for (int i = 0; i < n; i++){
        cin >> v[i].first >> v[i].second;
    }

   
    for (int i = 0; i < n; i++){
        int rank = 1;
        for (int j = 0; j < n; j++){
            if (v[i].first < v[j].first && v[i].second < v[j].second){
                rank++;
            }
        }
        cout << rank << ' ';
    }
    return 0;
}