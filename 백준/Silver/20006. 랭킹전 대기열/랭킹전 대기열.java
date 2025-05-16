import java.io.*;
import java.util.*;


class Team {
    List<Member> members;

    public Team(List<Member> members) {
        this.members = members;
    }

    public int getLevel() {
        return members.get(0).level;
    }

    public int getSize() {
        return members.size();
    }
}

class Member {
    int level;
    String nickname;

    public Member(int level, String nickname) {
        this.level = level;
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public int getLevel() {
        return level;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Team> queue = new ArrayList<>();

        // 첫 주자 첫번째 팀에 넣기
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        Member first = new Member(Integer.parseInt(st1.nextToken()), st1.nextToken());
        queue.add(new Team(new ArrayList<>(List.of(first))));

        for (int i = 1; i < p; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            // 임시 멤버
            Member temp = new Member(Integer.parseInt(st2.nextToken()), st2.nextToken());

            boolean flag = false;
            for(int j=0; j<queue.size(); j++) {
                Team team = queue.get(j);
                if(team.getLevel() + 10 >= temp.level && team.getLevel() - 10 <= temp.level && team.getSize() < m) {
                    queue.get(j).members.add(temp);
                    flag = true;
                    break;
                }
            }

            if(!flag) queue.add(new Team(new ArrayList<>(List.of(temp))));
        }
        for(int i=0; i<queue.size(); i++) {
            Team team = queue.get(i);
            if(team.getSize() == m) {
                System.out.println("Started!");
            }
            else System.out.println("Waiting!");
            team.members.stream().sorted(Comparator.comparing(Member::getNickname))
                    .forEach(member -> System.out.println(member.getLevel() + " " + member.getNickname()));
        }

    }
}