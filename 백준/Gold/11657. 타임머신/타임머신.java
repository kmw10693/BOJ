import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class City {
    int end;
    int weight;

    public City(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class Main {

    private static int N, M;
    private static ArrayList<ArrayList<City>> arr;
    private static long[] dist;
    private static int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            arr.add(new ArrayList<>());
        }

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int a, b, c;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            arr.get(a).add(new City(b, c));
        }
        StringBuilder sb = new StringBuilder();

        if(ballmanFord()) {
            sb.append("-1");
        } else {
            for(int j=2; j<=N; j++) {
                if(dist[j] == INF) {
                    sb.append("-1\n");
                } else {
                    sb.append(dist[j] + "\n");
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean ballmanFord() {
       dist = new long[N+1];

       for(int i=0; i<=N; i++) {
           dist[i] = INF;
       }

       dist[1] = 0;
       boolean check = false;

       for(int i=1; i<N; i++) {
           check = false;
           for(int j=1; j<=N; j++) {
               for(City city : arr.get(j)) {
                   if(dist[j] == INF) break;
                   if(dist[city.end] > dist[j] + city.weight) {
                       check = true;
                       dist[city.end] = dist[j] + city.weight;
                   }
               }
           }
           if(!check) break;
       }

       if(check) {
           for(int i=1; i<=N; i++) {
               for(City city : arr.get(i)) {
                   if(dist[i] == INF) break;
                   if(dist[city.end] > dist[i] + city.weight) {
                       return true;
                   }
               }
           }
       }
       return false;
    }
}