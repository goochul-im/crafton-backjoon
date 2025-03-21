# 11866 요세푸스 문제
import sys
from collections import deque

N, K = map(int, sys.stdin.readline().split())

prob = deque([x for x in range(1, N + 1)])
message = "<"


def find():
    global message
    while len(prob) > 0:
        for i in range(K - 1):
            prob.append(prob.popleft())
        message += f"{prob.popleft()}, "


find()
print(message[:-2] + ">")
