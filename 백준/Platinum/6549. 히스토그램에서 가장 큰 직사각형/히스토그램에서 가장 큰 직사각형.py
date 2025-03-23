import sys

def divide(histograms):
    if len(histograms) == 1:
        return histograms[0]

    mid = len(histograms) // 2
    left_idx, right_idx = mid - 1, mid

    mid_height = min(histograms[left_idx], histograms[right_idx])
    mid_width = 2
    mid_max = mid_height * mid_width

    left_area = histograms[:mid]
    right_area = histograms[mid:]

    while (left_idx > 0 or right_idx < len(histograms) - 1):
        current_height = 0
        
        if left_idx == 0:
            right_idx += 1
            current_height = histograms[right_idx]

        elif right_idx == len(histograms) - 1:
            left_idx -= 1
            current_height = histograms[left_idx]

        elif histograms[left_idx - 1] > histograms[right_idx + 1]:
            left_idx -= 1
            current_height = histograms[left_idx]

        else:
            right_idx += 1
            current_height = histograms[right_idx]

        mid_height = min(current_height, mid_height)
        mid_width += 1
        mid_max = max(mid_max, mid_height * mid_width)

    return max(divide(left_area), divide(right_area), mid_max)

while True:
    case = list(map(int, sys.stdin.readline().split()))
    flag = case[0]
    histograms = case[1:]

    if not flag:
        break

    print(divide(histograms))