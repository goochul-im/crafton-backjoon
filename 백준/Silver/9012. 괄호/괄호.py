# 9012 괄호
import sys
from collections import deque

N = int(sys.stdin.readline())
prob = []

for _ in range(N):
    prob.append(sys.stdin.readline().strip())


def is_correct_string():
    for string in prob:
        flag = False
        stack = deque()
        for char in string:
            if char == ')' and len(stack) == 0:
                print("NO")
                flag = True
                break
            if char == '(':
                stack.append(char)
            else:
                stack.pop()
        if flag:
            continue
        if len(stack) != 0:
            print("NO")
        else:
            print("YES")

is_correct_string()
