#include <string>
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

bool solution(string s)
{
    int p = 0;
    int sk = 0;
    for(int i=0; i<s.length(); i++) {
        if(s[i] == 'P' || s[i] == 'p') p++;
        if(s[i] == 'y' || s[i] == 'Y') sk++;
    }

    return p == sk;
}