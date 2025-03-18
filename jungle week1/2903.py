import sys

number = int(sys.stdin.readline())


def solution(n):
    point = 2
    adder = 1
    for i in range(1, n + 1):
        point += adder
        adder *= 2
    print(point ** 2)


solution(number)
