#include <bits/stdc++.h>
using namespace std;

string sep = "*", p, f;
vector<string> ss;

vector<string> split(string& s, string& sep) {
  vector<string> ret;
  int pos = 0;
  while(pos < s.size()) {
    int nxt_pos = s.find(sep, pos);
    if(nxt_pos == -1) nxt_pos = s.size();
    if(nxt_pos - pos > 0)
      ret.push_back(s.substr(pos, nxt_pos - pos));
    pos = nxt_pos + sep.size();
  }
  return ret;
}

bool solve() {
  cin >> f;
  if(f.size() < ss[0].size() + ss[1].size()) return 0;
  if(f.find(ss[0]) != 0) return 0;
  int j = f.size() - ss[1].size();
  for (int i = 0; i < ss[1].size(); i++)
    if(ss[1][i] != f[j++]) return 0;
  return 1;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int t; cin >> t;

  cin >> p;
  ss = split(p, sep);

  while(t--) {
    if(solve()) cout << "DA\n";
    else cout << "NE\n";
  }
}