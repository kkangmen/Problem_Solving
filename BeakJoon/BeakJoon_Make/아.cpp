#include <iostream>
#include <string>
#include <vector>
using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    string sound, doctor;
    cin >> sound >> doctor;

    if (sound.size() < doctor.size()){
        cout << "no" << '\n';
    }
    else {
        cout << "go" << '\n';
    }
    return 0;
}