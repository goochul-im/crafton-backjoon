# 1931 회의실 배정
import sys

N = int(sys.stdin.readline())

prob = [list(map(int, line.split())) for line in list(sys.stdin.read().splitlines())]

prob.sort(key=lambda x: (x[1], x[0]))

close_time = 0
COUNT = 0

for p in prob:
    start, end = p
    if start >= close_time:
        COUNT += 1
        close_time = end

print(COUNT)
