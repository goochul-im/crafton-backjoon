# 2252 줄 세우기
import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(N + 1)]
indegree = [0 for _ in range(N + 1)]
ans = []

for _ in range(M):
    start, end = map(int, sys.stdin.readline().split())
    graph[start].append(end)
    indegree[end] += 1


def topology_sort():
    Q = deque()
    for i in range(1, N + 1):
        if indegree[i] == 0:
            Q.append(i)

    while Q:
        pop = Q.popleft()
        ans.append(pop)
        for next_node in graph[pop]:
            indegree[next_node] -= 1
            if indegree[next_node] == 0:
                Q.append(next_node)


topology_sort()
print(*ans)
