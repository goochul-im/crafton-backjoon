# 2253 점프
import sys, math

N, M = map(int, sys.stdin.readline().split())

small_stones = list(map(int, sys.stdin.read().splitlines()))

INF = int(1e9)
MAX_JUMP = int(math.sqrt(2 * N)) + 2

dp = [[INF] * MAX_JUMP for _ in range(N + 1)]

stone_set = set(small_stones)
dp[1][0] = 0  # 처음엔 점프 x, 이전에 이동하지도 않음

for x in range(2, N + 1):
    if x in stone_set:
        continue
    for y in range(1, MAX_JUMP - 1):
        dp[x][y] = min(dp[x - y][y - 1], dp[x - y][y], dp[x - y][y + 1]) + 1
        # dp[x - y] 인 이유? 이전에 y칸만큼 점프 했었으니까

i = min(dp[N])
print(i if i != INF else -1)
