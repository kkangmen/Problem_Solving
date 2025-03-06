#include <iostream>
#include <string>
#include <vector>
using namespace std;
#define MAX 1234567891
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int l;
    string s;
    long long sum = 0;
    long long val = 1;

    cin >> l;
    cin.ignore();
    getline(cin, s);

    for (int i = 0; i < s.length(); i++)
    {
        int sc = (s[i] - 'a') + 1;
        sum += (sc * val) % MAX;
        val = (val * 31) % MAX;
    }
    cout << sum % MAX << '\n';
    return 0;
}