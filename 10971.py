import sys

N = int(sys.stdin.readline())
W = []
INF = float('inf')

for i in range(N):
    W.append(list(map(int, sys.stdin.readline().split())))

FULL = (1 << N) - 1  # 모든 정점을 방문한 상태??
COUNT = INF


def tsp(cur, visit, start, dp):
    if visit == FULL:
        return W[cur][start] if W[cur][start] != 0 else INF

    if dp[cur][visit] is not None:
        return dp[cur][visit]

    result = INF

    for j in range(N):
        if visit & (1 << j) == 0 and W[cur][j] != 0:
            result = min(result, tsp(j, visit | (1 << j), start, dp) + W[cur][j] )
    dp[cur][visit] = result
    return result


for start in range(N):
    D = [[None] * (1 << N) for _ in range(N)]  ## 비트마스킹, 1<<N 은 정점 N개의 개수만큼 비트 수를 만들겠다는 의미
    # dp 테이블을 각 정점마다 새로 만들기
    COUNT = min(COUNT, tsp(start, (1 << start), start, D))

print(COUNT)

# import sys
#
# input = sys.stdin.readline
# N = int(input().strip())
# W = [list(map(int, input().split())) for _ in range(N)]
# INF = float('inf')
# FULL = (1 << N) - 1  # 모든 정점을 방문한 상태
#
#
# # 재귀 함수: 현재 정점 cur, 방문 상태 mask, 시작 정점 start, dp 테이블을 인자로 받음
# def tsp(cur, mask, start, dp):
#     # 모든 정점을 방문했다면, 현재 정점에서 시작 정점으로 돌아갈 수 있는지 확인
#     if mask == FULL:
#         return W[cur][start] if W[cur][start] != 0 else INF
#
#     # 이미 계산된 경우 재사용
#     if dp[cur][mask] is not None:
#         return dp[cur][mask]
#
#     cost = INF
#     # 아직 방문하지 않은 모든 정점에 대해 경로 탐색
#     for nxt in range(N):
#         if (mask & (1 << nxt)) == 0 and W[cur][nxt] != 0:
#             cost = min(cost, W[cur][nxt] + tsp(nxt, mask | (1 << nxt), start, dp))
#     dp[cur][mask] = cost
#     return cost
#
#
# answer = INF
# # 모든 정점을 시작점으로 하여 TSP를 수행
# for start in range(N):
#     # 시작점에 대해 별도의 dp 테이블 사용 (시작점에 따라 dp가 달라짐)
#     dp = [[None] * (1 << N) for _ in range(N)]
#     answer = min(answer, tsp(start, 1 << start, start, dp))
# print(answer)
