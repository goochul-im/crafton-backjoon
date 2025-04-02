# 1043 거짓말
import sys

N, M = map(int, sys.stdin.readline().split())

true_person = [False] * 51

temp = list(map(int, sys.stdin.readline().split()))
for u in range(1, temp[0] + 1):
    true_person[temp[u]] = True

parent = [i for i in range(N + 1)]
party = []

for _ in range(M):
    party.append(list(map(int, sys.stdin.readline().split()[1:])))


def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]


def union(a, b):
    a_find = find(a)
    b_find = find(b)
    if a_find != b_find:
        if true_person[a_find]:
            parent[b_find] = a_find
        else:
            parent[a_find] = b_find


def execute():
    count = 0
    for i in range(M):
        if len(party[i]) > 1:
            for j in range(1, len(party[i])):
                union(party[i][0], party[i][j])
    for i in range(len(parent)):
        find(i)
    for i in range(M):
        flag = False
        for person in party[i]:
            if true_person[parent[person]]:
                flag = True
                break
        if flag:
            continue
        count += 1

    print(count)


execute()
