import sys

N = int(sys.stdin.readline())

matrix = []

for i in range(N):
    prob = list(map(int, sys.stdin.readline().split()))
    matrix.append(prob)

# if N == 1:
#     max_result = max(sum[0][0], sum[0][1], sum[0][2])
#     min_result = min(sum[0][0], sum[0][1], sum[0][2])
#     print(f"{max_result} {min_result}")
#     sys.exit(1)

sum = [[0] * 3 for _ in range(2)]
sum[0][0] = matrix[0][0]
sum[0][1] = matrix[0][1]
sum[0][2] = matrix[0][2]

for i in range(1, N):
    if i % 2 == 1:
        sum[1][0] = max(sum[0][0] + matrix[i][0], sum[0][1] + matrix[i][0])
        sum[1][1] = max(sum[0][0] + matrix[i][1], sum[0][1] +
                        matrix[i][1], sum[0][2] + matrix[i][1])
        sum[1][2] = max(sum[0][1] + matrix[i][2], sum[0][2] + matrix[i][2])
    else:
        sum[0][0] = max(sum[1][0] + matrix[i][0], sum[1][1] + matrix[i][0])
        sum[0][1] = max(sum[1][0] + matrix[i][1], sum[1][1] +
                        matrix[i][1], sum[1][2] + matrix[i][1])
        sum[0][2] = max(sum[1][1] + matrix[i][2], sum[1][2] + matrix[i][2])

max_result = max(sum[0][0], sum[0][1], sum[0][2]) if N % 2 == 1 else max(
    sum[1][0], sum[1][1], sum[1][2])

sum = [[0] * 3 for _ in range(2)]
sum[0][0] = matrix[0][0]
sum[0][1] = matrix[0][1]
sum[0][2] = matrix[0][2]

for i in range(1, N):
    if i % 2 == 1:
        sum[1][0] = min(sum[0][0] + matrix[i][0], sum[0][1] + matrix[i][0])
        sum[1][1] = min(sum[0][0] + matrix[i][1], sum[0][1] +
                        matrix[i][1], sum[0][2] + matrix[i][1])
        sum[1][2] = min(sum[0][1] + matrix[i][2], sum[0][2] + matrix[i][2])
    else:
        sum[0][0] = min(sum[1][0] + matrix[i][0], sum[1][1] + matrix[i][0])
        sum[0][1] = min(sum[1][0] + matrix[i][1], sum[1][1] +
                        matrix[i][1], sum[1][2] + matrix[i][1])
        sum[0][2] = min(sum[1][1] + matrix[i][2], sum[1][2] + matrix[i][2])

min_result = min(sum[0][0], sum[0][1], sum[0][2]) if N % 2 == 1 else min(
    sum[1][0], sum[1][1], sum[1][2])

print(f"{max_result} {min_result}")
