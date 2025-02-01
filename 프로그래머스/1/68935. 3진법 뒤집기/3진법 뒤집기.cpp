#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(int n) {
    string s = "";
    while(n > 0){
        s += to_string(n%3);
        n /= 3;
    }
    reverse(s.begin(), s.end());
    int answer = 0;
    int sum = 1;
    for(int i=0; i<s.length(); i++) {
        answer += (sum*(s[i] - '0'));
        sum *= 3;
    }
    return answer;
}