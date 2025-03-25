import sys

N = int(sys.stdin.readline())

count = (1 << N) - 1  # 2^N - 1
moves = []

def hanoi(n, start, end, via):
    if n == 0:
        return
    hanoi(n - 1, start, via, end)
    if n <= 20:
        moves.append(f"{start} {end}")  # 리스트에 추가 (빠른 연산)
    hanoi(n - 1, via, end, start)

print(count)  # 재귀 호출 없이 이동 횟수 계산
if N <= 20:
    hanoi(N, 1, 3, 2)  # N <= 20인 경우만 이동 경로 출력
    print("\n".join(moves))  # 한 번만 출력하여 최적화
