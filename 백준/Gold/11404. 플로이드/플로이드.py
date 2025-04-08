# 11404 플로이드
import sys

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())

INF = int(1e9)
graph = [[INF] * (N + 1) for _ in range(N + 1)]
for i in range(1, N+1):
    graph[i][i] = 0

for _ in range(M):
    start, end, weight = map(int, sys.stdin.readline().split())
    graph[start][end] = min(graph[start][end], weight)

for k in range(1, N + 1):
    for i in range(1, N + 1):
        for j in range(1, N + 1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])


for i in range(1, N + 1):
    row = [0 if x == INF else x for x in graph[i]]
    print(*row[1:])
