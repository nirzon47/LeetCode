// https://leetcode.com/problems/rotate-array/

/**
 * Rotate the elements of an array to the right by a given number of steps.
 *
 * @param {Array} nums - The array of numbers to rotate.
 * @param {number} k - The number of steps to rotate the array.
 * @return {Array} The rotated array.
 */
const rotate = (nums, k) => {
	let n = nums.length
	k %= n

	reverse(nums, 0, n - 1)
	reverse(nums, 0, k - 1)
	reverse(nums, k, n - 1)

	return nums
}

/**
 * Reverses the elements of an array within a given range.
 *
 * @param {Array} nums - The array to be modified.
 * @param {number} l - The starting index of the range.
 * @param {number} r - The ending index of the range.
 */
const reverse = (nums, l, r) => {
	while (l < r) {
		let temp = nums[l]
		nums[l] = nums[r]
		nums[r] = temp

		r--
		l++
	}
}
