#include <iostream>
using namespace std;

class Complex{
private:
    double re;
    double im;
public:
    Complex(double r){
        re = r;
        im = 0;
    }
    Complex(double r = 0, double i = 0):re(r), im(i){}
    void Output(){
        cout << re << " + " << im << "i" << '\n';
    }
    Complex& operator+=(Complex& op1);
    Complex& operator-();
    friend Complex operator+(Complex& op1, Complex& op2);
    friend Complex operator++(Complex& op1);
    friend Complex operator++(Complex& op1, int x);
    friend ostream& operator<<(ostream& os, Complex& op1);
};

Complex& Complex::operator+=(Complex& op1){
    // Complex tmp;
    // tmp.re += op1.re;
    // tmp.im += op1.im;
    // return tmp;
    this->re += op1.re;
    this->im += op1.im;
    return *this;
};
Complex& Complex::operator-(){
    re = -re;
    im = -im;
    return *this;
}
Complex operator+(Complex& op1, Complex& op2){
    Complex tmp;
    tmp.re = op1.re + op2.re;
    tmp.im = op1.im + op2.im;
    return tmp;
};
Complex operator++(Complex& op1){
    op1.re++;
    op1.im++;
    return op1;
};
Complex operator++(Complex& op1, int x){
    Complex tmp = op1;
    op1.re++;
    op1.im++;
    return tmp;
};
ostream& operator<<(ostream& os, Complex& op1){
   os << '(' << op1.re << " + " << op1.im << 'i' << ')' << '\n';
    return os;
} 
int main(){
    Complex c1(1,2), c2(3,4), c(9,200);
    c1.Output();
    c2.Output();
    c1 += c2;
    c1.Output();
    Complex c3 = c1 + c2;
    Complex c4 = c1 += c2, c5, c6;
    c3.Output();
    c5 = ++c4;
    c4.Output();
    c5.Output();
    c6 = c4++;
    c4.Output();
    c6.Output();
    c2 = -c2;
    cout << c2;
    cout << c;
    return 0;
}