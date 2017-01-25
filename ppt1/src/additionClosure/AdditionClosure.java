package additionClosure;

import java.util.Collections;
import java.util.List;

public class AdditionClosure {

	public static boolean isClosed(List<Integer> intList, Integer n) {
        if(intList==null || intList.size()==1){
            return true;
        }
        //Set is useful only when inList is huge
        //Set<Integer> intSet=new HashSet<>(intList);
        int max= Collections.max(intList);
        for(int i=0;i<intList.size();i++){
            for(int j=i+1;j<intList.size();j++){
                int k=0;
                boolean flag=false;
                while(k*n<=max){
                    int mod=(intList.get(i)+intList.get(j))%n;
                    /*if(intSet.contains((k*n+mod))){
                        flag=true;
                        break;
                    }*/
                    for(Integer x : intList){
                        if(x==k*n+mod){
                            flag=true;
                            break;
                        }
                    }
                    k++;
                }
                if(!flag){
                    return false;
                }
            }
        }
		return true;
	}
	
}
