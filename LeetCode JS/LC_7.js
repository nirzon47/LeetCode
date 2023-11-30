// https://leetcode.com/problems/reverse-integer/

/**
 * Reverses the digits of a given number.
 *
 * @param {number} x - The number to be reversed.
 * @return {number} The reversed number. If the reversed number is greater than
 *                  the maximum 32-bit signed integer or less than the minimum
 *                  32-bit signed integer, it returns 0.
 */
const reverse = (x) => {
	// Traditional approach
	let negative = false,
		reverse = 0
	let bit = Math.pow(2, 31) - 1

	if (x < 0) {
		negative = !negative
		x = x * -1
	}

	while (x > 0) {
		reverse = reverse * 10 + (x % 10)

		x = Number(x.toString().slice(0, -1))
	}
	// Can also do
	// reverse = parseInt(x.toString().split('').reverse().join(''))

	if (reverse > bit || reverse < -bit) {
		return 0
	}

	if (negative) {
		reverse *= -1
	}

	return reverse
}
