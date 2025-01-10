#include <bits/stdc++.h>

using namespace std;

int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,1,0,-1 };

#define X first
#define Y second

int arr[1005][1005];
int check[1005][1005][2];

int main(void)
{
	int n, m;
	string a[1005];


	cin >> n >> m;
	for (int i = 0; i < n; i++)
	{
		cin >> a[i];
	}
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			arr[i][j] = a[i][j] - '0';
		}
	}

	queue <pair<pair<int, int>, int>> q;
	q.push({ {0,0},1 });
	check[0][0][1] = 1;

	int block = 1;
	while (!q.empty())
	{
		auto t = q.front(); q.pop();
		for (int i = 0; i < 4; i++)
		{
			int x = t.X.X + dx[i];
			int y = t.X.Y + dy[i];
			block = t.Y;

			if (!(x < 0 || x >= n || y < 0 || y >= m))
			{
				if (arr[x][y] > 0 && block > 0)
				{
					check[x][y][block - 1] = check[t.X.X][t.X.Y][block] + 1;
					q.push({ {x,y},block - 1 });
				}
				else if (arr[x][y] == 0 && check[x][y][block] == 0)
				{
					check[x][y][block] = check[t.X.X][t.X.Y][block] + 1;
					q.push({ {x,y},block });
				}
			}
		}

	}
    if(n > 1 && m > 1 && check[n-1][m-1][block] == 0)
        cout << -1;
    else
        cout << check[n-1][m-1][block];

}