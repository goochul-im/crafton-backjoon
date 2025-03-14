import sys

prob = sys.stdin.read().split()[1:]


for p in prob:
    point = 0
    result = 0
    for char in p:
        if char == 'O':
            point += 1
            result += point
        else:
            point = 0
    print(result)

