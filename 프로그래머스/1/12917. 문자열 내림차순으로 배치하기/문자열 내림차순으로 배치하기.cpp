#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

bool compare(char c1, char c2) {
    return c1 > c2;
}

string solution(string s) {
    sort(s.begin(), s.end(), compare);
    return s;
}