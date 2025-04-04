# 1946 신입 사원
import sys

T = int(sys.stdin.readline())

for _ in range(T):
    N = int(sys.stdin.readline())
    prob = []
    for _ in range(N):
        prob.append(list(map(int, sys.stdin.readline().split())))
    prob.sort(key=lambda x: (x[0], x[1]))
    count = 1
    interview_score = prob[0][1]
    for i in range(1, len(prob)):
        if prob[i][1] <= interview_score:
            count += 1
            interview_score = prob[i][1]

    print(count)
