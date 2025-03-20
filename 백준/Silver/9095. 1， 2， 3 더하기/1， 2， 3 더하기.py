# 1,2,3 더하기
import sys

prob = list(map(int, sys.stdin.read().split()[1:]))


COUNT = 0


def find(cur_sum: int, goal_sum: int):
    global COUNT
    if cur_sum == goal_sum:
        COUNT += 1
        return

    for i in range(1, 4):
        next_sum = cur_sum + i
        if next_sum <= goal_sum:
            find(next_sum, goal_sum)


for now in prob:
    COUNT = 0
    find(0, now)
    print(COUNT)
