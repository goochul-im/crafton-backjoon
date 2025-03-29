# 1916 최소비용 구하기
import sys
import heapq

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
graph = [[] for _ in range(N + 1)]
for _ in range(M):
    node, dest, dist = map(int, sys.stdin.readline().split())
    graph[node].append((dest, dist))
START, END = map(int, sys.stdin.readline().split())

def dijkstra(start: int, bus_list: list):
    INF = int(1e9)
    distance = [INF] * (N + 1)

    heap = []

    heapq.heappush(heap, (start, 0))
    while heap:
        cur_idx, cur_dist = heapq.heappop(heap)

        if distance[cur_idx] < cur_dist:
            continue

        for next_idx, weight in bus_list[cur_idx]:
            cost = cur_dist + weight
            if cost < distance[next_idx]:
                distance[next_idx] = cost
                heapq.heappush(heap, (next_idx, cost))

    return distance


weight_list = dijkstra(START, graph)
print(weight_list[END])
