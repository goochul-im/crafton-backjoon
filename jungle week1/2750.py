import sys

prob = list(map(int, sys.stdin.read().split()[1:]))

S = sorted(set(prob))

for s in S:
    print(s)
