#include <iostream>
#include <string>
#include <ctime>
#include <cstdlib>
using namespace std;

class Random{
public:
    static void seed();
    static int nextInt(int min, int max);
    static char nextAlphabet();
    static double nextDouble();
};
void Random::seed(){
    srand((unsigned)time(NULL));
}
int Random::nextInt(int min, int max){
    
}