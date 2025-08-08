import sys

K, N = map(int, sys.stdin.readline().split())
prob = list(map(int, sys.stdin.read().split()))


def get_lines(delimeter):
    count = 0
    for line in prob:
        count += line // delimeter
    return count


def binary_search():
    max_length = float('-inf')
    right = max(prob)
    left = 1
    while left <= right:
        middle = (left + right) // 2
        line_cnt = get_lines(middle)
        if line_cnt >= N:
            max_length = max(max_length, middle)
            left = middle + 1
        else:
            right = middle - 1

    print(max_length)


binary_search()
