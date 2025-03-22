# 2812 크게 만들기
import sys

N, K = map(int, sys.stdin.readline().split())

prob = list(map(int, list(sys.stdin.readline().strip())))

stack = []
count = 0

for num in prob:
    while stack and stack[-1] < num and count < K:
        stack.pop()
        count += 1
    stack.append(num)

while count < K:
    stack.pop()
    count += 1

print("".join(list(map(str, stack))))
