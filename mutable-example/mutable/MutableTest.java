import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MutableTest {
	@Test
    public void test1(){
        List<Integer> testList=new ArrayList<>();
        for(int i=0;i<10;i++){
            testList.add(i);
        }
        Mutable mTestObj=new Mutable(true, testList);
        mTestObj.modifyList();
        System.out.println("@test1: testList is "+testList);
        System.out.println();

    }

    @Test
    public void test2(){
        List<Integer> testList=new ArrayList<>();
        for(int i=0;i<10;i++){
            testList.add(i);
        }
        Mutable mTestObj=new Mutable(false, testList);
        mTestObj.modifyList();
        System.out.println("@test2: testList is "+testList);
        System.out.println();

    }
}