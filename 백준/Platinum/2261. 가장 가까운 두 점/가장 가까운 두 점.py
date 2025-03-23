# 2261 가장 가까운 두 점
import sys

N = int(sys.stdin.readline())

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
    temp = [t for t in y_sorted if abs(t[0] - points[middle][0]) ** 2 < d]
    d = min(d, find_boundary_distance(temp))
    return d


points = []
for _ in range(N):
    points.append(tuple(map(int, sys.stdin.readline().split())))
points.sort()
y_sorted_list = sorted(points, key=lambda k: k[1])
print(find(0, N - 1, y_sorted_list))
