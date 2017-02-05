public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        int len = nums.length;
        if (len < 4)
            return new ArrayList<List<Integer>>();
            
        // the hashmap is a multi value map. i.e. for each key we store many values
        HashMap<Integer, List<int[]>> hm = new HashMap<Integer, List<int[]>>();
        
        // keep the correct solutions in a hashset to avoid duplicates
        HashSet<List<Integer>> hs = new HashSet<>();
        
        for (int i = 0; i < len; i++ ){
            for(int j = i+1; j < len; j++){
                
                int sum = nums[i] + nums[j];
                int lookFor = target - sum;
                
                if(hm.containsKey(lookFor)){
                    List<int[]> values = hm.get(lookFor);
                   
                    for(int[] sol : values){
                        int i_prev = sol[0];
                        int j_prev = sol[1];
                        if(i_prev != i && j_prev != i && j_prev != j ){
                            List<Integer> l = new ArrayList<Integer>();
                            l.add(nums[i_prev]);
                            l.add(nums[j_prev]);
                            l.add(nums[i]);
                            l.add(nums[j]);
                            Collections.sort(l);
                            hs.add(l);
                        }
                    }
                }
                
                hm.computeIfAbsent(sum, key -> new ArrayList<>()).add(new int[] {i, j});
            }
        }
        return new ArrayList<List<Integer>>(hs);
    }
    
}
