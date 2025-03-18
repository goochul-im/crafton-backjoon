# 14888 연산자 끼워넣기

import sys

N = int(sys.stdin.readline())
prob = list(map(int, sys.stdin.readline().split()))
operator = list(map(int, sys.stdin.readline().split()))

MIN_COUNT = float('inf')
MAX_COUNT = float('-inf')


def calc_with_opcode(a: int, b: int, op: int):
    if op == 0:
        return a + b
    elif op == 1:
        return a - b
    elif op == 2:
        return a * b
    else:
        if a < 0:
            return -(-a // b)
        return a // b


def calc(idx, cur_count):
    global MIN_COUNT
    global MAX_COUNT
    if idx >= N:
        MIN_COUNT = min(MIN_COUNT, cur_count)
        MAX_COUNT = max(MAX_COUNT, cur_count)
        return

    for op_count in range(4):
        if operator[op_count] > 0:
            operator[op_count] -= 1
            calc(idx + 1, calc_with_opcode(cur_count, prob[idx], op_count))
            operator[op_count] += 1


calc(1, prob[0])

print(MAX_COUNT)
print(MIN_COUNT)
