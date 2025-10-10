import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] maps;
    static int K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        maps = new char[4][8];

        for(int i=0; i<4; i++) {
            maps[i] = br.readLine().toCharArray();
        }
        K = Integer.parseInt(br.readLine());

        for(int i=0; i<K; i++) {
            int num, dir;
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            dir = Integer.parseInt(st.nextToken());

            // N극은 0, S는 1
            switch (num) {
                case 4:
                    // 일단 4번 시계 방향으로 돌리는 경우
                    if (dir == 1) {
                        // 4번과 3번이 다른 경우
                        if (maps[2][2] != maps[3][6]) {
                            // 삼번과 2번이 다른 경우
                            if (maps[1][2] != maps[2][6]) {
                                // 2번과 1번이 다른 경우
                                if (maps[0][2] != maps[1][6]) {
                                    // 일번 시계, 이번 반시계, 삼번 시계, 사번 반시계 시계는 1번, 반시계는 0임
                                    move(1, 0);
                                    move(2, 1);
                                    move(3, 0);
                                    move(4, 1);
                                }
                                // 일번과 이번이 같은 경우
                                else {
                                    move(2, 1);
                                    move(3, 0);
                                    move(4, 1);
                                }
                            }
                            // 2번과 3번이 같은 경우
                            else {
                                move(3, 0);
                                move(4, 1);
                            }
                        }
                        // 일번과 이번이 같은 경우는 일번만 옮기면 됨
                        else {
                            move(4, 1);
                        }
                    }
                    // 반 시계로 돌리는 경우
                    else {
                        // 4번과 3번이 다른 경우
                        if (maps[2][2] != maps[3][6]) {
                            // 삼번과 2번이 다른 경우
                            if (maps[1][2] != maps[2][6]) {
                                // 2번과 1번이 다른 경우
                                if (maps[0][2] != maps[1][6]) {
                                    // 일번 시계, 이번 반시계, 삼번 시계, 사번 반시계 시계는 1번, 반시계는 0임
                                    move(1, 1);
                                    move(2, 0);
                                    move(3, 1);
                                    move(4, 0);
                                }
                                // 일번과 이번이 같은 경우
                                else {
                                    move(2, 0);
                                    move(3, 1);
                                    move(4, 0);
                                }
                            }
                            // 2번과 3번이 같은 경우
                            else {
                                move(3, 1);
                                move(4, 0);
                            }
                        }
                        // 일번과 이번이 같은 경우는 일번만 옮기면 됨
                        else {
                            move(4, 0);
                        }
                    }
                    break;
                case 3:
                    // 일단 일번 시계 방향으로 돌리는 경우
                    if (dir == 1) {
                        boolean id = true;

                        // 3번과 4번이 다른 경우
                        if (maps[2][2] != maps[3][6]) {
                            // 이건 독립 시행
                            id = false;
                        }
                        // 3번과 4번이 같은 경우는 패스

                        // 3번과 2번이 다른 경우
                        if (maps[1][2] != maps[2][6]) {
                            // 1번과 2번이 다른 경우
                            if (maps[0][2] != maps[1][6]) {
                                // 4번이 같으면 패스
                                if (id) {
                                    move(1, 1);
                                    move(2, 0);
                                    move(3, 1);
                                } else {
                                    move(1, 1);
                                    move(2, 0);
                                    move(3, 1);
                                    move(4, 0);
                                }
                            }
                            // 1번과 2번이 같은 경우
                            else {
                                if (id) {
                                    // 3번, 2번만 돌리면 됨
                                    move(2, 0);
                                    move(3, 1);
                                } else {
                                    move(2, 0);
                                    move(3, 1);
                                    move(4, 0);
                                }
                            }
                        }
                        // 2번과 3번이 같은 경우
                        else {
                            if (id) {
                                // 3번 돌리기
                                move(3, 1);
                            } else {
                                move(3, 1);
                                move(4, 0);
                            }
                        }
                    }
                    // 반 시계로 돌리는 경우
                    else {
                        boolean id = true;

                        // 3번과 4번이 다른 경우
                        if (maps[2][2] != maps[3][6]) {
                            // 이건 독립 시행
                            id = false;
                        }
                        // 3번과 4번이 같은 경우는 패스

                        // 3번과 2번이 다른 경우
                        if (maps[1][2] != maps[2][6]) {
                            // 1번과 2번이 다른 경우
                            if (maps[0][2] != maps[1][6]) {
                                // 4번이 같으면 패스
                                if (id) {
                                    move(1, 0);
                                    move(2, 1);
                                    move(3, 0);
                                } else {
                                    move(1, 0);
                                    move(2, 1);
                                    move(3, 0);
                                    move(4, 1);
                                }
                            }
                            // 1번과 2번이 같은 경우
                            else {
                                if (id) {
                                    // 3번, 2번만 돌리면 됨
                                    move(2, 1);
                                    move(3, 0);
                                } else {
                                    move(2, 1);
                                    move(3, 0);
                                    move(4, 1);
                                }
                            }
                        }
                        // 2번과 3번이 같은 경우
                        else {
                            if (id) {
                                // 3번 돌리기
                                move(3, 0);
                            } else {
                                move(3, 0);
                                move(4, 1);
                            }
                        }
                    }
                    break;
                case 2:
                    // 일단 일번 시계 방향으로 돌리는 경우
                    if (dir == 1) {
                        boolean id = true;

                        // 1번과 2번이 다른 경우
                        if (maps[0][2] != maps[1][6]) {
                            // 이건 독립 시행
                            id = false;
                        }
                        // 1번과 2번이 같은 경우는 패스

                        // 2번과 3번이 다른 경우
                        if (maps[1][2] != maps[2][6]) {
                            // 3번과 4번이 다른 경우
                            if (maps[2][2] != maps[3][6]) {
                                // 1번이 같으면 패스
                                if (id) {
                                    move(2, 1);
                                    move(3, 0);
                                    move(4, 1);
                                } else {
                                    move(1, 0);
                                    move(2, 1);
                                    move(3, 0);
                                    move(4, 1);
                                }
                            }
                            // 3번과 4번이 같은 경우
                            else {
                                if (id) {
                                    // 2번, 3번만 돌리면 됨
                                    move(2, 1);
                                    move(3, 0);
                                } else {
                                    move(1, 0);
                                    move(2, 1);
                                    move(3, 0);
                                }
                            }
                        }
                        // 2번과 3번이 같은 경우
                        else {
                            if (id) {
                                // 2번 돌리기
                                move(2, 1);
                            } else {
                                move(2, 1);
                                move(1, 0);
                            }
                        }
                    }
                    // 반 시계로 돌리는 경우
                    else {
                        boolean id = true;

                        // 1번과 2번이 다른 경우
                        if (maps[0][2] != maps[1][6]) {
                            // 이건 독립 시행
                            id = false;
                        }
                        // 1번과 2번이 같은 경우는 패스

                        // 2번과 3번이 다른 경우
                        if (maps[1][2] != maps[2][6]) {
                            // 3번과 4번이 다른 경우
                            if (maps[2][2] != maps[3][6]) {
                                // 1번이 같으면 패스
                                if (id) {
                                    move(2, 0);
                                    move(3, 1);
                                    move(4, 0);
                                } else {
                                    move(1, 1);
                                    move(2, 0);
                                    move(3, 1);
                                    move(4, 0);
                                }
                            }
                            // 3번과 4번이 같은 경우
                            else {
                                if (id) {
                                    // 2번, 3번만 돌리면 됨
                                    move(2, 0);
                                    move(3, 1);
                                } else {
                                    move(1, 1);
                                    move(2, 0);
                                    move(3, 1);
                                }
                            }
                        }
                        // 2번과 3번이 같은 경우
                        else {
                            if (id) {
                                // 2번 돌리기
                                move(2, 0);
                            } else {
                                move(2, 0);
                                move(1, 1);
                            }
                        }
                    }
                    break;
                case 1:
                    // 일단 일번 시계 방향으로 돌리는 경우
                    if (dir == 1) {
                        // 일번과 이번이 다른 경우
                        if (maps[0][2] != maps[1][6]) {
                            // 이번이 삼번과 다른 경우
                            if (maps[1][2] != maps[2][6]) {
                                if (maps[2][2] != maps[3][6]) {
                                    // 일번 시계, 이번 반시계, 삼번 시계, 사번 반시계 시계는 1번, 반시계는 0임
                                    move(1, 1);
                                    move(2, 0);
                                    move(3, 1);
                                    move(4, 0);
                                }
                                // 삼번과 사번이 같은 경우
                                else {
                                    move(1, 1);
                                    move(2, 0);
                                    move(3, 1);
                                }
                            }
                            // 이번이 삼번과 같은 경우
                            else {
                                move(1, 1);
                                move(2, 0);
                            }
                        }
                        // 일번과 이번이 같은 경우는 일번만 옮기면 됨
                        else {
                            move(1, 1);
                        }
                    }
                    // 반 시계로 돌리는 경우
                    else {
                        // 일번과 이번이 다른 경우
                        if (maps[0][2] != maps[1][6]) {
                            // 이번이 삼번과 다른 경우
                            if (maps[1][2] != maps[2][6]) {
                                if (maps[2][2] != maps[3][6]) {
                                    // 일번 시계, 이번 반시계, 삼번 시계, 사번 반시계 시계는 1번, 반시계는 0임
                                    move(1, 0);
                                    move(2, 1);
                                    move(3, 0);
                                    move(4, 1);
                                }
                                // 삼번과 사번이 같은 경우
                                else {
                                    move(1, 0);
                                    move(2, 1);
                                    move(3, 0);
                                }
                            }
                            // 이번이 삼번과 같은 경우
                            else {
                                move(1, 0);
                                move(2, 1);
                            }
                        }
                        // 일번과 이번이 같은 경우는 일번만 옮기면 됨
                        else {
                            move(1, 0);
                        }
                    }
                    break;
                default:
                    break;
            }

        }
        int sum = 0;
        if (maps[0][0] == '1') sum += 1;
        if (maps[1][0] == '1') sum += 2;
        if (maps[2][0] == '1') sum += 4;
        if (maps[3][0] == '1') sum += 8;

        System.out.println(sum);
    }
    public static void move(int index, int dir) {
        // 반시계
        if(dir == 0) {
            // 10101111
            // 01011111
            char tmp = maps[index-1][0];
            for(int j=0; j<7; j++) {
                maps[index-1][j] = maps[index-1][j+1];
            }
            maps[index-1][7] = tmp;
        }
        // 시계
        else {
            char tmp = maps[index-1][7];
            for(int j=7; j>0; j--) {
                maps[index-1][j] = maps[index-1][j-1];
            }
            maps[index-1][0] = tmp;
        }
    }
}