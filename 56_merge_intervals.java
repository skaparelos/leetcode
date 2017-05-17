/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        int len = intervals.size();
        if (len == 0) return intervals;
        
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        
        int i = 0;
        while(i < intervals.size() - 1){
            Interval cur = intervals.get(i);
            Interval next = intervals.get(i + 1);
            if (cur.end >= next.start){
                cur.end = Math.max(cur.end, next.end);
                intervals.remove(i+1);
            }else{
                i++;
            }
            
        }
        
        /*for (i = 0; i < intervals.size(); i++){
            Interval cur = intervals.get(i);
            System.out.println("[" + cur.start + ", " + cur.end + "]");
        }*/
       
        return intervals;
        
    }
    
}
