n = int(input())
l = list(map(int, input().split()))
d = [0] * n

for i in range(n):
    d[i] = 1
    for j in range(i+1):
        if l[i] > l[j]:
            d[i] = max(d[j]+1, d[i])

print(max(d))