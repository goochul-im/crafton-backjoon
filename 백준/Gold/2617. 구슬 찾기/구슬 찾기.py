import sys
sys.setrecursionlimit(300000)

N, M = map(int, sys.stdin.readline().split())

# 무거운 → 가벼운
prob_light = [[] for _ in range(N + 1)]
# 가벼운 → 무거운 (역방향)
prob_heavy = [[] for _ in range(N + 1)]

for _ in range(M):
    heavy, light = map(int, sys.stdin.readline().split())
    prob_light[heavy].append(light)
    prob_heavy[light].append(heavy)

def dfs_light(node, visited):
    count = 0
    for next_node in prob_light[node]:
        if not visited[next_node]:
            visited[next_node] = True
            count += 1 + dfs_light(next_node, visited)
    return count

def dfs_heavy(node, visited):
    count = 0
    for next_node in prob_heavy[node]:
        if not visited[next_node]:
            visited[next_node] = True
            count += 1 + dfs_heavy(next_node, visited)
    return count

middle = (N // 2) + 1
result = 0

for i in range(1, N + 1):
    visited_light = [False] * (N + 1)
    visited_light[i] = True
    if dfs_light(i, visited_light) >= middle:
        result += 1
        continue

    visited_heavy = [False] * (N + 1)
    visited_heavy[i] = True
    if dfs_heavy(i, visited_heavy) >= middle:
        result += 1

print(result)
