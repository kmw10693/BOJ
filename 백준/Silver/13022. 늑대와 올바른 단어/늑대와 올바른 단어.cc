#include <bits/stdc++.h>
using namespace std;

string s;
int wCnt, oCnt, lCnt, fCnt;
bool ans = true;

string make(int cnt) {
    string s = "";
    for(int i=0; i<cnt; i++) {
        s += "w";
    }
    for(int i=0; i<cnt; i++) {
        s += "o";
    }
    for(int i=0; i<cnt; i++){
        s += "l";
    }
    for(int i=0; i<cnt; i++) {
        s += "f";
    }
    return s;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> s;
    for(auto &S : s) {
        if(S == 'w') wCnt++;
        if(S == 'o') oCnt++;
        if(S == 'l') lCnt++;
        if(S == 'f') fCnt++;
    }    
    
    // 만약 숫자 개수가 같지 않으면 false
    if(wCnt != oCnt || wCnt != lCnt || wCnt != fCnt || oCnt != lCnt || oCnt != fCnt || lCnt != fCnt) ans = false;
    
    // 만약 순서대로 만든 문자열과 같다면 종료
    if(s == make(wCnt)) {
        ans = true;
        cout << "1";
        return 0;
    }
    
    // wCnt 3 -> 2 -> 1
    while(wCnt) {
        // 만약 찾았다면 찾은 문자열을 *로 표시
        while(s.find(make(wCnt)) != string::npos) {
            string tmp = make(wCnt);
            int length = tmp.size();
            s.replace(s.find(make(wCnt)), length,"*");
        }
        wCnt--;
    }
    for(auto &S : s) {
        if(S != '*') ans = false;
    }
    
    if(!ans) {
        cout << 0;
    }
    else cout << 1;
    

}