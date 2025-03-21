# 3190 뱀
import sys
from collections import deque

N = int(sys.stdin.readline())
K = int(sys.stdin.readline())

apple = []
for i in range(K):
    apple.append(list(map(int, sys.stdin.readline().split())))

L = int(sys.stdin.readline())
moving = []
move_direction = [(-1, 0), (0, 1), (1, 0), (0, -1)]  # 상우하좌
now_time = 0
for i in range(L):
    initial_line = sys.stdin.readline().split()
    initial_line[0] = int(initial_line[0])
    moving.append(initial_line)

# print(moving)

# print(apple)
# print(moving)
snake = deque()  # row와 col은 0부터 시작한다
snake.append([1, 1])
ROW = 0
COL = 1


def find():
    count = 0
    head = snake[-1]  # 맨 뒤가 머리
    # print(head)
    # print(rear)
    now_dir_point = 1
    move_idx = 0
    while True:
        now_direction = move_direction[now_dir_point]  # 처음엔 오른쪽으로 가자
        count += 1  # 초 증가
        next_head_row = head[ROW] + now_direction[ROW]
        next_head_col = head[COL] + now_direction[COL]
        next_point = [next_head_row, next_head_col]
        # print(next_point)
        if 1 > next_head_row or next_head_row > N or 1 > next_head_col or next_head_col > N or next_point in snake: # 벽에 부딪혔거나 몸에 부딪히면
            print(count)
            return
        snake.append([next_head_row, next_head_col])  # 머리 먼저 다음칸에
        head = snake[-1]
        if head in apple:  # 이동한 곳에 사과가 있으면
            apple.remove(head)  # 사과 제거, 꼬리는 그대로 냅둔다
        else:
            snake.popleft()  # 꼬리 제거
        # 기록된 초가 되면 방향전환하도록
        if move_idx < len(moving) and count == moving[move_idx][0]:
            next_direction = moving[move_idx][1]
            move_idx += 1
            if next_direction == 'L': # 왼쪽으로 꺾자
                now_dir_point = (now_dir_point + 3) % 4
            else: # 오른쪽으로 꺾자
                now_dir_point = (now_dir_point + 1) % 4
            # print("방향 전환")


find()
