# 1005 ACM Craft
import sys
from collections import deque

T = int(sys.stdin.readline())

for _ in range(T):
    N, K = map(int, sys.stdin.readline().split())
    cost = [0 for _ in range(N + 1)]
    indegree = [0 for _ in range(N + 1)]
    distance = [0 for _ in range(N + 1)]
    graph = [[] for _ in range(N + 1)]

    cost_list = list(map(int, sys.stdin.readline().split()))

    for i in range(1, N + 1):
        cost[i] = cost_list[i - 1]

    for _ in range(K):
        start, end = map(int, sys.stdin.readline().split())
        indegree[end] += 1
        graph[start].append(end)

    END = int(sys.stdin.readline())

    Q = deque()
    for i in range(1, N + 1):
        if indegree[i] == 0:  # 진입차수가 0인 노드 집어넣기
            Q.append(i)

    while Q:
        pop = Q.popleft()
        for next_node in graph[pop]:
            indegree[next_node] -= 1
            if cost[pop] + distance[pop] > distance[next_node]:
                distance[next_node] = cost[pop] + distance[pop]
            if not indegree[next_node]:
                Q.append(next_node)

    print(distance[END] + cost[END])
