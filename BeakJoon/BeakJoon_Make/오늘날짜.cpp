#include <iostream>
#include <string>
#include <vector>
#include <ctime>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    time_t timer;
    timer = time(NULL);
    struct tm *t;
    t = localtime(&timer);
    cout << t->tm_year + 1900 << '-';
    int month = t->tm_mon + 1;
    if (month < 10)
    {
        cout << '0' << month << '-';
    }
    else
    {
        cout << month << '-';
    }
    int day = t->tm_mday;
    if (day < 10)
    {
        cout << '0' << day << '\n';
    }
    else
    {
        cout << day << '\n';
    }

    return 0;
}