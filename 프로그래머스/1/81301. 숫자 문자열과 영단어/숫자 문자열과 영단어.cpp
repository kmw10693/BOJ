#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;
vector<string> v = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

int solution(string s) {
    string t = "";
    string temp = "";
    
    for(int i=0; i<s.length(); i++) {
        if(s[i] >= '0' && s[i] <= '9') t += s[i];
        else temp += s[i];
        if(find(v.begin(), v.end(), temp) != v.end()) {
            t += to_string(find(v.begin(), v.end(), temp) - v.begin());
            temp = "";
        }
    }
    return stoi(t);
}