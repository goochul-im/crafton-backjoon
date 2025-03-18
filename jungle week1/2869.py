import sys, math

A, B, V = map(int,sys.stdin.readline().split())

go_of_date = A-B
V = V-B

print(math.ceil(V/go_of_date))
