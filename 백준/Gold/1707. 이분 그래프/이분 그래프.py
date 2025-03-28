# 1707 이분 그래프
import sys

sys.setrecursionlimit(300000)
case = int(sys.stdin.readline())

prob = []


def dfs(node, color: bool):
    prob[node][1] = color
    for next_node in prob[node][0]:
        if prob[next_node][1] is None:
            if not dfs(next_node, not color):
                return False
        elif prob[next_node][1] == color:
            return False
    return True


for _ in range(case):
    message = "YES"
    V, E = map(int, sys.stdin.readline().split())
    prob = [[[], None] for _ in range(V + 1)]
    for i in range(E):
        start, end = map(int, sys.stdin.readline().split())
        prob[start][0].append(end)
        prob[end][0].append(start)
    for i in range(1, V + 1):
        color = True
        if not prob[i][1]:
            color = False
        if not dfs(i, color):
            message = "NO"
            break
    print(message)
