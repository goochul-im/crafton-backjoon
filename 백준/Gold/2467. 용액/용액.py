import sys

N = int(sys.stdin.readline())

prob = sorted(list(map(int, sys.stdin.readline().split())))


def binary():
    answer = []
    min_val = float('inf')
    for i in range(N):
        left = i + 1
        right = N - 1
        middle = 0
        while left <= right:
            middle = (left + right)//2
            if prob[middle] + prob[i] == 0:
                answer = sorted([prob[middle], prob[i]])
                print((" ").join(map(str, answer)))
                return
            elif prob[middle] + prob[i] < 0:
                left = middle + 1
            else:
                right = middle - 1

            if abs(min_val) > abs(prob[middle] + prob[i]):
                min_val = prob[middle] + prob[i]
                answer = sorted([prob[middle], prob[i]])

    print((" ").join(map(str, answer)))


binary()
