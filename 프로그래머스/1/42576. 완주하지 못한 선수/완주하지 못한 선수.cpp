#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

map<string, int> m;

string solution(vector<string> participant, vector<string> completion) {
    string s = "";
    for(int i=0; i<participant.size(); i++) {
        m[participant[i]]++;
    }
    
    for(int i=0; i<completion.size(); i++){
        m[completion[i]]--;
    }
    
    for(auto iter = m.begin(); iter != m.end(); iter++) {
        if(iter->second > 0) s += iter->first;
    }
    return s;
}