#include <bits/stdc++.h>
using namespace std;

string a1 = "................";
string a2 = "****............";
string a3 = "********........";
string a4 = "************....";
string a5 = "****************";

int ans1, ans2, ans3, ans4, ans5;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int m, n;
    cin >> m >> n;
    int x = 5 * m + 1;
    int y = 5 * n + 1;

    string ans[500000];
    cin.ignore(); // 버퍼 비우기

    for (int i = 0; i < x; i++) {
        getline(cin, ans[i]);
    }

    // 디버깅용 출력
    /*
    for (int i = 0; i < x; i++) {
        for (int j = 0; j < y; j++) {
            cout << ans[i][j];
        }
        cout << '\n';
    }
    */

    for (int i = 0; i < x - 4; i += 5) {        // 블록은 5x5 단위, 상단 좌표만 보면 됨
        for (int j = 0; j < y - 4; j += 5) {
            string tmp = "";
            for (int t = i + 1; t < i + 5; t++) {    // i+1 ~ i+4 (4줄)
                for (int p = j + 1; p < j + 5; p++) { // j+1 ~ j+4 (4칸)
                    tmp += ans[t][p];
                }
            }

            if (tmp == a1) ans1++;
            else if (tmp == a2) ans2++;
            else if (tmp == a3) ans3++;
            else if (tmp == a4) ans4++;
            else if (tmp == a5) ans5++;
        }
    }

    cout << ans1 << ' ' << ans2 << ' ' << ans3 << ' ' << ans4 << ' ' << ans5 << '\n';
}
