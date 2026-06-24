package main

import "fmt"

func main() {
    var s1 string
    var a int
    fmt.Scan(&s1, &a)
    
    for i := 1; i <= a ; i++ {
        fmt.Print(s1)
    }
    
}