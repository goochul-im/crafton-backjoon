# 14889 스타트와 링크
import sys

N = int(sys.stdin.readline())
S = []
for _ in range(N):
    S.append(list(map(int, sys.stdin.readline().split())))

COUNT = float('inf')
CHECK = [False] * N


def get_count():
    # start_result = 0
    # start_team = [idx for idx, val in enumerate(CHECK) if val is True]
    # link_team = [idx for idx, val in enumerate(CHECK) if val is False]
    # for member1 in start_team:
    #     for member2 in start_team:
    #         start_result += S[member1][member2]
    # link_result = 0
    # for member1 in link_team:
    #     for member2 in link_team:
    #         link_result += S[member1][member2]

    result = 0
    for member1 in range(N):
        if CHECK[member1]:
            for member2 in range(N):
                if CHECK[member2] and member1 != member2:
                    result += S[member1][member2]
        else:
            for member2 in range(N):
                if CHECK[member2] is False and member1 != member2:
                    result -= S[member1][member2]

    return abs(result)


def backtracking(depth, idx):
    global COUNT
    member_length = N // 2
    if depth >= member_length:
        COUNT = min(COUNT, get_count())
        return

    for i in range(idx, N):
        CHECK[i] = True
        backtracking(depth + 1, i + 1)
        CHECK[i] = False


backtracking(0, 0)

print(COUNT)
