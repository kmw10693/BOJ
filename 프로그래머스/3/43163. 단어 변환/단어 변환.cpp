#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int answer= 0x7fffffff;
string targetAns;

map<string, bool> m;

bool stringEqual(string a, string b) {
    int tmp = 0;
    for(int i=0; i<a.length(); i++) {
        if(a[i] != b[i]) tmp++;
    }
    if(tmp >= 2) return false;
    return true;
}

void backtrack(string s, vector<string> words, int tmp) { // hit
    
    if(s == targetAns) {
        answer = min(answer, tmp);
        return;
    }
    
    if(tmp > words.size()) return;
    
    for(auto w: words) {
        if(stringEqual(s, w) == true && m[w] == false) {
            m[w] = true;
            backtrack(w, words, tmp+1);
            m[w] = false;
        }
    }
}

int solution(string begin, string target, vector<string> words) {
    targetAns = target;
    for(auto w : words) {
        m[w] = false;
    }
    backtrack(begin, words, 0);
    if(answer == 0x7fffffff) return 0;
    return answer;
}