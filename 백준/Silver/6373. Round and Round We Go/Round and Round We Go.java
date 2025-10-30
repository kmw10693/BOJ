import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    // 순환수 판별 함수
    static boolean isCyclic(String numStr) {
        int n = numStr.length();
        BigInteger original = new BigInteger(numStr);
        String doubleStr = numStr + numStr; // 회전 비교용

        for (int k = 1; k <= n; k++) {
            BigInteger multiplied = original.multiply(BigInteger.valueOf(k));

            // 앞자리 0을 유지하기 위해 zfill처럼 채워줌
            String resultStr = multiplied.toString();
            if (resultStr.length() < n) {
                resultStr = "0".repeat(n - resultStr.length()) + resultStr;
            }

            if (!doubleStr.contains(resultStr)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String numStr = sc.nextLine().trim();
            if (numStr.isEmpty()) continue;

            if (isCyclic(numStr)) {
                System.out.println(numStr + " is cyclic");
            } else {
                System.out.println(numStr + " is not cyclic");
            }
        }

        sc.close();
    }
}
