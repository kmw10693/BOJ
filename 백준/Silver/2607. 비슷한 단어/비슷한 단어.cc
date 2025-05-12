#include <bits/stdc++.h>
using namespace std;

int n;
int alpha[27];
int ans;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n;
    string first; cin >> first;
    // 초기화
    for(int i=0; i<first.size(); i++) {
        alpha[first[i]-'A']++;
    }

    for(int i=1; i<n; i++) {
        // 첫번째 string에 알파벳 추가
        string s; cin >> s;
        
        // 초기화 작업
        int tmp[27] = {0};
        for(int j=0; j<27; j++) {
            tmp[j] = alpha[j];
        }
        
        // 각자 얼마나 같은지 판별함
        int alike = 0;
        for(int j=0; j<s.size(); j++) {
            if(tmp[s[j]-'A'] > 0) {
                alike++;
                tmp[s[j]-'A']--;
            }
        }
        
        // 길이가 같은 경우 -> 철자 하나만 다르거나, 같아야 함
        if(s.size() == first.size()) {
            if(alike == s.size() -1 || alike == s.size()) {
                ans++;
            }
        }
        
        // 길이가 하나 큰 경우 -> 다 같아야됨
        else if(s.size() == first.size() + 1) {
            if(alike == first.size()) ans++;
        }
        
        // 길이가 하나 작은 경우 -> 모두 같아야 함
        else if(s.size() + 1 == first.size()) {
            if(alike == first.size()-1) ans++;
        }
    }
    cout << ans;
    
}