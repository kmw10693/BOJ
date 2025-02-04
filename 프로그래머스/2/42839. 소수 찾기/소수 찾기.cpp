#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int ans = 0;
map<int, int> m;

bool isCheck(int number) {
    if(number == 0 || number == 1) return false;
    if(number == 2) return true;
    
    for(int i=2; i<number; i++) {
        if(number % i == 0) {
            return false;
        }
    }
    return true;
}

int solution(string numbers) {
    sort(numbers.begin(), numbers.end());
    
    for(int i=1; i<=numbers.size(); i++) {
        do {
            string result = "";
            for(int j=0; j<i; j++) {
                result += numbers[j];
            }
            if(!m[stoi(result)] && isCheck(stoi(result)) == true) {
                cout << stoi(result) << '\n';
                ans++;
                m[stoi(result)]++;
            }
        } while(next_permutation(numbers.begin(), numbers.end()));
    }
    return ans;
}