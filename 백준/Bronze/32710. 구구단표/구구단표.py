
arr = []

for i in range(2, 10):
    for j in range(1, 10):
        arr.append(i)
        arr.append(j)
        arr.append(i*j)

arr = list(set(arr))

n = int(input())

if n in arr:
    print(1)
else:
    print(0)