#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string grade;
    cin >> grade;

    if (grade == "A+")
    {
        cout << "4.3" << '\n';
    }
    else if (grade == "A0")
    {
        cout << "4.0" << '\n';
    }
    else if (grade == "A-")
    {
        cout << "3.7" << '\n';
    }
    else if (grade == "B+")
    {
        cout << "3.3" << '\n';
    }
    else if (grade == "B0")
    {
        cout << "3.0" << '\n';
    }
    else if (grade == "B-")
    {
        cout << "2.7" << '\n';
    }
    else if (grade == "C+")
    {
        cout << "2.3" << '\n';
    }
    else if (grade == "C0")
    {
        cout << "2.0" << '\n';
    }
    else if (grade == "C-")
    {
        cout << "1.7" << '\n';
    }
    else if (grade == "D+")
    {
        cout << "1.3" << '\n';
    }
    else if (grade == "D0")
    {
        cout << "1.0" << '\n';
    }
    else if (grade == "D-")
    {
        cout << "0.7" << '\n';
    }
    else
    {
        cout << "0.0" << '\n';
    }
    return 0;
}