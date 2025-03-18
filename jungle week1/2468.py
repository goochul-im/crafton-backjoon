import sys
from collections import deque

N = int(sys.stdin.readline())
area = []
check_area = []
Q = deque()
moving = [[0, -1], [1, 0], [0, 1], [-1, 0]]  # 왼쪽, 아래, 오른쪽, 위
ROW, COL = 0, 1
COUNT = 0
MAX_COUNT = 1
for i in range(N):
    list_input = list(map(int, sys.stdin.readline().split()))
    area.append(list_input)


def bfs(row, col, water_level):
    global COUNT
    Q.append((row, col))
    check_area[row][col] = True

    while len(Q) != 0:
        length = len(Q)

        for k in range(length):
            pop = Q.popleft()
            # 확인해야 할 점
            # 다음 위치가 범위를 벗어나는지
            # 다음 위치가 수위에 잠겨있는지
            # 다음 위치를 이미 방문했었는지
            for next_point in range(4):
                next_row = pop[ROW] + moving[next_point][ROW]
                next_col = pop[COL] + moving[next_point][COL]
                if 0 <= next_row < N and 0 <= next_col < N and check_area[next_row][next_col] is False and \
                        area[next_row][
                            next_col] > water_level:
                    check_area[next_row][next_col] = True
                    Q.append((next_row, next_col))
    # bfs 한번으로 영역 하나 찾기
    COUNT += 1


MAX_WATER_LEVEL = max(map(max, area))
MIN_WATER_LEVEL = min(map(min, area))

# 수위의 최소값과 최대값 구해서 for문 돌리기
for water in range(MIN_WATER_LEVEL, MAX_WATER_LEVEL): # 최대값은 어차피 잠기니까 포함 X
    COUNT = 0
    check_area = [[False] * N for _ in range(N)]  # 체크 리스트 초기화
    for i in range(N):
        for j in range(N):
            if area[i][j] > water and check_area[i][j] is False:
                bfs(i, j, water)
    MAX_COUNT = max(MAX_COUNT, COUNT)
print(MAX_COUNT)
