# 11725 트리의 부모 찾기
import sys

sys.setrecursionlimit(300000)
N = int(sys.stdin.readline())

prob = [[] for _ in range(N + 1)]
is_visited = [False] * (N + 1)

for _ in range(N - 1):
    start, end = map(int, sys.stdin.readline().split())
    prob[start].append(end)
    prob[end].append(start)

parent = [0 for _ in range(N + 1)]


def dfs(node):
    if not prob[node]:
        return

    for n in prob[node]:
        if not is_visited[n]:
            is_visited[n] = True
            parent[n] = node
            dfs(n)


dfs(1)
for i in range(2,len(parent)):
    print(parent[i])
