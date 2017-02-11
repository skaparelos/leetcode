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
        
        ArrayList<int[]> freq = new ArrayList<int[]>();
        for (int key : hm.keySet()) {
            freq.add(new int[] {hm.get(key), key});
        }
        Collections.sort(freq, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return  b[0] - a[0];
            }
        });
        
        /*for(int i =0; i < freq.size(); i++){
            System.out.println(freq.get(i)[1] + ", times-> " + freq.get(i)[0]);
        }*/
        
        ArrayList<Integer> ret = new ArrayList<>();
        for(int i = 0; i < k; i++)
            ret.add(freq.get(i)[1]);
            
        return ret;
            
    }
}
