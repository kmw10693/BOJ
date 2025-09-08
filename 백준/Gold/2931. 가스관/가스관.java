import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int R, C;
    static char[][] map;

    static final int[] dx = {-1, 1, 0, 0};  // 상, 하, 좌, 우
    static final int[] dy = {0, 0, -1, 1};

    static final int TOP = 0, BOTTOM = 1, LEFT = 2, RIGHT = 3;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] input = in.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = in.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '.' && check(i, j)) {
                    return;
                }
            }
        }
    }

    private static boolean check(int x, int y) {
        boolean[] connected = new boolean[4];

        if (isValid(x + dx[TOP], y + dy[TOP]) && canComeBottom(map[x + dx[TOP]][y + dy[TOP]])) {
            connected[TOP] = true;
        }
        if (isValid(x + dx[BOTTOM], y + dy[BOTTOM]) && canComeTop(map[x + dx[BOTTOM]][y + dy[BOTTOM]])) {
            connected[BOTTOM] = true;
        }
        if (isValid(x + dx[LEFT], y + dy[LEFT]) && canComeRight(map[x + dx[LEFT]][y + dy[LEFT]])) {
            connected[LEFT] = true;
        }
        if (isValid(x + dx[RIGHT], y + dy[RIGHT]) && canComeLeft(map[x + dx[RIGHT]][y + dy[RIGHT]])) {
            connected[RIGHT] = true;
        }

        char correctPipe = findCorrectPipe(connected);
        if (correctPipe != '?') {
            System.out.println((x + 1) + " " + (y + 1) + " " + correctPipe);
            return true;
        }

        return false;
    }

    private static char findCorrectPipe(boolean[] connected) {
        if (connected[TOP] && connected[BOTTOM] && connected[LEFT] && connected[RIGHT]) return '+';
        if (connected[TOP] && connected[BOTTOM]) return '|';
        if (connected[LEFT] && connected[RIGHT]) return '-';
        if (connected[BOTTOM] && connected[RIGHT]) return '1';
        if (connected[TOP] && connected[RIGHT]) return '2';
        if (connected[TOP] && connected[LEFT]) return '3';
        if (connected[BOTTOM] && connected[LEFT]) return '4';
        return '?';
    }

    private static boolean canComeTop(char c) {
        return c == '|' || c == '+' || c == '2' || c == '3';
    }

    private static boolean canComeBottom(char c) {
        return c == '|' || c == '+' || c == '1' || c == '4';
    }

    private static boolean canComeLeft(char c) {
        return c == '-' || c == '+' || c == '3' || c == '4';
    }

    private static boolean canComeRight(char c) {
        return c == '-' || c == '+' || c == '1' || c == '2';
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
