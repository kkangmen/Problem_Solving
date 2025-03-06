#include <iostream>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);

    int t;
    string ox;
    int sum = 0;
    int cnt = 0;

    cin >> t;
    cin.ignore();

    while (t--){
        cin >> ox;

        for (int i = 0; i < ox.size(); i++){
            if (ox[i] == 'O'){
                cnt++;
                sum += cnt;
            }
            else{
                cnt = 0;
            }
        }
        cout << sum << '\n';
        sum = 0;
        cnt = 0;
    }

    return 0;
}