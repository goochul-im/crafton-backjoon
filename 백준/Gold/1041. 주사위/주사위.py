# 주사위
import sys

N = int(sys.stdin.readline())

numbers = list(map(int, sys.stdin.readline().split()))

INF = int(1e9)

result, corner, edge = 0, INF, INF

for i in range(6):
    for j in range(6):
        if i == j or i + j == 5:
            continue
        edge = min(edge, numbers[i] + numbers[j])

for i in range(6):
    for j in range(6):
        if i == j or i + j == 5:
            continue
        for k in range(6):
            if i == k or j == k or i + k == 5 or j + k == 5:
                continue
            corner = min(corner, numbers[i] + numbers[j] + numbers[k])

edge_area = ((N - 1) * 4 + (N - 2) * 4) * 2
corner_area = 12
remain_area = ((N ** 2) * 5) - edge_area - corner_area

if N == 1:
    print(sum(numbers) - max(numbers))
else:
    print(remain_area * min(numbers) + edge_area // 2 * edge + corner_area // 3 * corner)
