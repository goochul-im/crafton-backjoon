import sys

point = sys.stdin.readline()


def solution(n):
    answer = ""
    if n >= 90:
        answer = "A"
    elif n >= 80:
        answer = "B"
    elif n >= 70:
        answer = "C"
    elif n >= 60:
        answer = "D"
    else:
        answer = "F"
    print(answer)


solution(int(point))
