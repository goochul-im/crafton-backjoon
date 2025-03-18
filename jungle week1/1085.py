import sys

line = sys.stdin.readline()

x, y, w, h = map(int, line.split())

print(min(x, w-x, y, h-y))
