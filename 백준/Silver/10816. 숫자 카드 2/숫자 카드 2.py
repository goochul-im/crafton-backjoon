# 10816 숫자 카드 2
import sys

N = int(sys.stdin.readline())

prob = list(map(int, sys.stdin.readline().split()))

M = int(sys.stdin.readline())

card = list(map(int, sys.stdin.readline().split()))

prob = sorted(prob, reverse=True)
card_sorted = sorted(card, reverse=True)

prob_idx = 0
card_idx = 0

result = {}
temp_count = 0

for c in card_sorted:
    while prob_idx < len(prob) and c < prob[prob_idx] :
        prob_idx += 1
    while prob_idx < len(prob) and c == prob[prob_idx] :
        result[c] = result.get(c, 0) + 1
        prob_idx += 1

message = []
for c in card:
    message.append(result.get(c, 0))

print(*message)
