#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main(){
    string sentence;
    int arr[26] = {0, };
    int cnt = 0;
    int max_num = 0;
    int max_index = 0;

    getline(cin, sentence);

    for (int i = 0; i < sentence.size(); i++){
        sentence[i] = toupper(sentence[i]);
    }

    for (int i = 0; i < sentence.size(); i++){
        arr[sentence[i]-65]++;
    }
    
    for (int i = 0; i < sizeof(arr)/sizeof(*arr); i++){
        if(max_num < arr[i]){
            max_num = arr[i];
            max_index = i;
        } 
    }
    
    for (int i = 0; i < sizeof(arr)/sizeof(*arr); i++){
        if (arr[i] == max_num){
            cnt++;
        }
    }

    if (cnt > 1){
        cout << '?' << '\n';
    }
    else{
        cout << static_cast<char>(max_index+65) << '\n';
    }
    return 0;
}