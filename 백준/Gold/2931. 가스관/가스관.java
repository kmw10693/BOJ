import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n,m;
    private static char[][] map;

    // 위 아래 왼 오른
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        for(int i=0; i<n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == '.' && ischeck(i, j)) return;
            }
        }

    }

    private static boolean ischeck(int x, int y) {
        boolean top = false;
        boolean bottom = false;
        boolean left = false;
        boolean right = false;

        if(isValid(x + dx[0], y+dy[0]) && goBottom(x+dx[0],y+dy[0])) top = true;
        if(isValid(x + dx[1], y+dy[1]) && goTop(x+dx[1], y+dy[1])) bottom = true;
        if(isValid(x + dx[2], y+dy[2]) && goRight(x+dx[2], y+dy[2])) left = true;
        if(isValid(x + dx[3], y+dy[3]) && goLeft(x+dx[3], y+dy[3])) right  = true;

        StringBuilder sb = new StringBuilder();
        x+=1;
        y+=1;

        if(left && right && bottom && top) {
            sb.append(x + " " + y + " " + "+");
            System.out.println(sb.toString());
            return true;
        }
        else if(top && bottom) {
            sb.append(x + " " + y + " " + "|");
            System.out.println(sb.toString());
            return true;
        }
        else if(left && right) {
            sb.append(x + " " + y + " " + "-");
            System.out.println(sb.toString());
            return true;
        }
        else if(bottom && right) {
            sb.append(x + " " + y + " " + "1");
            System.out.println(sb.toString());
            return true;
        }
        else if(top && right) {
            sb.append(x + " " + y + " " + "2");
            System.out.println(sb.toString());
            return true;
        }
        else if(left && top) {
            sb.append(x + " " + y + " " + "3");
            System.out.println(sb.toString());
            return true;
        }
        else if(left && bottom) {
            sb.append(x + " " + y + " " + "4");
            System.out.println(sb.toString());
            return true;
        }
        return false;
    }
    private static boolean isValid(int x, int y) {
        return (x>=0 && x<n && y>=0 && y<m);
    }

    private static boolean goBottom(int x, int y) {
        if(map[x][y] == '|' || map[x][y] == '+' || map[x][y] == '1' || map[x][y] == '4') return true;
        return false;
    }

    private static boolean goTop(int x, int y) {
        if(map[x][y] == '|' || map[x][y] == '+' || map[x][y] == '2' || map[x][y] == '3') return true;
        return false;
    }

    private static boolean goRight(int x, int y) {
        if(map[x][y] == '-' || map[x][y] == '+' || map[x][y] == '1' || map[x][y] == '2') return true;
        return false;
    }

    private static boolean goLeft(int x, int y) {
        if(map[x][y] == '-' || map[x][y] == '+' || map[x][y] == '3' || map[x][y] == '4') return true;
        return false;
    }
}