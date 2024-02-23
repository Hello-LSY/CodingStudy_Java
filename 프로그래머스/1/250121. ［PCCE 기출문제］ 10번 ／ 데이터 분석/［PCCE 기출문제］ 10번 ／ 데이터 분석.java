import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> dataList = new ArrayList<>();

        String[] idx = {"code", "date", "maximum", "remain"};
        int selectExt = 0;
        int selectSB = 0;
        for (int i = 0; i < idx.length; i++) {
            if (ext.equals(idx[i])) selectExt = i;
            if (sort_by.equals(idx[i])) selectSB = i;
        }

        // 데이터 필터 및 오름차순
        for (int[] arr : data) {
            if (arr[selectExt] < val_ext) {
                dataList.add(arr);
            }
        }

        final int copyOfSelectSB = selectSB; 
        dataList.sort(Comparator.comparingInt(arr -> arr[copyOfSelectSB]));

        return dataList.toArray(new int[dataList.size()][]);
    }
}
