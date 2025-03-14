import sys

n = int(sys.stdin.readline().split()[1])
prob = map(int, sys.stdin.readline().split())

prob = [x for x in prob if x < n]
print(" ".join(map(str, prob)))
