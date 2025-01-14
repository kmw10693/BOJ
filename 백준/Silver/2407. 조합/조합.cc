#include <bits/stdc++.h>

using namespace std;

string factorial[101][101];

string bigsum(string s1, string s2) {
    
    int sum = 0;
    string result;
    
    while(!s1.empty() || !s2.empty() || sum) {
        if(!s1.empty()) {
            sum += s1.back() - '0';
            s1.pop_back();
        }
        if(!s2.empty()) {
            sum += s2.back() - '0';
            s2.pop_back();
        }
        result.push_back((sum % 10) + '0');
        sum /= 10;
    }
    reverse(result.begin(), result.end());
    return result;
}

string combination(int n, int r){
    if(r == 0 || n == r) {
        return "1";
    }
    string &result = factorial[n][r];
    
    if(result != "") return result;
    
    result = bigsum(combination(n-1, r), combination(n-1, r-1));
    return result;
}


int main() {
    cin.tie(0);
    cout.tie(0);
    ios::sync_with_stdio(0);
    
    
    int n, m;
    cin >> n >> m;
    cout << combination(n, m);
    
}