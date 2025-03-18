# 14889 스타트와 링크
import sys

N = int(sys.stdin.readline())
S = []
for _ in range(N):
    S.append(list(map(int, sys.stdin.readline())))

COUNT = float('inf')
CHECK = [False] * N
START = []
LINK = []


def get_count():
    start_result = 0
    for member1 in START:
        for member2 in START:
            start_result += S[member1][member2]
    link_result = 0
    for member1 in LINK:
        for member2 in LINK:
            link_result += S[member1][member2]

    return abs(start_result, link_result)


def backtracking(depth):
    global COUNT
    member_length = N // 2
    if depth > member_length:
        COUNT = min(COUNT, get_count())

    for i in range(N):
        if CHECK[i] is False and len(START) < member_length:
            CHECK[i] = True
            START.append(i)
        for k in range(N):
            if CHECK[k] is False and len(LINK) < member_length:
                CHECK[k] = True
                LINK.append(k)
                backtracking(depth + 1)
                LINK.remove(k)
                CHECK[k] = False
            START.remove(i)
            CHECK[i] = False
