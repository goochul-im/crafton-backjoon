# 2637 장난감 조립
import sys
from collections import deque

M = int(sys.stdin.readline())
N = int(sys.stdin.readline())

graph = [[] for _ in range(M + 1)]
indegree = [0 for _ in range(M + 1)]
sub_parts = [[0] * (M + 1) for _ in range(M + 1)]

for _ in range(N):
    start, end, cost = map(int, sys.stdin.readline().split())
    graph[end].append((start, cost))
    indegree[start] += 1

basic_parts = []

def topology_sort():
    Q = deque()
    for i in range(1, M + 1):
        if indegree[i] == 0:
            Q.append(i)
            basic_parts.append(i)
            sub_parts[i][i] = 1

    while Q:
        pop = Q.popleft()
        for next_parts, need_cost in graph[pop]:
            indegree[next_parts] -= 1
            for i in range(M + 1):
                sub_parts[next_parts][i] += sub_parts[pop][i] * need_cost
            if indegree[next_parts] == 0:
                Q.append(next_parts)


topology_sort()
for parts in basic_parts:
    print(f"{parts} {sub_parts[M][parts]}")
