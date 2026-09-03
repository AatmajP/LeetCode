
import java.util.*;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        Queue<Integer> q = new LinkedList<>();

        // Put all students into the queue
        for (int student : students) {
            q.offer(student);
        }

        // Process each sandwich
        for (int sandwich : sandwiches) {

            int rotations = 0;

            // Move students who don't want this sandwich
            while (q.peek() != sandwich) {

                q.offer(q.poll());
                rotations++;

                // Nobody wants this sandwich
                if (rotations == q.size()) {
                    return q.size();
                }
            }

            // Student takes the sandwich
            q.poll();
        }

        return q.size();
    }
}