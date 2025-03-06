#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> v;

bool binary_search(vector<int>& v, int target);

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    
    int n;
    cin >> n;

    for (int i = 0; i < n; i++){
        int x;
        cin >> x;
        v.push_back(x);
    }

    sort(v.begin(), v.end());

    int m;
    cin >> m;
    for (int i = 0; i < m; i++){
        int num;
        cin >> num;

        cout << binary_search(v , num) << '\n';
    }
    return 0;   
}

bool binary_search(vector<int>& v, int target){
    int left = 0;
    int right = v.size() -1;

    while (left <= right){
        int mid = (left + right) / 2;
        if (v[mid] == target){
            return true;
        }
        else if (v[mid] < target){
            left = mid+1;
        }
        else {
            right = mid-1;
        }
    }
    return false;
}