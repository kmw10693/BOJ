#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    
    while(n--) {
        int t;
        cin >> t;
        string s = bitset<20>(t).to_string();
        
        int start = 0;
        vector<int> ans;
        for(int i=s.size()-1; i>=0; i--){
            if(s[i] == '1') ans.push_back(start); 
            start++;
        }
        
        for(int i=0; i<ans.size(); i++) {
            cout << ans[i] << ' ';
        }
    }
}