# 17608
import sys

N = int(sys.stdin.readline())

prob = list(map(int, sys.stdin.read().split()))


def find():
    criteria = prob.pop()
    count = 1

    while len(prob) > 0:
        ne = prob.pop()
        if ne > criteria:
            criteria = ne
            count += 1

    print(count)


find()
