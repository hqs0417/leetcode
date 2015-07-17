package p165;

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] version1Arr = version1.split("\\.");
        String[] version2Arr = version2.split("\\.");
        int i = 0, j = 0;
        for(; i < version1Arr.length && j < version2Arr.length; i++, j++){
        	int a = Integer.parseInt(version1Arr[i]);
        	int b = Integer.parseInt(version2Arr[j]);
        	if(a < b) return -1;
        	if(a > b) return 1;
        	if(a == b) continue;
        }
        while(i < version1Arr.length) {
        	if(Integer.parseInt(version1Arr[i]) > 0){
        		return 1;
        	}
        	i++;
        }
        
        while(j < version2Arr.length) {
        	if(Integer.parseInt(version2Arr[j]) > 0) {
        		return -1;
        	}
        	j++;
        }
        return 0;
    }
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.compareVersion("1.0", "1.0.0.1"));
	}
}
