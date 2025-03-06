#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

int compare(string, string);

int main(){
    int n;
    cin >> n;
    vector<string> arr(n);

    for (int i = 0; i < n; i++){
        cin >> arr[i];
    }
    sort(arr.begin(), arr.end());
    stable_sort(arr.begin(), arr.end(), compare);
    arr.erase(unique(arr.begin(), arr.end()), arr.end());

    for (int i = 0; i < arr.size(); i++){
        cout << arr[i] << '\n';
    }
    return 0;
}

int compare(string a, string b){
    return a.length() < b.length();
}