# 13549 숨바꼭질 3
import sys
from collections import deque

N, K = map(int, sys.stdin.readline().split())

END = 100000
is_visited = [False for _ in range(END + 1)]
is_visited[N] = True
ans = []


def bfs():
    Q = deque()
    Q.append((N, 0))

    while Q:
        length = len(Q)
        for _ in range(length):
            now, time = Q.popleft()
            if now == K:
                ans.append(time)
                return

            next_1 = now - 1
            next_2 = now + 1
            next_3 = now * 2
            if 0 <= next_3 <= END and not is_visited[next_3]:
                is_visited[next_3] = True
                Q.appendleft((next_3, time))
            if 0 <= next_1 <= END and not is_visited[next_1]:
                is_visited[next_1] = True
                Q.append((next_1, time + 1))
            if 0 <= next_2 <= END and not is_visited[next_2]:
                is_visited[next_2] = True
                Q.append((next_2, time + 1))


bfs()
print(sorted(ans)[0])
