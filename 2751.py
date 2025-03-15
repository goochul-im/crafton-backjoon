import sys, heapq

prob = list(map(int, sys.stdin.read().split()[1:]))

heapq.heapify(prob)

while prob:
    print(heapq.heappop(prob))
