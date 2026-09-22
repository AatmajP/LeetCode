class Solution {
    public int minSideJumps(int[] obstacles) {

        int INF = 1000000;

        // Lane 1 mein jaane ke liye starting mein 1 jump lagega
        // Lane 2 mein hum already start kar rahe hain, isliye 0 jump
        // Lane 3 mein jaane ke liye 1 jump lagega
        int[] dp = {1, 0, 1};

        for (int i = 1; i < obstacles.length; i++) {

            // Previous position ka DP copy kar rahe hain
            // Kyunki current position ke saare calculations
            // previous state ke basis par hone chahiye
            int[] next = dp.clone();

            // Jis lane mein obstacle hai, usse block
          
            if (obstacles[i] == 1) {
                next[0] = INF;       // Lane 1 blocked
            } else if (obstacles[i] == 2) {
                next[1] = INF;       // Lane 2 blocked
            } else if (obstacles[i] == 3) {
                next[2] = INF;       // Lane 3 blocked
            }

            // Available lanes mein sabse kam jumps find kar rahe hain
            int min = Math.min(next[0],
                    Math.min(next[1], next[2]));

            // Ab check karenge ki ek side jump karke
            // kisi lane mein aur kam cost mein pahunch sakte hain ya nahi
            for (int lane = 0; lane < 3; lane++) {

                // Agar is lane mein obstacle nahi hai
                if (obstacles[i] != lane + 1) {

                    // Side jump karne par 1 jump extra lagega
                    // Existing cost aur min + 1 mein se minimum lenge
                    next[lane] = Math.min(
                            next[lane],
                            min + 1
                    );
                }
            }

            // Current position ka result ab dp ban jayega
            dp = next;
        }

        // Destination par teen lanes mein se
        // jis lane mein minimum jumps hain, wahi answer hai
        return Math.min(dp[0],
                Math.min(dp[1], dp[2]));
    }
}