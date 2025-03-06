#include <iostream>
#include <cstring>

using namespace std;

void checkalpha(char *str, int length){ // 알파벳 숫자를 세는 함수
    int alpha[26] = {0, }; // a~z까지 알파벳 숫자를 셀 배열 생성
    for (int i = 0; i < length; i++){
        alpha[str[i]-97]++;
    }

    for (int i = 0; i < 26; i++){
        cout << static_cast<char>(i+97) << " (" << alpha[i] << ") :";
        for (int j = 0; j < alpha[i]; j++){
            cout << '*';
        }
        cout << '\n';
    }
}

int main(){
    char str[10000]; // 문자열 10000 size 배열 생성
    int count = 0; // 총 알파벳 수

    cout << "영문 텍스트를 입력하세요. 히스토그램을 그립니다." << '\n';
    cout << "텍스트의 끝은 ; 입니다. 10000개까지 가능합니다." << '\n';
    cin.getline(str, 10000, ';');

    for (int i = 0; i < strlen(str); i++){
        str[i] = tolower(str[i]); // 모든 알파벳을 소문자로 바꿈
    }

    for (int i = 0; i < strlen(str); i++){
        if (isalpha(str[i])){ // 만약 문자열 중 알파벳이라면 알파벳 수 증가
            count++; 
        }
    }

    cout << "총 알파벳 수 " << count << '\n';
    cout << '\n';

    checkalpha(str, strlen(str)); // 알파벳 수를 세는 함수 호출
    return 0;
}