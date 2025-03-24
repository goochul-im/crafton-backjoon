import sys


def multi(a, b):
    X = [[0] * N for _ in range(N)]
    for i in range(N):  # 행렬
        for j in range(N):
            for k in range(N):
                X[i][j] += a[i][k] * b[k][j] % 1000  # 곱셈 연산
    return X


def square(x, n):  # 분할 정복을 이용해 요구 사항만큼 제곱하기
    if n == 1:
        return x
    temp = square(x, n // 2)
    if n % 2 == 0:
        return multi(temp, temp)
    else:
        return multi(multi(temp, temp), x)


N, B = map(int, sys.stdin.readline().split())
A = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
result = square(A, B)
for i in range(N):  # 요구조건 대로 1000으로 나눠주자
    for j in range(N):
        result[i][j] = result[i][j] % 1000

for k in result:
    print(*k)
