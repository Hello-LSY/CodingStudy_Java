import java.io.*;
import java.util.*;

class Player implements Comparable<Player> {
    int level;
    String name;
    
    Player(int level, String name){
        this.level = level;
        this.name = name;
    }

    @Override
    public int compareTo(Player other) {
        return this.name.compareTo(other.name);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Player> players = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            players.add(new Player(level, name));
        }

        // 방 생성
        List<List<Player>> rooms = new ArrayList<>();
        for (Player player : players) {
            boolean placed = false;
            // 빈 방이 아닌 경우에만 실행
                // 레벨 플마 10 범위로 탐색
                for (List<Player> room : rooms) {
                    if (room.size() < m && Math.abs(room.get(0).level - player.level) <= 10) {
                        room.add(player);
                        placed = true;
                        break;
                    }
                
            }

            if (!placed) {
                // 새로운 방 생성
                List<Player> newRoom = new ArrayList<>();
                newRoom.add(player);
                rooms.add(newRoom);
            }
        }

        // 방 상태 출력
        for (List<Player> room : rooms) {
            // 플레이어들을 이름순으로 정렬
            Collections.sort(room);
            if (room.size() == m) {
                sb.append("Started!\n");
            } else {
                sb.append("Waiting!\n");
            }
            for (Player player : room) {
                sb.append(player.level).append(" ").append(player.name).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
