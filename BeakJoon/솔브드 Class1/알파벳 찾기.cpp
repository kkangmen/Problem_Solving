#include <iostream>

using namespace std;

int main(){
    string sentence;
    int index_arr[26];

    fill_n(index_arr, 26, -1);
    
    cin >> sentence;

    for (int i = 0; i < sentence.size(); i++){
        if (index_arr[sentence[i] - 97] > -1){
            continue;
        }
        else{
            index_arr[sentence[i] - 97] = i; 
        }
    }

    for (int i = 0; i < 26; i++){
        cout << index_arr[i] << " ";
    }
    return 0;
}