#include <iostream>
#include <string>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int xidx = -1;
	string s; cin >> s;
	int slen = s.length();
	for (int i = 0; i < slen; i++) {
		if (s[i] == 'x') xidx = i;
	}
	if (xidx < 0) cout << 0;
	else {
		if (xidx == 0) cout << 1;
		else if (s[xidx - 1] == '+') cout << 1;
		else if (s[xidx - 1] == '-') cout << -1;
		else cout << stoi(s.substr(0, xidx));
	}
}