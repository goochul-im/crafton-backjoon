package main

import "fmt"

func main() {
    var a int
    fmt.Scan(&a)
    
    if a % 2 == 0 {
        fmt.Printf("%v is even", a)
    } else {
        fmt.Printf("%v is odd", a)
    }
    
}