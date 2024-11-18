import sys
input = sys.stdin.readline

n = int(input())
a = list(map(int, input().split()))
dp = [1] * 1005
dp[0] = 1

for i in range(n):
    for j in range(i):
        if a[j] < a[i]:
            dp[i] = max(dp[i], dp[j]+1)

ans = max(dp);
t = ans

arr = []

for i in range(n-1, -1, -1):
    if dp[i] == t:
        arr.append(a[i])
        t = t - 1
        
print(ans)
arr.sort()
for i in arr:
    print(i, end =' ')

    