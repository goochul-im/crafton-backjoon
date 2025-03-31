# 1766 문제집
import sys
from collections import deque
import heapq

N, M = map(int, sys.stdin.readline().split())

indegree = [0 for _ in range(N + 1)]
graph = [[] for _ in range(N + 1)]

for _ in range(M):
    start, end = map(int, sys.stdin.readline().split())
    graph[start].append(end)
    indegree[end] += 1


def topology_sort():
    heap = []
    ans = []
    for i in range(1, N + 1):
        if not indegree[i]:
            heapq.heappush(heap, i)

    while heap:
        pop = heapq.heappop(heap)
        ans.append(pop)
        for next_node in graph[pop]:
            indegree[next_node] -= 1
            if not indegree[next_node]:
                heapq.heappush(heap, next_node)

    print(*ans)


topology_sort()
