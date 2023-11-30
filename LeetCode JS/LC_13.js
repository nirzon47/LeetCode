// https://leetcode.com/problems/roman-to-integer/

/**
 * Converts a Roman numeral string to an integer value.
 *
 * @param {string} s - The Roman numeral string to be converted.
 * @return {number} - The integer value of the Roman numeral.
 */
const romanToInt = (s) => {
	let prev = 0,
		res = 0
	for (let i = s.length - 1; i >= 0; i--) {
		let n = getNumber(s[i])

		if (prev > n) {
			res -= n
		} else {
			res += n
		}

		prev = n
	}

	return res
}

/**
 * Returns the corresponding number for a given Roman numeral.
 *
 * @param {string} ch - The Roman numeral character to convert.
 * @return {number} The corresponding decimal number.
 */
const getNumber = (ch) => {
	switch (ch) {
		case 'I':
			return 1
		case 'V':
			return 5
		case 'X':
			return 10
		case 'L':
			return 50
		case 'C':
			return 100
		case 'D':
			return 500
		case 'M':
			return 1000
	}
}

console.log(romanToInt('III'))
