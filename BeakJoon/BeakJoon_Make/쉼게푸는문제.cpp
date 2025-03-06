#include <iostream>
#include <string>
#include <vector>
using namespace std;

int a, b;
int cnt = 0;
int sum = 0;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> a >> b;

    for (int i = 1; i <= 1000; i++)
    {
        for (int j = 1; j <= i; j++)
        {
            cnt++;
            if (a <= cnt && cnt <= b)
            {
                sum += i;
            }
        }
    }

    cout << sum << '\n';
    return 0;
}