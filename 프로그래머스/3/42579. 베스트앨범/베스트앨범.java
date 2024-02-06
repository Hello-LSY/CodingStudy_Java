import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genresCnt = new HashMap<>();
        Map<String, PriorityQueue<int[]>> genresList = new HashMap<>();

        // 장르별 재생횟수 총합과 노래 정보 저장
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genresCnt.put(genre, genresCnt.getOrDefault(genre, 0) + play);
            genresList.computeIfAbsent(genre, k -> new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]))
                      .add(new int[]{i, play});
        }

        // 장르별 재생횟수를 내림차순으로 정렬
        List<String> sortedGenres = new ArrayList<>(genresCnt.keySet());
        sortedGenres.sort((genre1, genre2) -> genresCnt.get(genre2) - genresCnt.get(genre1));

        // 장르별로 노래 정보를 가져와 answerList에 추가
        List<Integer> answerList = new ArrayList<>();
        for (String genre : sortedGenres) {
            PriorityQueue<int[]> genreSongs = genresList.get(genre);

            for (int i = 0; i < 2 && !genreSongs.isEmpty(); i++) {
                answerList.add(genreSongs.poll()[0]);
            }
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
