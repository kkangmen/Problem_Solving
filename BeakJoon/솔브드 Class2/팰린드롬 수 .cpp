#include <iostream>
#include <vector>
#include <stack>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    
    vector <int> v1;
    vector <int> v2;
    stack <int> s;

    while (1){
        string num;
        int result = 0;

        getline(cin, num);

        if (num == "0"){
            break;
        }
        else{
            for (int i = 0; i < num.size(); i++){
                v1.push_back(num[i]);
                s.push(num[i]);
            }

            for (int i = 0; i < num.size(); i++){
                while (!s.empty()){
                    v2.push_back(s.top());
                    s.pop();
                }
            }

            for (int i = 0; i < num.size(); i++){
                if (v1[i] != v2[i]){
                    result++;
                }
            }
        }
        if (result == 0){
            cout << "yes" << '\n';
            v1.clear();
            v2.clear();
        }
        else {
            cout << "no" << '\n';
            result == 0;
            v1.clear();
            v2.clear();
        }
    }
    return 0;
}