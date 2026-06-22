class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
       HashMap<Character , Integer> map = new HashMap<>();
       int n = s.length();
       int m = t.length();
       for(int i = 0; i < n; i++){
        char ch = s.charAt(i);
        if(!map.containsKey(ch)){
            map.put(ch , 0);
        }
        int freq = map.get(ch);
        map.put(ch , freq + 1);
        // System.out.print(map);
       }
       for(int i = 0; i < m; i++){
        char ch = t.charAt(i);
        if(!map.containsKey(ch)){
            return false;
        }
        map.put(ch , map.get(ch) - 1);
        // System.out.print(map);
        if(map.get(ch) < 0){
            return false;
        }
       }
       
       return true;
    }
}