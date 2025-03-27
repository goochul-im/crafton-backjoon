# DFS와 BFS
import sys
from collections import deque

N, M, V = map(int, sys.stdin.readline().split())

tree = [[] for _ in range(N + 1)]

for i in range(M):
    temp = list(map(int, sys.stdin.readline().split()))
    temp.sort()
    tree[temp[0]].append(temp[1])
    tree[temp[1]].append(temp[0])

for t in tree:
    t.sort()
is_visited = [False] * (N + 1)

ans = []


def dfs(vertex):
    ans.append(vertex)
    if not tree[vertex]:
        return
    for v in tree[vertex]:
        if not is_visited[v]:
            is_visited[v] = True
            dfs(v)


def bfs(vertex):
    Q = deque()
    Q.append(vertex)
    while Q:
        length = len(Q)
        for _ in range(length):
            pop = Q.popleft()
            ans.append(pop)
            for v in tree[pop]:
                if not is_visited[v]:
                    is_visited[v] = True
                    Q.append(v)


is_visited[V] = True
dfs(V)
print(*ans)
ans = []
is_visited = [False] * (N + 1)
is_visited[V] = True
bfs(V)
print(*ans)
