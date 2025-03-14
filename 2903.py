# 2,
# 2+1,
# 2+1+2
# 2+1+2+4
# 2+1+2+4+8
# 2+1+2+4+8+16 = 33
# 2+1+2+4+8+16+32

# 33*33 = 1089

def solution(n):
    point = 2
    for i in range(1, n+1):
        print(i)

solution(5)
