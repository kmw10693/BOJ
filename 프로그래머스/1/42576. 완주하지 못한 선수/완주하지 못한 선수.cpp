#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

unordered_map<string, int> m;

string solution(vector<string> participant, vector<string> completion) {
    for(auto p : participant) m[p]++;
    for(auto c : completion) m[c]--;
    
    string answer = "";
    for(auto iter=m.begin(); iter!=m.end(); iter++) {
        if (iter->second > 0) answer += iter->first;
    }
    return answer;
}