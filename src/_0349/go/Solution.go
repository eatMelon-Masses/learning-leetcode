package main

import "fmt"

func intersection(nums1 []int, nums2 []int) []int {
	var container map[int]bool
	result := make([]int, 0)
	container = make(map[int]bool)
	for i := 0; i < len(nums1); i++ {
		container[nums1[i]] = true
	}
	for j := 0; j < len(nums2); j++ {
		temp := container[nums2[j]]
		if temp {
			result = append(result, nums2[j])
			container[nums2[j]] = false
		}
	}
	return result
}
func main() {
	fmt.Println(intersection([]int{1, 2, 2, 3}, []int{2, 2, 3}))
}
