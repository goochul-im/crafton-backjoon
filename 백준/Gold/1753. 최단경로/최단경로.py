# 1753 최단경로
import sys
import heapq

V, E = map(int, sys.stdin.readline().split())
START = int(sys.stdin.readline())
graph = [[] for _ in range(V + 1)]
INF = int(1e9)
distance = [INF for _ in range(V + 1)]

for _ in range(E):
    start, end, weight = map(int, sys.stdin.readline().split())
    graph[start].append((weight, end))


def dijkstra():
    heap = []
    distance[START] = 0
    heapq.heappush(heap, (0, START))

    while heap:
        cur_weight, cur_node = heapq.heappop(heap)

        if distance[cur_node] < cur_weight:
            continue

        for next_weight, next_node in graph[cur_node]:
            cost = next_weight + cur_weight
            if cost < distance[next_node]:
                distance[next_node] = cost
                heapq.heappush(heap, (cost, next_node))


dijkstra()
for i in range(1, V + 1):
    if distance[i] == INF:
        print('INF')
    else:
        print(distance[i])
