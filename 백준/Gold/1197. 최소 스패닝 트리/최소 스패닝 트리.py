# 1197 최소 스패닝 트리
import sys
import heapq

sys.setrecursionlimit(300000)
V, E = map(int, sys.stdin.readline().split())

edges = []
for _ in range(E):
    A, B, C = map(int, sys.stdin.readline().split())
    heapq.heappush(edges, [C, (A, B)])

parent = [i for i in range(V + 1)]


def find(x) -> int:
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]


def union(a, b):
    a_find = find(a)
    b_find = find(b)
    if a_find != b_find:
        parent[b_find] = a_find
        return True
    return False


result = 0
while edges:
    A, B = heapq.heappop(edges)
    if union(B[0], B[1]):
        result += A

print(result)
