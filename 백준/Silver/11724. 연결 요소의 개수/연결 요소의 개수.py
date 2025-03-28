# 11724 연결 요소의 개수
import sys

N, M = map(int, sys.stdin.readline().split())
prob = []

for _ in range(M):
    A, B = map(int, sys.stdin.readline().split())
    prob.append([A, B])

parent = [i for i in range(N + 1)]


def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]


def union(a, b):
    a_find = find(a)
    b_find = find(b)
    if a_find != b_find:
        parent[b_find] = a_find


for p in prob:
    union(p[0], p[1])

for i in range(N + 1):
    find(i) # 경로 압축 한번 더 

S = set(parent[1:])

print(len(S))
