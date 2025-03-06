#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int lower_bound(vector<int>& v, int target);
int upper_bound(vector<int>& v, int target);

vector<int> v;

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

        cout << upper_bound(v, num) - lower_bound(v, num) << '\n';
    }
    return 0;
}

int upper_bound(vector<int>& v, int target){
    int left = 0;
    int right = v.size();

    while (left < right){
        int mid = (left + right) / 2;

        if (v[mid] == target){
            left = mid+1;
        }
        else if (v[mid] < target){
            left = mid+1;
        }
        else {
            right = mid;
        }
    }

    return left;
}

int lower_bound(vector<int>& v, int target){
    int left = 0;
    int right = v.size();

    while (left < right){
        int mid = (left+right)/2;

        if (v[mid] == target){
            right = mid;
        }
        else if (v[mid] < target){
            left = mid+1;
        }
        else {
            right = mid;
        }
    }

    return left;
}

