import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    n = int(input())
    arr = list(map(int, input().split()))
    dp = [0] * 10005
    dp[0] = 1
    
    m = int(input())
    
    for i in range(n):
        for j in range(arr[i], m+1):
            dp[j] = dp[j] + dp[j-arr[i]]
    print(dp[m])


