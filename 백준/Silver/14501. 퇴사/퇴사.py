n = int(input())

tmp = []
for i in range(n):
    t, p = map(int, input().split())
    tmp.append((t,p))

ans = [0] *1005
for i in range(n):
    if i + tmp[i][0] <= n: ans[i] = tmp[i][1]

    for j in range(i+1):
        if i+1 >= j+1 + tmp[j][0] and i + tmp[i][0] <= n:
            ans[i] = max(ans[j] + tmp[i][1], ans[i])

print(max(ans))