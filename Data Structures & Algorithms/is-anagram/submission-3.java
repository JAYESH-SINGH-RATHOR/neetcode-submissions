class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int n = s.length();
        int m = t.length();
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch , 0);
            }
            int freq = map.get(ch);
            map.put(ch , freq + 1);
        }
        for(int i = 0; i < m; i++){
            char ch = t.charAt(i);
            if(!map.containsKey(ch)){
                return false;
            }
            int freq = map.get(ch);
            map.put(ch , freq - 1);
            if(map.get(ch) < 0){
                return false;
            }
        }
        return true;
    }
}