# 1238 파티
import sys
import heapq

N, M, X = map(int, sys.stdin.readline().split())
reverse_graph = [[] for _ in range(N + 1)]
graph = [[] for _ in range(N + 1)]
INF = int(1e9)
reverse_distance = [INF for _ in range(N + 1)]
distance = [INF for _ in range(N + 1)]

for _ in range(M):
    END, START, WEIGHT = map(int, sys.stdin.readline().split())
    graph[END].append((WEIGHT, START))
    reverse_graph[START].append((WEIGHT, END))


def reverse_dijkstra():
    heap = []
    heapq.heappush(heap, (0, X))
    reverse_distance[X] = 0

    while heap:
        cur_weight, now = heapq.heappop(heap)

        for next_weight, next_node in reverse_graph[now]:
            cost = next_weight + cur_weight
            if reverse_distance[next_node] > cost:
                reverse_distance[next_node] = cost
                heapq.heappush(heap, (cost, next_node))


def dijkstra():
    heap = []
    heapq.heappush(heap, (0, X))
    distance[X] = 0

    while heap:
        cur_weight, now = heapq.heappop(heap)

        for next_weight, next_node in graph[now]:
            cost = next_weight + cur_weight
            if distance[next_node] > cost:
                distance[next_node] = cost
                heapq.heappush(heap, (cost, next_node))


reverse_dijkstra()
dijkstra()

result = 0
for i in range(1, N + 1):
    result = max(result, reverse_distance[i] + distance[i])

print(result)
