import sys
import heapq

input = sys.stdin.readline
n = int(input())
arr = []

for _ in range(n):
    arr.append(list(map(int, input().split())))
arr.sort()

pq = list()
heapq.heappush(pq, arr[0][1])

for i in range(1, n):
    if arr[i][0] >= pq[0]:
        heapq.heappop(pq)
    heapq.heappush(pq, arr[i][1])
        
print(len(pq))