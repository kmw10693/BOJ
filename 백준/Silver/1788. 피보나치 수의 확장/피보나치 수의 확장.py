import sys
input = sys.stdin.readline

n = int(input())

dp = [0] * 2000005

dp[1000000] = 0
dp[1000001] = 1

dp[999999] = 1

if n > 0:
    print(1)
    for i in range(1000002, 1000002 + n+1):
        dp[i] = (dp[i-1] + dp[i-2]) % 1000000000
    print(dp[1000000 + n])
elif n == 0:
    print(0)
    print(0)
else:
    for i in range(1000001, 1000000 + n -1 , -1):
        if dp[i] - dp[i-1] >= 0:
            dp[i-2] = (dp[i] - dp[i-1]) % 1000000000
        else:
            dp[i-2] = (dp[i] - dp[i-1]) % -1000000000
    if dp[1000000 + n] > 0:
        print(1)
        
    else:
        print(-1)
    print(abs(dp[1000000 + n]))