# 2805 나무 자르기
import sys

N, M = map(int, sys.stdin.readline().split())
prob = sorted(list(map(int, sys.stdin.readline().split())))


def get_cutting_trees(height: int):
    result = 0
    for tree in prob:
        if tree > height:
            result += (tree - height)
    return result


def binary_cutting():
    left = 1
    right = prob[N - 1]
    result_height = 0
    while left <= right:
        middle = (left + right) // 2  # 자를 나무의 높이
        result = get_cutting_trees(middle)
        if M <= result: # 더 적게 잘라야 하고, 자를 높이가 높아진다, 지금 자른 나무가 M보다 많다
            left = middle + 1
            result_height = max(result_height, middle)
        else: #더 많이 자를 수 있다, 자를 높이가 낮아진다, 자른 나무가 M보다 적다
            right = middle - 1

    print(result_height)


binary_cutting()
