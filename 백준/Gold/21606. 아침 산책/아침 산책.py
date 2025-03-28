# 21606 아침 산책
import sys

V = int(sys.stdin.readline())

in_out_list = list(map(int, sys.stdin.readline().strip()))
tree = [[] for _ in range(V + 1)]

edges = [list(map(int, line.split())) for line in sys.stdin.read().splitlines()]

for e in edges:
    tree[e[0]].append(e[1])
    tree[e[1]].append(e[0])

is_visited = [False] * (V + 1)

COUNT = 0


def dfs(node_idx, is_start: bool):
    global COUNT
    if not is_start and in_out_list[node_idx - 1] == 1:
        COUNT += 1
        return
    cur_node = tree[node_idx]
    for next_node in cur_node:
        if not is_visited[next_node]:
            is_visited[next_node] = True
            dfs(next_node, False)


for i in range(V):
    is_visited = [False] * (V + 1)
    if in_out_list[i]:
        is_visited[i + 1] = True
        dfs(i + 1, True)

print(COUNT)
