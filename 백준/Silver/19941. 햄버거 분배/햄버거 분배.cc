#include <bits/stdc++.h>
using namespace std;

int n,k;
int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    cin >> n >> k;
    string s; cin >> s;
    
    int cnt = 0;
    for(int i=0; i<=s.size(); i++) {
        // 사람이 아니면 패스
        if(s[i] != 'P') continue;
        
        // 범위 체크\
            // k 범위의 왼쪽부터 햄버거 먹기
        for(int j=i-k; j<=i+k; j++) {
            if(j < 0 || j > n) continue;
            if(s[j] == 'H') {
                s[j] = '-';
                cnt++;
                break;
            }
        }
    }
    cout << cnt;
}