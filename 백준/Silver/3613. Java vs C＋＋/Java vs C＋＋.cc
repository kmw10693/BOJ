#include <bits/stdc++.h>
using namespace std;

string s;

int getcode() {
  if(s[0] == '_' || s[s.size() - 1] == '_') return 0;
  if(isupper(s[0])) return 0;
  bool is_ub = 0, is_upper = 0;
  for (int i = 1; i < s.size(); i++) {
    if(s[i] == '_') {
      if(s[i - 1] == '_') return 0;
      is_ub = 1;
    }
    if(isupper(s[i])) is_upper = 1;
  }
  if(is_ub && is_upper) return 0;
  else if(is_ub) return 1;
  return 2;
}

void ctoj() {
  bool is_nxt_upper = 0;
  for(char c : s) {
    if(c == '_') { is_nxt_upper = 1; continue; }
    if(is_nxt_upper) cout << (char)toupper(c);
    else cout << c;
    is_nxt_upper = 0;
  }
}

void jtoc () {
  for(char c : s) {
    if(isupper(c)) { cout << '_'; }
    cout << (char)tolower(c);
  }
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> s;
  int code = getcode(); // code = 0: none, 1: cpp, 2: java
  if(!code) cout << "Error!";
  else if(code == 1) ctoj();
  else jtoc();
}