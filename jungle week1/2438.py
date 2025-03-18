import sys

n = int(sys.stdin.readline())
message = ""

for i in range(1, n+1):
    message += "*" * i + "\n"

print(message)
