#include <bits/stdc++.h>

using namespace std;

string op = ""; // 연산자
string name[50000];// 변수명
string op2 = ""; //추가 연산자
string ans[50000]; //정답

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    string s;
    getline(cin, s);
    
    bool check = false;
    // 0번째 부터 이름 저장
    int start = 0;
    for(int i=0; i<s.size(); i++){
        // 연산자 분리
        if(s[i] != ' ' && !check) {
            op += s[i];
        }
        
        // 공백 만나면 연산자 분리 중지
        if(s[i] == ' '){
            check = true;
            
            // 공백 만나면 변수 명 저장
            int j = i+1;
            for(j; j<s.size(); j++) {
                if(s[j] == '[' || s[j] == ']' || s[j] == '*' || s[j] == '&' || s[j] == ',' || s[j] == ';') 
                    break;
                name[start]+= s[j];
            }
            // 추가 연산자 저장 j부터 시작
            for(j; j<s.size(); j++){
                if(s[j] == ',' || s[j] == ';') break;
                op2 += s[j];
            }
            
            // 거꾸로 정렬
            for(int p=op2.size()-1; p>=0; p--){
                // 만약 [] 라면 변경
                if(op2[p] == '[') {
                    ans[start] += ']';
                    continue;
                }
                if(op2[p] == ']') {
                    ans[start] += '[';
                    continue;
                }
                ans[start] += op2[p];
            }
            // 1증가 
            start++;
            //op2 초기화
            op2 = "";
        }
    }
    // 각각 출력
    for(int i=0; i<start; i++) {
        cout << op << ans[i] << ' ' << name[i] << ';' << '\n';
    }
    
}