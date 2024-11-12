n = int(input())

data = list(map(int, input().split()))

tmp = data[0]
for i in range(1,n):
    data[i] = max(data[i], data[i-1] + data[i])

print(max(data))