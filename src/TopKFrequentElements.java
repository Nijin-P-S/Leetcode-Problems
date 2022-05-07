import java.util.*;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        HashSet<Integer> hashset = new HashSet<>();
        ArrayList<Integer> array = new ArrayList<>();
        for(int val : nums)
        {
            hashset.add(val);
            if(hashmap.get(val)==null){
                hashmap.put(val,1);
            }
            else{
                hashmap.put(val, hashmap.get(val)+1);
            }
        }

        Iterator<Integer> it = hashset.iterator();

        while(it.hasNext()){
            if(hashmap.get(it.next()) == k)
                array.add(hashmap.get(it.next()));
        }
        int[] arr = array.stream().mapToInt(i -> i).toArray();
        return arr;
    }

    public static void main(String[] args) {
        int array[] = {1,1,1,2,2,3};
        int result[] = topKFrequent(array , 2);
        for(int val : result)
            System.out.println(val);
    }
}
