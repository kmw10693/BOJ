import sys
input = sys.stdin.readline

cnt = 0
while(True):
    n = int(input())
    if n == 0:
        break
    cnt += 1
    arr = []
    dp = [[0]*3 for _ in range(n)]
    
    for i in range(n):
        arr.append(list(map(int,input().split())))
    
    dp[0][0] = arr[0][0]
    dp[0][1] = arr[0][1]
    dp[0][2] = arr[0][1] + arr[0][2]
    
    for i in range(1, n):
        for j in range(3):
            if j == 0:
                if i == 1:
                    dp[i][j] = dp[i-1][j+1] + arr[i][j]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i-1][j+1]) + arr[i][j]
            elif j == 1:
                if i == 1:
                    dp[i][j] = min(dp[i-1][j], dp[i-1][j+1], dp[i][j-1]) + arr[i][j]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i-1][j-1], dp[i-1][j+1], dp[i][j-1]) + arr[i][j]
            elif j == 2:
                if i == 1:
                    dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + arr[i][j]
                else:
                    dp[i][j] = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) + arr[i][j]
    
    print(str(cnt)+'.', dp[n-1][1])