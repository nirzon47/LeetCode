/**
 * Check if a given number is a palindrome.
 *
 * @param {number} x - The number to be checked.
 * @return {boolean} True if the number is a palindrome, false otherwise.
 */
const isPalindrome = (x) => {
	if (x < 0) {
		return false
	}

	if (x === reverseNumber(x)) {
		return true
	}

	return false
}

/**
 * Reverses a given number.
 *
 * @param {number} x - The number to be reversed.
 * @return {number} The reversed number.
 */
const reverseNumber = (x) => {
	let n = 0

	while (x > 0) {
		n = n * 10 + (x % 10)

		x = Number(x.toString().slice(0, -1))
	}

	return n
}

console.log(isPalindrome(121))
