# 2164 카드2
import sys
from collections import deque

N = int(sys.stdin.readline())


def card_game():
    q = deque([x for x in range(1, N + 1)])
    idx = 1
    while len(q) > 1:
        if idx % 2 == 1:
            q.popleft()
        else:
            q.append(q.popleft())
        idx += 1
    print(q[0])


card_game()
