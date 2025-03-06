#include <iostream>
#include <string>
#include <vector>
using namespace std;

int a, b, c;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> a >> b >> c;
    cout << a + b - c << '\n';
    string a_s = to_string(a);
    string b_s = to_string(b);
    string k = a_s + b_s;
    int k_i = stoi(k);
    cout << k_i - c << '\n';
    return 0;
}