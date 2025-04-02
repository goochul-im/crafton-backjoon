# 11779 최소비용 구하기
import sys
import heapq

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())

graph = [[] for _ in range(N + 1)]
for _ in range(M):
    start, end, weight = map(int, sys.stdin.readline().split())
    graph[start].append((weight, end))

START, END = map(int, sys.stdin.readline().split())
prev_node = [[] for _ in range(N + 1)]
INF = N * 100000 + 1
distance = [INF] * (N + 1)


def dijkstra(start_node):
    heap = []
    heapq.heappush(heap, (0, start_node))
    distance[start_node] = 0

    while heap:
        cur_weight, cur_node = heapq.heappop(heap)

        if cur_weight > distance[cur_node]:
            continue

        for next_weight, next_node in graph[cur_node]:
            cost = cur_weight + next_weight
            if distance[next_node] > cost:
                distance[next_node] = cost
                prev_node[next_node] = [cur_node]
                heapq.heappush(heap, (cost, next_node))


dijkstra(START)
ans_root = []


def dfs(end_node):
    ans_root.append(end_node)
    for next_node in prev_node[end_node]:
        dfs(next_node)


dfs(END)
print(distance[END])
print(len(ans_root))
print(*reversed(ans_root))
