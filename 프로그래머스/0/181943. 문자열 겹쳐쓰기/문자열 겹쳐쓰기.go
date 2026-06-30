func solution(my_string string, overwrite_string string, s int) string {
    
    head := my_string[:s]
    tail := my_string[s + len(overwrite_string):]
    
    return head + overwrite_string + tail
}