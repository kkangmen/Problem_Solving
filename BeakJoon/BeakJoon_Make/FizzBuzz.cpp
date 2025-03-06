#include <iostream>
#include <string>
#include <vector>
using namespace std;

int ans = 0;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s;
    for (int i = 0; i < 3; i++)
    {
        cin >> s;

        if ('0' <= s[0] && s[0] <= '9')
        {
            if (i == 0)
            {
                ans = stoi(s) + 3;
            }
            else if (i == 1)
            {
                ans = stoi(s) + 2;
            }
            else
            {
                ans = stoi(s) + 1;
            }
        }
    }

    if (ans % 3 == 0 && ans % 5 == 0)
    {
        cout << "FizzBuzz" << '\n';
    }
    else if (ans % 3 == 0)
    {
        cout << "Fizz" << '\n';
    }
    else if (ans % 5 == 0)
    {
        cout << "Buzz" << '\n';
    }
    else
    {
        cout << ans << '\n';
    }
    return 0;
}