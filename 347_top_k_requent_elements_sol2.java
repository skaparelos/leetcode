/*
O(n) time
O(n) space
*/
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // key is the number, value is the frequency
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int len = nums.length;
        for(int i = 0; i < len; i++){
            int key = nums[i];
            if(!hm.containsKey(key))
                hm.put(key, 1);
            else{
                int freq = hm.get(key);
                //overwrite existing freq
                hm.put(key, freq+1);
            }
        }
        
        List<Integer>[] ar = new List[len+1];
        for(int key: hm.keySet()){
            int freq = hm.get(key);
            if(ar[freq] == null)
                ar[freq] = new ArrayList<Integer>();
            ar[freq].add(key);
        }

        ArrayList<Integer> ret = new ArrayList<Integer>();
        int added = 0;
        for(int i = len; i > 0; i--){
            List<Integer> a = ar[i];
            if(a != null){
                for(int j: a){
                    if(added == k)
                        break;
                    ret.add(j);
                    added++;
                }
            }
        }
    
        return ret;
    }
}
