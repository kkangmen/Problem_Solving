#include <iostream>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie();

    int t;
    int num;
    string sentence;

    cin >> t;

    while (t--){
        cin >> num;
        cin.ignore();

        getline(cin, sentence);

        for (char c : sentence){
            for (int i = 0; i < num; i++){
                cout << c;
            }
        }
        cout << '\n';
    }
    return 0;
}