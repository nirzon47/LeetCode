// https://leetcode.com/problems/sort-characters-by-frequency/

/**
 * Sorts the characters in a string based on their frequency.
 *
 * @param {string} s - The input string to be sorted.
 * @return {string} - The sorted string based on frequency of characters.
 */
const frequencySort = function (s) {
	let map = new Map()
	let res = ''

	for (const c of s) {
		map.set(c, (map.get(c) || 0) + 1)
	}

	map = new Map([...map.entries()].sort((o1, o2) => o2[1] - o1[1]))

	for (let [i, j] of map) {
		res += i.repeat(j)
	}

	return res
}

console.log(frequencySort('tree'))
