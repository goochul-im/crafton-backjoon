# 9251 LCS
import sys

A = list(sys.stdin.readline().strip())
B = list(sys.stdin.readline().strip())

lcs = [[0 for _ in range(len(B) + 1)] for _ in range(len(A) + 1)]


for i in range(1, len(A) + 1):
    for j in range(1, len(B) + 1):
        if A[i - 1] == B[j - 1]:
            lcs[i][j] = lcs[i - 1][j - 1] + 1
        else:
            lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1])

print(lcs[len(A)][len(B)])
