#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;
map<string, int> mm;

bool solution(vector<string> phone_book) {
    for(int i=0; i<phone_book.size(); i++) {
        mm[phone_book[i]] = 1;
    }
    
    for(int i=0; i<phone_book.size(); i++) {
        for(int j=0; j<phone_book[i].length(); j++) {
            string sub = phone_book[i].substr(0, j);
            if(mm[sub]) return false;
        }
    }
    return true;
}