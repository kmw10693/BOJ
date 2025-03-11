#include <bits/stdc++.h>
using namespace std;

vector<string> ans;
string s;

void eraseChars() {
    cin >> s; 
    int pos = 0, nxt_pos = 0;
    while(1) {
        while(s[nxt_pos] >= 'a' && s[nxt_pos] <= 'z') nxt_pos++;
        pos = nxt_pos;
        if(pos >= s.length()) break;
        while(s[nxt_pos] >= '0' && s[nxt_pos] <= '9') nxt_pos++;
        ans.push_back(s.substr(pos, nxt_pos - pos));
        pos = nxt_pos;
    }
}

void eraseZeros() {
    for(string& s : ans) {
        int pos = 0;
        while(s[pos] == '0') pos++;
        string ss = s.substr(pos, s.length()-pos);
        if(ss == "") ss = "0";
        s = ss;
    }
}

bool cmp(string &a, string &b) {
    if(a.length() == b.length()) return a < b;
    return a.length() < b.length();
}
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n; cin >> n;
    while(n--) eraseChars();
    eraseZeros();
    
    sort(ans.begin(), ans.end(), cmp);
    for(string s : ans) cout << s << '\n';
}