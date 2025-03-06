#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

class EvenRandom{
public:
    EvenRandom();
    int next();
    int nextInRange(int low, int high);
};

EvenRandom::EvenRandom(){
    srand((unsigned int)time(NULL));
}
int EvenRandom::next(){
    int random_num = rand();
    if (random_num % 2 == 0){
        return random_num;
    }
    else {
        random_num -= 1;
        return random_num;
    }
}
int EvenRandom::nextInRange(int low, int high){
    int random_num = rand()%10+2;
    if (random_num % 2 == 0){
        return random_num;
    }
    else {
        random_num -= 1;
        return random_num;
    }
}

int main(){
    EvenRandom r;
    cout << "--0에서 " << RAND_MAX << "까지의 랜덤 짝수 정수 10개--" << '\n';
    for (int i = 0; i < 10; i++){
        int n = r.next();
        cout << n << ' ';
    }
    cout << '\n' << '\n';
    cout << "--2에서 " << "10 까지의 랜덤 짝수 정수 10개-- " << '\n';
    for (int i = 0; i < 10; i++){
        int n= r.nextInRange(2, 10);
        cout << n << ' ';
    }
    cout << '\n';

    return 0;
}