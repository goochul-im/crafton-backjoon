func solution(str1 string, str2 string) string {
    result := ""
    
    for i := 0 ; i < len(str1) ; i++ {
        result += string(str1[i])
        result += string(str2[i])
    }
    
    return result
}