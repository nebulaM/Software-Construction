import java.util.ArrayList;
import java.util.List;

public class Mutable{
	private List<Integer> mList;
	private final boolean deepCopy;
	public Mutable(boolean deepCopy, List<Integer> list){
        this.deepCopy=deepCopy;
		if(deepCopy){
			mList=new ArrayList<>();
			mList.addAll(list);
		}else{
			mList=list;
		}
    }

    public void modifyList(){
        if(mList!=null) {
            mList.add(234);
            mList.add(90);
			if(deepCopy){
				System.out.println("@modifyList: mList is modified but the original list is not modified");
			}
            System.out.println("@modifyList: mList is " + mList);
        }
    }
 }