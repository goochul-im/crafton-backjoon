import sys

prob = list(set(sys.stdin.read().split()[1:]))


prob = sorted(prob, key=lambda x: (len(x),x))
for p in prob:
    print(p)


