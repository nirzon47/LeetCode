// https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/

public class LC_1700 {
    public static int countStudents(int[] students, int[] sandwiches) {
        // Hashing the 0s and 1s
        int[] count = {0, 0};
        int fed = 0; // The number of students that have been fed

        for (int student : students) {
            count[student]++; // Hashing...
        }

        for (int sandwich : sandwiches) {
            // Decreasing the corresponding sandwich
            count[sandwich]--;

            // If at any point, the count for either 0 or 1 goes below 0,
            // we break because it's not possible to feed them anymore
            if (count[sandwich] < 0) {
                break;
            } else {
                // If it is above 0, we increase our count for fed students
                fed++;
            }
        }

        // Returning the missing count of students not fed
        return students.length - fed;
    }

    public static void main(String[] args) {
        int[] students = {1, 1, 0, 0}, sandwiches = {0, 1, 0, 1};

        System.out.println(countStudents(students, sandwiches));
    }
}
