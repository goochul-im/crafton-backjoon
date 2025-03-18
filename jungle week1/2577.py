import sys

prob = list(map(int, sys.stdin.read().split()))

task = str(prob[0] * prob[1] * prob[2])
for i in range(10):
    count = sum(1 for char in task if str(i) == char)
    print(count)
