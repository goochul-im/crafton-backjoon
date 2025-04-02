# 12865 평범한 배낭
import sys

N, K = map(int, sys.stdin.readline().split())

dp = [[None] * (N + 1) for _ in range(K + 1)]
for items in range(0, N + 1):
    dp[0][items] = 0

for back in range(0, K + 1):
    dp[back][0] = 0

item = [[] for _ in range(N + 1)]
for it in range(1, N + 1):
    weight, value = map(int, sys.stdin.readline().split())
    item[it] = [weight, value]

WEIGHT = 0
VALUE = 1


def dynamic(in_item, back_weight):
    if dp[back_weight][in_item] is not None:
        return dp[back_weight][in_item]

    # if in_item == 0 or back_weight == 0:
    #     return 0
    if back_weight < item[in_item][0]:
        dp[back_weight][in_item] = dynamic(in_item - 1, back_weight)
    else:
        dp[back_weight][in_item] = (
            max(dynamic(in_item - 1, back_weight),
                dynamic(in_item - 1, back_weight - item[in_item][WEIGHT]) + item[in_item][VALUE]))

    return dp[back_weight][in_item]


print(dynamic(N, K))
