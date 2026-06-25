package main

import ("fmt"
        "unicode"
       )

func main() {
    var s1 string
    fmt.Scan(&s1)
    
    runes := []rune(s1)
    
    for i, r := range runes {
        if unicode.IsUpper(r){
            runes[i] = unicode.ToLower(r)
        } else if unicode.IsLower(r){
            runes[i] = unicode.ToUpper(r)
        }
    }
    
    fmt.Println(string(runes))
}