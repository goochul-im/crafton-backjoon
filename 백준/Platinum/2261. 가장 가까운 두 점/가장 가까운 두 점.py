import sys

def get_distance(first, second):
    return (first[0] - second[0]) ** 2 + (first[1] - second[1]) ** 2

def find_boundary_distance(lis):
    result = float('inf')
    for i in range(len(lis)):
        for j in range(i + 1, len(lis)):  # 위쪽으로만 확인
            if (lis[j][1] - lis[i][1]) ** 2 >= result:
                break  # 현재 최소 거리보다 더 멀어지면 탐색 중단
            result = min(result, get_distance(lis[i], lis[j]))
    return result

def find(left, right, y_sorted):
    if right - left <= 1:
        return get_distance(points[left], points[right])

    middle = (left + right) // 2
    left_result = find(left, middle, [p for p in y_sorted if p[0] <= points[middle][0]])
    right_result = find(middle, right, [p for p in y_sorted if p[0] > points[middle][0]])
    d = min(left_result, right_result)

    # 경계 근처의 점들만 필터링
    temp = [p for p in y_sorted if abs(p[0] - points[middle][0]) ** 2 < d]

    # 경계 부분 거리 계산 최적화
    d = min(d, find_boundary_distance(temp))

    return d

# 입력 처리
N = int(sys.stdin.readline().strip())
points = [tuple(map(int, sys.stdin.readline().split())) for _ in range(N)]
points.sort()  # x좌표 기준 정렬
y_sorted = sorted(points, key=lambda k: k[1])  # 처음 한 번만 y 정렬

# 정답 출력 (최소 거리)
print(find(0, N - 1, y_sorted))
