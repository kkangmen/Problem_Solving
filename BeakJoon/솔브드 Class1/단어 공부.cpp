#include <iostream>
#include <string>

using namespace std;

int main(){
    string sentence;
    char arr[26];
    getline(cin, sentence);

    for (int i = 0; i < sentence.size(); i++){
        sentence[i] = toupper(sentence[i]);
    }

    for (int i = 0; i < sentence.size(); i++){
        
    }
    return 0;
}