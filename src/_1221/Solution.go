package main

import "fmt"

func balancedStringSplit(s string) int {
	balance := 0
	result := 0
	for i := 0; i < len(s); i++ {
		if s[i] == 'L' {
			balance++
		} else {
			balance--
		}
		if balance == 0 {
			result++
		}
	}
	return result
}
func main() {
	fmt.Println(balancedStringSplit("LRRRRLLL"))
}
