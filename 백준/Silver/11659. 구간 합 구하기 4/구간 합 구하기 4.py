import sys
data = sys.stdin.readline().strip()
n, m = map(int, data.split())
d = [0] * 100010

d[0] = 0
num = sys.stdin.readline().strip()
k = list(map(int, num.split()))
for i, value in enumerate(k, start=1):
    d[i] = d[i-1] + value

for i in range(m):
    input_num = sys.stdin.readline().strip()
    i, j = map(int, input_num.split())
    print(d[j] - d[i-1])