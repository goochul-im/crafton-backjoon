# 1240 노드의 거리
import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(N + 1)]

for _ in range(N - 1):
    start, end, weight = map(int, sys.stdin.readline().split())
    graph[start].append((end, weight))
    graph[end].append((start, weight))

case = []

for _ in range(M):
    case.append(list(map(int, sys.stdin.readline().split())))

is_visited = [False] * (N + 1)


def bfs(start_node: int, end_node: int):
    Q = deque()
    Q.append((start_node, 0))
    is_visited[start_node] = True

    while Q:
        cur_node, cur_weight = Q.popleft()

        if cur_node == end_node:
            return cur_weight

        for next_node, next_weight in graph[cur_node]:
            if is_visited[next_node]:
                continue
            is_visited[next_node] = True
            Q.append((next_node, next_weight + cur_weight))


for st, ed in case:
    is_visited = [False] * (N + 1)
    is_visited[st] = True
    print(bfs(st, ed))
