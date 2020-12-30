package main

import "fmt"

func restoreString(s string, indices []int) string {

	var len int = len(indices)
	result := make([]byte, len)
	var value int
	for i := 0; i < len; i++ {
		value = indices[i]
		result[value] = s[i]
	}
	return string(result[:])
}
func main() {
	indices := []int{4, 5, 6, 7, 0, 2, 1, 3}
	result := restoreString("codeleet", indices)
	fmt.Println(result)
}
