#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

string lower = "abcdefghijklmnopqrstuvwxyz";
string high = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

string solution(string s, int n) {
    string answer = "";
    for(int i=0; i<s.size(); i++) {
        if(s[i] == ' ') {
            answer+= ' ';
            continue;
        }
        if(lower.find(s[i]) != string::npos) {
            int t = lower.find(s[i]);
            answer += lower[(t + n)%26];
        }
        else if(high.find(s[i]) != string::npos) {
            int t= high.find(s[i]);
            answer += high[(t+n)%26];
        }
    }
    return answer;
}