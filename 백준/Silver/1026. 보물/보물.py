# 1026 보물
import sys, heapq

N = int(sys.stdin.readline())

A = list(map(int, sys.stdin.readline().split()))
heapq.heapify(A)
temp = list(map(int, sys.stdin.readline().split()))
B = []
for t in temp:
    heapq.heappush(B, -t)

result = 0
for _ in range(N):
    a = heapq.heappop(A)
    b = -heapq.heappop(B)
    result += (a * b)

print(result)
