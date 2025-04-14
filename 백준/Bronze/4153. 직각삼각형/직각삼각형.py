# 4153 직각삼각형
import sys

prob = list(list(map(int, line.split())) for line in (sys.stdin.read().splitlines()))

prob = prob[:-1]

for p in prob:
    p.sort()
    if p[0] ** 2 + p[1] ** 2 == p[2] ** 2:
        print("right")
    else:
        print("wrong")
