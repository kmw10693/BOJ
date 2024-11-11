n = int(input())
r = []
g = []
b = []

for i in range(n):
    ri, gi, bi = map(int, input().split())
    r.append(ri); g.append(gi); b.append(bi)
  
arr = [[0]*1001 for _ in range(1001)]
arr[1][1] = r[0]
arr[1][2] = g[0]
arr[1][3] = b[0]

for i in range(2, n+1):
    arr[i][1] = min(arr[i-1][2], arr[i-1][3]) + r[i-1]
    arr[i][2] = min(arr[i-1][3], arr[i-1][1]) + g[i-1]
    arr[i][3] = min(arr[i-1][1], arr[i-1][2]) + b[i-1]
    
print(min(arr[n][1], arr[n][2], arr[n][3]))