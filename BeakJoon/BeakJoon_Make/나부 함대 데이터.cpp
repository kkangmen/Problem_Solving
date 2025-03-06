#include <iostream>
#include <string>
#include <vector>
using namespace std;

/*
출력 문자들을 정렬하기 위해 공백을 사용하는 방법
1. width();
- 지정하고자 하는 간격을 괄호 안에 숫자로 입력.
- 오른쪽 정렬을 하고 싶을 땐 right, 왼쪽 정렬을 하고 싶을 땐 left
- cout.width();
2. setw();
- 헤더파일 <iomanip> 추가해야함
*/
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cout << "SHIP NAME      CLASS          DEPLOYMENT IN SERVICE" << '\n';
    cout << "N2 Bomber      Heavy Fighter  Limited    21        " << '\n';
    cout << "J-Type 327     Light Combat   Unlimited  1         " << '\n';
    cout << "NX Cruiser     Medium Fighter Limited    18        " << '\n';
    cout << "N1 Starfighter Medium Fighter Unlimited  25        " << '\n';
    cout << "Royal Cruiser  Light Combat   Limited    4         " << '\n';
    return 0;
}