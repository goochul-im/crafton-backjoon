# 더하기 사이클
import sys

N = int(sys.stdin.readline())

COUNT = 0


def recursion(cur_num: int):
    global COUNT
    COUNT+= 1

    first = cur_num // 10
    second = cur_num % 10

    new_num = first + second

    cur_num = second * 10 + new_num % 10

    if cur_num == N:
        print(COUNT)
        return

    recursion(cur_num)


recursion(N)

