# 13334 철로
import sys
import heapq

N = int(sys.stdin.readline())

temp_list = []
start = []
end = []

for _ in range(N):
    first, second = map(int, sys.stdin.readline().split())
    temp_list.append((first, second))

D = int(sys.stdin.readline())

for i in range(N):
    first, second = temp_list[i]
    if abs(first - second) <= D:
        heapq.heappush(start, min(first, second))
        heapq.heappush(end, max(first, second))


result = 0
count = 0
idx = 0
while start:
    check_start_point = heapq.heappop(start)  # 체크할 시작점 포인트
    distance = check_start_point + D
    while end and end[0] <= distance:
        heapq.heappop(end)
        count += 1
    result = max(result, count - idx)
    idx += 1

print(result)
