#include <iostream>
#include <string>
#include <vector>
using namespace std;
#define MAX 1e9;
int n;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    int title = 666;
    string s_title;
    int cnt = 0;
    for (int i = title;; i++)
    {
        s_title = to_string(i);
        if (s_title.find("666") != string::npos)
        {
            cnt++;
            if (n == cnt)
            {
                cout << s_title << '\n';
                break;
            }
        }
    }
    return 0;
}
