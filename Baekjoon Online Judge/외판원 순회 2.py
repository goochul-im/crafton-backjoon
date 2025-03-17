# 외판원 순회2 - 완전탐색법
import sys

N = int(sys.stdin.readline())

W = []
Check = []
for i in range(N):
    W.append(list(map(int, sys.stdin.readline().split())))

INF = float('inf')
Count = INF


def tsp(vertex: int, depth, start, cur_count):
    global Count
    if depth == N:
        Count = min(Count, cur_count + (W[vertex][start] if W[vertex][start] != 0 else INF))
        return

    for k in range(N):
        if W[vertex][k] != 0 and Check[k] is False:
            Check[k] = True
            tsp(k, depth + 1, start, cur_count + W[vertex][k])
            Check[k] = False


for v in range(N):
    Check = [False] * 4
    Check[v] = True
    tsp(v, 1, v, 0)

print(Count)
