#include <bits/stdc++.h>
using namespace std;

map<string, long long> menu;
map<string, long long> special;
map<string, long long> service;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int a,b,c;
    
    cin >> a >> b >> c;
    for(int i=0; i<a; i++) {
        string name;
        int money;
        cin >> name >> money;
        menu[name] = money;
    }
    
    for(int i=0; i<b; i++) {
        string name;
        int money;
        cin >> name >> money;
        special[name] = money;
    }
    for(int i=0; i<c; i++) {
        string name;
        cin >> name;
        service[name]++;
    }
    
    int n;
    cin >> n;
    bool check = true;
    
    // 스페셜 가격
    long long special_price = 0;
    
    // 일반 가격
    long long menu_price = 0;
    
    vector<string> menu_customer;
    vector<string> special_customer;
    vector<string> service_customer;

    for(int i=0; i<n; i++) {
        string name;
        cin >> name;
        if(menu[name] > 0) menu_customer.push_back(name);
        if(special[name] > 0) special_customer.push_back(name);
        if(service[name] > 0) service_customer.push_back(name);
    }
    
    // 일반 메뉴 라면, 그냥 메뉴 값 증가
    for(int i=0; i<menu_customer.size(); i++) {
        menu_price += menu[menu_customer[i]];
    }
    
    for(int i=0; i<special_customer.size(); i++){
         if(menu_price < 20000) {

                check = false;
                break;
         }
         special_price += special[special_customer[i]];
    }
    
    if(service_customer.size() > 1) {
        check = false;
    }
    
    if(service_customer.size() == 1 && menu_price + special_price < 50000) {
        check = false;
    }

    if(check) {
        cout << "Okay";
    }
    else cout << "No";
    
}