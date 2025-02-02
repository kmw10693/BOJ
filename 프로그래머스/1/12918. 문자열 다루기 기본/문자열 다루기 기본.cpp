#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

bool solution(string s) {
    bool check = true;
    if(s.length() != 4 && s.length() != 6) check = false;
    for(int i=0; i<s.length(); i++) {
        if(s[i] >= '0' && s[i] <= '9') continue;
        check = false;
    }
    return check;
}