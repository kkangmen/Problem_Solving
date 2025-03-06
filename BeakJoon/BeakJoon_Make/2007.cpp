#include <iostream>
#include <string>
#include <vector>
using namespace std;

int month[13];
int day_cnt[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
string day[8] = {"error", "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int x, y;
    cin >> x >> y;

    int ans = 1;
    for (int i = 1; i <= 12; i++)
    {
        for (int j = 1; j <= day_cnt[i]; j++)
        {
            if (i == x && j == y)
            {
                if (ans > 7)
                {
                    ans = 1;
                }
                cout << day[ans] << '\n';
                break;
            }
            if (ans > 7)
            {
                ans = 1;
            }
            ans++;
        }
    }
    return 0;
}