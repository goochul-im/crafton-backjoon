import sys

N = int(sys.stdin.readline())
W = []
for i in range(N):
    W.append(list(map(int, sys.stdin.readline())))

for i in range(N):
    for j in range(N):
        if i != j and W[i][j] == 0:
            W[i][j] = float('inf') # 직선으로 이동할 수 없음




