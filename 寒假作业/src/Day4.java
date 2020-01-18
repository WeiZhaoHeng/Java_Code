

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2020/1/18
 * Time: 15:27
 */
public class Day4 {
    //最后一个单词的长度
    public static int lengthOfLastWord(String s) {
        String str = s.trim();
        if(str.length() == 0){
            return 0;
        }
        return str.length()-1-(str.lastIndexOf(" "));
    }

    //给定两个有序整数数组 nums1 和 nums2，
    // 将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int l = 0;
        int[] nums3 = new int[m];
        for(int k = 0;k < m;k++){
            nums3[k] = nums1[k];
        }
        while(i != m&&j != n){
            if(nums3[i] < nums2[j]){
                nums1[l] = nums3[i];
                i++;
            }else{
                nums1[l] = nums2[j];
                j++;
            }
            l++;
        }
        if(i == m){
            for(;l < m+n;l++){
                nums1[l] = nums2[j];
                j++;
            }
        }
        if(j == n){
            for(;l < m+n;l++){
                nums1[l] = nums3[i];
                i++;
            }
        }
    }
    public static int[] merge2(int[] nums1, int m, int[] nums2, int n){
        nums1 = Arrays.copyOf(nums1,m+n);
        int j = 0;
        for(int i = m;i < nums1.length;i++){
            nums1[i] = nums2[j++];
        }
        Arrays.sort(nums1);
        return nums1;
    }


    public static void main(String[] args) {

    }
}
