#include <bits/stdc++.h>

int arr[130][130];
int white = 0;
int blue = 0;

using namespace std; 

bool test(int x, int y, int N)
{
    for(int i=x; i<x+N; i++)
    {
        for(int j=y; j<y+N; j++)
        {
            if(arr[x][y] != arr[i][j])
                return false;
        }
    }
    return true;
}

void check(int x, int y, int N)
{
    if(test(x,y,N) == true) // test condition
    {
        if(arr[x][y] == 1)
            blue++;
        else if(arr[x][y] == 0)
            white++;

        return;
    }
    for(int i=x; i<x+N; i+=N/2)
    {
        for(int j=y; j<y+N; j+=N/2)
        {
            check(i,j,N/2);
        }
    }
}

int main()
{

    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int N;
    cin >> N;
    
    for(int i=0; i<N; i++)
        for(int j=0; j<N; j++)
            cin >> arr[i][j];
            
    check(0, 0, N);
    cout << white << "\n" << blue;
}
