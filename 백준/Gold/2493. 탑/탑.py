# 2493 탑
import sys
from collections import deque

N = int(sys.stdin.readline())

tower = list(map(int, sys.stdin.readline().split()))


def find_tower():
    stack = deque()
    stack.append(0)
    message = []
    for t in range(N):
        while len(stack) > 1 and tower[stack[-1] - 1] < tower[t]:
            stack.pop()
        message.append(stack[-1])
        stack.append(t + 1)
    print(" ".join(map(str, message)))


find_tower()
