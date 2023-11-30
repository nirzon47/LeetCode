// https://leetcode.com/problems/asteroid-collision/

/**
 * Takes an array of asteroids and performs collision checks to remove any colliding asteroids.
 *
 * @param {Array} asteroids - An array of numbers representing the size of each asteroid. Positive numbers indicate asteroids
 * moving to the right, while negative numbers indicate asteroids moving to the left.
 * @return {Array} stack - An array containing the remaining asteroids after collision checks.
 */
const asteroidCollision = (asteroids) => {
	const stack = []
	let i = 0

	while (i < asteroids.length) {
		if (stack.length === 0) {
			stack.push(asteroids[i])
			i++
		} else {
			const prev = stack[stack.length - 1]
			const curr = Math.abs(asteroids[i])

			if (prev > 0 && asteroids[i] < 0) {
				if (prev === curr) {
					stack.pop()
					i++
				} else if (prev > curr) {
					i++
				} else {
					stack.pop()
				}
			} else {
				stack.push(asteroids[i])
				i++
			}
		}
	}

	return stack
}

console.log(asteroidCollision([8, -8]))
