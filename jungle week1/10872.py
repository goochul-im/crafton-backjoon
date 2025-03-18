import sys

number = int(sys.stdin.readline())

def facto(n):
    answer = 1
    for i in range(2,n+1):
        answer *= i
    return answer

print(facto(number))
