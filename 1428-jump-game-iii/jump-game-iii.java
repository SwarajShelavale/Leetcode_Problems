class Solution {

    static boolean helper(int arr[], int idx){

        Queue<Integer> q = new LinkedList<>();
        q.add(idx);

        HashSet<Integer> hp = new HashSet<>();

        while(q.size()!=0){
            int a = q.remove();
            if(a>=arr.length || a<0) continue;
            if(arr[a]==0) return true;
            if(!hp.contains(a-arr[a])){
                q.add(a-arr[a]);
                hp.add(a-arr[a]);
            }

            if(!hp.contains(a+arr[a])){
                q.add(a+arr[a]);
                hp.add(a+arr[a]);
            }
        }
        return false;
    }
    public boolean canReach(int[] arr, int start) {
        return helper(arr,start);
    }
}