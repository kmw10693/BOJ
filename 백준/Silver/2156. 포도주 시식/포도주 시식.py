import sys
input = sys.stdin.readline

n = int(input())
arr = [0] * 10005
dp = [0] * 10005

for i in range(n):
    arr[i+1] = int(input())
    
dp[1] = arr[1]
dp[2] = arr[1] + arr[2]
dp[3] = max(arr[1] + arr[3], dp[2], arr[2] + arr[3])

for i in range(3, 10001):
    dp[i] = max(dp[i-1], dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i])

print(dp[n])