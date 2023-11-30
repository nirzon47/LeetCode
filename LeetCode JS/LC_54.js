// https://leetcode.com/problems/spiral-matrix/

/**
 * Generates the spiral order of a given matrix.
 *
 * @param {Array<Array<number>>} matrix - The matrix to generate the spiral order from.
 * @return {Array<number>} The spiral order of the matrix.
 */
const spiralOrder = (matrix) => {
	let l = 0,
		r = matrix[0].length - 1
	let t = 0,
		b = matrix.length - 1

	const res = []

	while (l <= r && t <= b) {
		for (let i = l; i <= r; i++) {
			res.push(matrix[t][i])
		}
		t++

		for (let i = t; i <= b; i++) {
			res.push(matrix[i][r])
		}
		r--

		if (t <= b) {
			for (let i = r; i >= l; i--) {
				res.push(matrix[b][i])
			}
		}
		b--

		if (l <= r) {
			for (let i = b; i >= t; i--) {
				res.push(matrix[i][l])
			}
		}
		l++
	}

	return res
}

console.log(
	spiralOrder([
		[1, 2, 3],
		[4, 5, 6],
		[7, 8, 9],
	])
)
