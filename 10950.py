import sys

n = int(sys.stdin.readline())
case = []

for i in range(n):
    case.append(sys.stdin.readline())

for prob in case:
    x, y = map(int, prob.split(" "))
    print(x + y)
