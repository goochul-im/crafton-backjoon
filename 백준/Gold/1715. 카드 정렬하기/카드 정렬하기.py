# 1715 카드 정렬하기
import sys
import heapq

N = int(sys.stdin.readline())

prob = []
for _ in range(N):
    heapq.heappush(prob, int(sys.stdin.readline().strip()))


def find():
    if len(prob) == 1:
        print(0)
        return
    result = 0
    while len(prob) > 1:
        card_sum = heapq.heappop(prob) + heapq.heappop(prob)
        result += card_sum
        heapq.heappush(prob, card_sum)

    print(result)


find()
