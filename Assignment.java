public class ProblemSolutions {
    
    // Easy: Am I Perfect?
    static String checkPerfectNumber(int num) {
        int sum = 1;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        if (sum == num) {
            return "Perfect";
        } else if (sum > num) {
            return "Abundant";
        } else {
            return "Deficient";
        }
    }

    // Easy: Shorten me!
    static String shortenString(String input) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        char prevChar = input.charAt(0);

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == prevChar) {
                count++;
            } else {
                result.append(count).append(prevChar);
                count = 1;
                prevChar = input.charAt(i);
            }
        }
        result.append(count).append(prevChar);
        return result.toString();
    }

    // Medium: How many trails to 1?
    static int numberOfStepsToOne(int x) {
        int steps = 0;
        while (x != 1) {
            if (x % 2 == 0) {
                x /= 2;
            } else {
                x = 3 * x + 1;
            }
            steps++;
        }
        return steps;
    }

    // Medium: Greater than and less than in a matrix
    static List<Integer> findSpecialValues(int[][] matrix) {
        List<Integer> specialValues = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int value = matrix[i][j];
                boolean isSpecial = true;

                for (int k = 0; k < rows; k++) {
                    if (matrix[k][j] < value) {
                        isSpecial = false;
                        break;
                    }
                }

                if (isSpecial) {
                    for (int l = 0; l < cols; l++) {
                        if (matrix[i][l] > value) {
                            isSpecial = false;
                            break;
                        }
                    }
                }

                if (isSpecial) {
                    specialValues.add(value);
                }
            }
        }
        return specialValues;
    }

    // Hard: Catch the fish
    static int fishesCaught(int k, int l, int m, int n, int total) {
        int fishesCaught = 0;

        for (int i = 1; i <= total; i++) {
            if (i % k == 0 || i % l == 0 || i % m == 0 || i % n == 0) {
                fishesCaught++;
            }
        }
        return fishesCaught;
    }

    // Hard: n-Chai
    static List<String> makeTea(int n, int k, int g, int b) {
        List<String> teaOrder = new ArrayList<>();
        char[] chaiTypes = new char[] { 'G', 'B' };
        int consecutiveCount = 0;
        int consecutiveLimit = k;

        while (n > 0) {
            for (char chai : chaiTypes) {
                if (chai == 'G' && g > 0) {
                    teaOrder.add("Green");
                    g--;
                    b--;
                    consecutiveCount = 0;
                    n--;
                } else if (chai == 'B' && b > 0 && consecutiveCount < consecutiveLimit) {
                    teaOrder.add("Black");
                    b--;
                    g--;
                    consecutiveCount++;
                    n--;
                }
            }
        }

        return teaOrder;
    }

    public static void main(String[] args) {
        // Easy problems
        System.out.println("Am I Perfect?");
        System.out.println("6: " + checkPerfectNumber(6));
        System.out.println("12: " + checkPerfectNumber(12));
        System.out.println("8: " + checkPerfectNumber(8));

        System.out.println("\nShorten me!");
        System.out.println("AAAAAAAAAAABWWWWWWWWWWWBB: " + shortenString("AAAAAAAAAAABWWWWWWWWWWWBB"));

        // Medium problems
        System.out.println("\nHow many trails to 1?");
        System.out.println("Steps for x=12: " + numberOfStepsToOne(12));

        System.out.println("\nGreater than and less than in a matrix");
        int[][] matrix = {
            { 7, 8, 7 },
            { 5, 4, 2 },
            { 8, 6, 7 }
        };
        System.out.println("Special values: " + findSpecialValues(matrix));

        // Hard problems
        System.out.println("\nCatch the fish");
        System.out.println("Fish caught for K=1, L=2, M=3, N=4, Total=12: " + fishesCaught(1, 2, 3, 4, 12));
        System.out.println("Fish caught for K=2, L=3, M=4, N=5, Total=24: " + fishesCaught(2, 3, 4, 5, 24));

        System.out.println("\nn-Chai");
        System.out.println("n=5, k=1, g=3, b=2: " + makeTea(5, 1, 3, 2));
        System.out.println("n=4, k=3, g=4, b=0: " + makeTea(4, 3, 4, 0));
    }
}
