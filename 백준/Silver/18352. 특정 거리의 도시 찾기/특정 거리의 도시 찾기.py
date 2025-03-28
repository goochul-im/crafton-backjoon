# 18352 특정 거리의 도시 찾기
import sys
from collections import deque

N, M, K, X = map(int, sys.stdin.readline().split())

prob = [[] for _ in range(N + 1)]
for _ in range(M):
    start, end = map(int, sys.stdin.readline().split())
    prob[start].append(end)
is_visited = [False] * (N+1)
ans = []


def bfs():
    is_visited[X] = True
    Q = deque()
    Q.append(X)
    count = -1
    while Q:
        length = len(Q)
        count += 1
        for _ in range(length):
            pop = Q.popleft()
            if count == K:
                ans.append(pop)
                continue
            for next_node in prob[pop]:
                if not is_visited[next_node]:
                    is_visited[next_node] = True
                    Q.append(next_node)


bfs()
if not ans:
    print(-1)
else:
    for a in sorted(ans):
        print(a)
