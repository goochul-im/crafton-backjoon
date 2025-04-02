import sys
from collections import deque

N, K = map(int, sys.stdin.readline().split())

MAX_RESULT = -1

def bfs(start_digits):
    global MAX_RESULT
    Q = deque()
    Q.append((start_digits, 0))
    is_visited = [set() for _ in range(K + 1)]
    is_visited[0].add(int("".join(map(str, start_digits))))

    while Q:
        cur_digits, depth = Q.popleft()
        if depth == K:
            MAX_RESULT = max(MAX_RESULT, int("".join(map(str, cur_digits))))
            continue

        for i in range(len(cur_digits) - 1):
            for j in range(i + 1, len(cur_digits)):
                temp = cur_digits[:]
                if i == 0 and temp[j] == 0:
                    continue
                temp[i], temp[j] = temp[j], temp[i]
                cur_result = int("".join(map(str, temp)))
                if cur_result not in is_visited[depth + 1]:
                    is_visited[depth + 1].add(cur_result)
                    Q.append((temp, depth + 1))


digits = [int(d) for d in str(N)]
if len(digits) == 1 or (len(digits) == 2 and digits[1] == 0):
    print(-1)  # 자릿수 1개거나 10, 20 같은 경우는 교환 불가
else:
    bfs(digits)
    print(MAX_RESULT)
