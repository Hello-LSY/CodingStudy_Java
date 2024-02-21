class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] student = new int[n]; // 학생들의 체육복 상태

        // 도난당한 학생은 -1, 여벌의 체육복이 있는 학생은 1로 초기화
        for (int i = 0; i < lost.length; i++) {
            student[lost[i] - 1]--;
        }
        for (int i = 0; i < reserve.length; i++) {
            student[reserve[i] - 1]++;
        }

        // 체육복 빌려주기
        for (int i = 0; i < student.length; i++) {
            // 체육복이 없는 학생일 경우
            if (student[i] == -1) { 
                // 앞 번호 학생이 여벌의 체육복이 있는 경우
                if (i - 1 >= 0 && student[i - 1] == 1) { 
                    student[i - 1]--;
                    student[i]++;
                // 뒷 번호 학생이 여벌의 체육복이 있는 경우
                } else if (i + 1 < student.length && student[i + 1] == 1) { 
                    student[i + 1]--;
                    student[i]++;
                }
            }
        }

        // 수업을 들을 수 있는 학생의 수 계산
        for (int i : student) {
            if (i >= 0) answer++;
        }

        return answer;
    }
}
