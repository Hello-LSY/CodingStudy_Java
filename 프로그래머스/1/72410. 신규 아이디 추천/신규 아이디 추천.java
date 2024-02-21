class Solution {
    public String solution(String new_id) {

        //1단계 소문자치환
        new_id = new_id.toLowerCase();
        //2단계 정규표현식으로 a~z 0~9 -, _, . 제외한 모든문자 제거 앞에 [^문자]는 not의 의미 
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        //3단계 정규표현식으로 .이 2번이상 반복한다면 하나로 치환 {반복이 몇 이상,몇 이하 인지} 뒤에꺼 빼면 몇 이상~ 의미 특문은 \\붙여야함 
        new_id = new_id.replaceAll("\\.{2,}", ".");
        //4단계 정규표현식으로 .이 처음이나 끝에 위치하면 제거 ^은 처음 $은 끝을 의미 
        new_id = new_id.replaceAll("^\\.|\\.$", "");
        //5단계 빈 문자열이면 a 대입
        if(new_id.isEmpty()) new_id="a";
        //6단계 16자 이상인경우 자르기
        if(new_id.length()>=16) new_id = new_id.substring(0,15);
        //만약 제거 후 .이 끝에있으면 제거
        if(new_id.endsWith(".")) new_id = new_id.substring(0, new_id.length()-1);
        //7단계 2자 이하면 3자가 될때까지 마지막 문자 반복
        if(new_id.length()<=2)
            while(new_id.length()!=3)
                new_id+=new_id.charAt(new_id.length()-1);
        
        return new_id;
    }
}