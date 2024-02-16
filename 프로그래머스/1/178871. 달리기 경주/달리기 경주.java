import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        Map<String, Integer> rank = new HashMap<>();
        
        for(int i=0; i<players.length; i++){
            rank.put(players[i], i);
        }
        
        for(String player : callings){
            int pRank = rank.get(player);
            
            String fPlayer = players[pRank-1];
            rank.replace(fPlayer, pRank);
            players[pRank] = fPlayer;
            
            rank.replace(player, pRank-1);
            players[pRank-1] = player;
        }
        
        return players;
    }
    
    
    
}