n = int(input())
l = list(map(int, input().split()))
d = [0] * n

for i in range(n):
    d[i] = l[i]
    for j in range(i+1):
        if l[i] > l[j]:
            d[i] = max(d[j]+l[i], d[i])

print(max(d))