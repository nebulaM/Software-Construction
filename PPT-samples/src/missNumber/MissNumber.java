import java.util.List;

class MissNumber {
    static int findMissNumber(List<Integer> array){
        if(array==null){
            return -1;
        }
        return findMissNumberHelper(array,0,array.size()-1);
    }
    private static int findMissNumberHelper(List<Integer> array, int lo, int hi){
        if(lo>hi){
            return -1;
        }
        if(lo==hi){
            return (array.get(hi)==(array.get(hi-1)+1))?-1:array.get(hi-1)+1;
        }
        int mid=(lo+hi)>>1;

        if(array.get(mid)-array.get(lo)==mid-lo){
            if(findMissNumberHelper(array,mid+1,hi)!=-1) {
                return findMissNumberHelper(array, mid + 1, hi);
            }
        }else{
            if(mid-lo==1){
                return array.get(mid)-1;
            }
        }
        if(array.get(hi)-array.get(mid)==hi-mid){
            if(findMissNumberHelper(array,lo,mid-1)!=-1)
            return findMissNumberHelper(array,lo,mid-1);
        }else {
            if(hi-mid==1){
                return array.get(mid)+1;
            }
        }
        return -1;
    }
}
