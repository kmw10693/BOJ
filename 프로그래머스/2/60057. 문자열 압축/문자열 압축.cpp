#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;
int answer = 10000;

int solution(string s) {
    if(s.length() == 1) return 1;
    for(int i=1; i<=s.length()/2; i++) {
        string tmp = "";
        string p = "";
        p = s.substr(0, i);
        int cnt = 1;
        for(int j=i; j<s.length(); j+=i) {
            if(p == s.substr(j, i)) cnt++;
            else {
                if(cnt > 1) tmp += to_string(cnt);
                tmp += p;
                p = s.substr(j,i);
                cnt = 1;
            }
        }
        if(cnt > 1) tmp += to_string(cnt);
        tmp += p;
        if(answer > tmp.size()) answer = tmp.size();
    }
    return answer;
}