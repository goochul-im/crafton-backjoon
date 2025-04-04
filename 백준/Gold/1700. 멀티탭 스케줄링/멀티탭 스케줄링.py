# 1700 멀티탭 스케줄링
# OPT 알고리즘
import sys

N, K = map(int, sys.stdin.readline().split())

prob = list(map(int, sys.stdin.readline().split()))

multi_tap = set()
count = 0


def opt(idx):
    farthest_elem = None
    farthest_dis = 0

    for elem in multi_tap:
        dis = 0
        for check_idx in range(idx, len(prob)):
            if elem == prob[check_idx]:
                break
            dis += 1
        if farthest_dis <= dis:
            farthest_dis = dis
            farthest_elem = elem

    multi_tap.remove(farthest_elem)


for i in range(len(prob)):
    p = prob[i]
    if p in multi_tap:
        continue

    if len(multi_tap) < N:
        multi_tap.add(p)
    else:
        # TODO: OPT 구현
        opt(i)
        multi_tap.add(p)
        count += 1

print(count)
