#include <iostream>
#include <string>
using namespace std;

class Circle{
private:
    int radius;
public:
    Circle(){radius = 1;}
    Circle(int r){radius = r;}
    void setRadius(int r){radius = r;}
    int getRadius(){return radius;}
    double getArea(){return 3.14*radius*radius;}
};

class Sample{
private:
    Circle *p;
    int capacity;
    int size;
public:
    Sample(int n){
        capacity = n;
        p = new Circle[n];
    }
    void read();
    void write();
    Circle big();
    int getSize(){return size;}
    ~Sample(){delete[]p;}
};

void Sample::read(){
    cout << "입력할려는 원의 갯수는 ? ";
    int num;
    int input;
    cin >> num;
    size = num;
    cout << size << "개의 원의 반지름을 입력하시오 ";
    for (int i = 0; i < size; i++){
        cin >> input;
        p[i].setRadius(input);
    }
}
void Sample::write(){
    for (int i = 0; i < size; i++){
        cout << p[i].getRadius() << ' ';
    }
    cout << '\n' << '\n';
}
Circle Sample::big(){
    int max = p[0].getRadius();
    for (int i = 1; i < size; i++){
        if (max < p[i].getRadius()){
            max = p[i].getRadius();
        }
    }
    Circle cir(max); //반지름이 max인 Circle 클래스 생성자 생성
    return cir; // 객체 cir을 리턴한다.
}
int main(){
    Sample s(10);
    s.read();
    cout << "각 원 객체의 반지름 " << s.getSize() << "개를 출력합니다.";
    s.write();   
    Circle big = s.big();
    cout << "가장 큰 원의 넓이: " << big.getArea() << "\t가장 큰 원의 반지름: " << big.getRadius() << '\n';

    return 0;
}