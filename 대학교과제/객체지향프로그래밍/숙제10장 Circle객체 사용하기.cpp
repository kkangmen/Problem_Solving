#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

class Circle{
    string name;
    int radius;
public:
    Circle(int radius = 1, string name = ""){
        this->radius = radius;
        this->name = name;
    }
    double getArea(){
        return 3.14*radius*radius;
    }
    string getName(){
        return name;
    }
    bool operator < (Circle &b){
        return (radius < b.radius)? true : false;
    }
    friend ostream &operator<<(ostream &os, vector<Circle> &v);
};

ostream &operator<<(ostream &os, vector<Circle> &v){
    os << "모든원소를 출력한다.>>";
    // for (int i = 0; i < v.size(); i++){
    //     os << v[i].getName() << ' ';
    // }
    vector<Circle>::iterator it;
    for (it = v.begin(); it != v.end(); it++){
        os << it->getName() << ' ';
    }
    return os;
}

void printVector(vector<Circle> &v){
    cout << "모든원소를 출력한다.>>";
    // for (int i = 0; i < v.size(); i++){
    //     cout << v[i].getName() << ' ';
    // }
    vector<Circle>::iterator it;
    for (it = v.begin(); it != v.end(); it++){
        cout << it->getName() << ' ';
    }
    cout << '\n';
}
int main(){
    vector<Circle> v;
    v.push_back(Circle(2, "waffle"));
    v.push_back(Circle(3, "pizza"));
    v.push_back(Circle(1, "dotnet"));
    v.push_back(Circle(5, "pizzsLarge"));
    printVector(v);
    sort(v.begin(), v.end());
    printVector(v);
    cout << '\n' << "프랜드함수 operator <<로 출력하는 경우" << '\n';
    cout << v << '\n';
}
