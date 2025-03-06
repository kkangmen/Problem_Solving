#include <iostream>
#include <string>

using namespace std;

int main(){
    string sentence;
    int count = 1;

    getline(cin, sentence);

    for (int i = 0; i < sentence.size(); i++){
        if (sentence[i] == ' '){
            count++;
        }
    }

    if (sentence[0] == ' '){
        count--;
    }
    if (sentence[sentence.length()-1] == ' '){
        count--;
    }

    cout << count << '\n';
    return 0;
}

