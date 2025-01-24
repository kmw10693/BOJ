#include <string>
#include <vector>

using namespace std;

int solution(string name) {
    int n = name.size();
    int tmp = name.size()-1;
    
    int answer = 0;
    for(int i=0; i<name.size(); i++) {
        if(name[i] - 'A' < 14) answer += name[i] - 'A';
        else answer += ('Z' - name[i] +1);
        
        int t = i+1;
        while(t < n && name[t] == 'A') t++;
        tmp = min(tmp, i + n-t + min(i, n-t));
    }
    answer += tmp;
    return answer;
}