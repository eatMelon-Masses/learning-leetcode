package main

import (
	"fmt"
)

func maxSubArray(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	result := nums[0]
	sum := 0
	for i := 0; i < len(nums); i++ {
		sum = sum + nums[i]
		if sum > result {
			result = sum
		}
		if sum < 0 {
			sum = 0
		}

	}
	return result
}
func main() {
	fmt.Println(maxSubArray([]int{-2, 1, -3, 4, -1, 2, 1, -5, 4}))
}
