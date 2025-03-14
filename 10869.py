import sys

number = sys.stdin.readline()
first, second = number.split(" ")

print(int(first) + int(second))
print(int(first) - int(second))
print(int(first) * int(second))
print(int(first) // int(second))
print(int(first) % int(second))
