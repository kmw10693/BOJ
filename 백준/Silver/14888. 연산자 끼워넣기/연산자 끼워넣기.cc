#include <bits/stdc++.h>

using namespace std;

int n;

int arr[13];

vector <int> v;

int ans2(int a, int b, int t);

int ans(){

    int sum = 0;

    for(int i=0; i<v.size(); i++){

        if(i == 0) sum = ans2(arr[i], arr[i+1], v[i]);

        else sum = ans2(sum, arr[i+1], v[i]);

    }

    return sum;

}

int ans2(int a, int b, int t){

    if(t == 0) return a+b;

    else if(t == 1) return a-b;

    else if(t == 2) return a*b;

    return a/b;

}

int main() {

    ios::sync_with_stdio(0);

    cin.tie(0);

    

    cin >> n;

    for(int i=0; i<n; i++)

      cin >> arr[i];

      

      

    for(int i=0; i<4; i++){

        int t;

        cin >> t;

        for(int j=0; j<t; j++){

            v.push_back(i);

        }

    }

    sort(v.begin(), v.end());

    int maxt =-1999999999, mint = 1999999999;

    do{

        maxt = max(maxt, ans());

        mint = min(mint, ans());

    }while(next_permutation(v.begin(), v.end()));

    cout << maxt << '\n' << mint;

}