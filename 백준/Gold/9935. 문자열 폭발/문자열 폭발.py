# 9935 문자열 폭발
import sys

prob = list(sys.stdin.readline().strip())
bomb = list(sys.stdin.readline().strip())

stack = []
bomb_len = len(bomb)


for p in prob:
    stack.append(p)
    if len(stack) >= bomb_len and stack[-bomb_len:] == bomb:
        for i in range(bomb_len):
            stack.pop()

if stack:
    print("".join(stack))
else:
    print("FRULA")



