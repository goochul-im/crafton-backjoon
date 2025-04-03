# 9084 동전
import sys

T = int(sys.stdin.readline())

dp = []

def execute():
    global dp
    for _ in range(T):
        N = int(sys.stdin.readline())
        coins = list(map(int, sys.stdin.readline().split()))
        money = int(sys.stdin.readline())
        dp = [0 for _ in range(money + 1)]
        dp[0] = 1

        for coin in coins:
            for i in range(coin, money + 1):
                dp[i] += dp[i - coin]

        print(dp[money])

execute()
