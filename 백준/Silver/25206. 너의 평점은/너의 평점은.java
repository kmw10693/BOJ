import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        double totalScore = 0;
        double Cscore = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            if (line.isEmpty()) continue; // 빈 줄 처리

            StringTokenizer st = new StringTokenizer(line, " ");
            String subject = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (grade.equals("P")) continue;

            Cscore += score;

            switch (grade) {
                case "A+": totalScore += score * 4.5; break;
                case "A0": totalScore += score * 4.0; break;
                case "B+": totalScore += score * 3.5; break;
                case "B0": totalScore += score * 3.0; break;
                case "C+": totalScore += score * 2.5; break;
                case "C0": totalScore += score * 2.0; break;
                case "D+": totalScore += score * 1.5; break;
                case "D0": totalScore += score * 1.0; break;
                case "F": break;
            }
        }

        System.out.println(totalScore / Cscore);
    }
}
