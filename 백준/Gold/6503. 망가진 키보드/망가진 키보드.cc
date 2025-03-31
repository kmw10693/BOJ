#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    while(true) {
        int n;
        cin >> n;
        cin.ignore();
        if(n == 0) break;
        
        string s;
        getline(cin, s);
        
        int left = 0, right = -1, cnt = 0, len = 0;
        unordered_map<char, int> m;
        int ans = -1;
        len = s.length();
        
        while(right < len-1) {
            if(cnt < n || (cnt == n && m[s[right+1]] > 0)) {
                right++;
                m[s[right]]++;
                if(m[s[right]] == 1) cnt++;
            }
            else {
                m[s[left]]--;
                if(m[s[left]] == 0) cnt--;
                left++;
            }
            ans = max(ans, right-left +1);
        }
        cout << ans << '\n';
    
    }
}