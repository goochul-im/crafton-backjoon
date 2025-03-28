# 2606 바이러스
import sys

V = int(sys.stdin.readline())
E = int(sys.stdin.readline())

prob = []
parent = [i for i in range(V + 1)]
for _ in range(E):
    A, B = map(int, sys.stdin.readline().split())
    prob.append([A, B])


def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]


def union(a, b):
    a_find = find(a)
    b_find = find(b)
    if a_find == b_find:
        return
    if a_find < b_find:
        parent[b_find] = a_find
    else:
        parent[a_find] = b_find


for p in prob:
    union(p[0], p[1])

for i in range(V + 1):
    find(i)  # 경로 압축

count = -1
for p in parent:
    if p == 1:
        count += 1

print(count)
