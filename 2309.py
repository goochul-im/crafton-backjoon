import sys

prob = list(map(int, sys.stdin.read().split()))


def find(idx, result):
    if len(result) == 7:
        if sum(result) == 100:
            for K in sorted(result):
                print(K)
            exit()
        return

    if idx >= len(prob):
        return

    for i in range(idx + 1, len(prob)):
        result.append(prob[i])
        find(i, result)
        result.pop()


li = []
find(-1, li)
