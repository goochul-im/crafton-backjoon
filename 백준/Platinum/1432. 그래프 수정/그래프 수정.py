# 1422 그래프 수정
import sys
import heapq

N = int(sys.stdin.readline())

out_degree = [0 for _ in range(N + 1)]
graph = [[] for _ in range(N + 1)]
result = [0 for _ in range(N + 1)]

for i in range(N):
    temp = list(map(int, sys.stdin.readline().strip()))
    for j in range(N):
        if temp[j] == 1:
            out_degree[i + 1] += 1
            graph[j + 1].append(i + 1)


def topology_sort():
    heap = []

    for k in range(1, N + 1):
        if not out_degree[k]:
            heapq.heappush(heap, -k)

    n = N
    while heap:
        pop = -heapq.heappop(heap)
        result[pop] = n
        n -= 1

        for in_node in graph[pop]:
            out_degree[in_node] -= 1
            if out_degree[in_node] == 0:
                heapq.heappush(heap, -in_node)


topology_sort()
if result.count(0) >= 2:
    print(-1)
else:
    print(*result[1:])
