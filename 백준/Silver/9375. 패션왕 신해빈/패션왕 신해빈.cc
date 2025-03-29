#include <bits/stdc++.h>

using namespace std;

map<string, int> s;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int cnt;
    cin >> cnt;
    while(cnt--){
        int n;
        cin >> n;
        while(n--) {
            string a, b;
            cin >> a >> b;
            s[b]++;
        }
        int ans = 1;
        for(auto iter=s.begin(); iter != s.end(); iter++) {
            ans *= ((iter->second) + 1);
        }
        cout << ans - 1 << '\n';
        s.clear();
    }
}