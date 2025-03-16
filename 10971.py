# import sys
#
# N = int(sys.stdin.readline())
# W = []
# INF = float('inf')
#
# for i in range(N):
#     W.append(list(map(int, sys.stdin.readline().split())))
#
# FULL = (1 << N) - 1  # 모든 정점을 방문한 상태??
# COUNT = INF
#
#
# def tsp(cur, visit, start, dp):
#     if visit == FULL:
#         return W[cur][start] if W[cur][start] != 0 else INF
#
#     if dp[cur][visit] is not None:
#         return dp[cur][visit]
#
#     result = INF
#
#     for j in range(N):
#         if visit & (1 << j) == 0 and W[cur][j] != 0:
#             result = min(result, tsp(j, visit | (1 << j), start, dp) + W[cur][j] )
#     dp[cur][visit] = result
#     return result
#
#
# for start in range(N):
#     D = [[None] * (1 << N) for _ in range(N)]  ## 비트마스킹, 1<<N 은 정점 N개의 개수만큼 비트 수를 만들겠다는 의미
#     # dp 테이블을 각 정점마다 새로 만들기
#     COUNT = min(COUNT, tsp(start, (1 << start), start, D))
#
# print(COUNT)
#

