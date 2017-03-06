package schedulers;

import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SchedulersTest {
    @Test
    public void testSRPT_1(){
        SRPT mSRPT=new SRPT();
        for(int i=1;i<=20;i++){
            mSRPT.addTask(new Task(i,i+30));
        }
        while(!mSRPT.isEmpty()) {
            mSRPT.tick();

        }
    }

    @Test
    public void testSRPT_2(){
        SRPT mSRPT=new SRPT();
        for(int i=1;i<=20;i++){
            mSRPT.addTask(new Task(30-i,30));
        }
        while(!mSRPT.isEmpty()) {
            mSRPT.tick();

        }
    }

    @Test
    public void testEDF_1(){
        EDF mEDF=new EDF();
        for(int i=1;i<=20;i++){
            mEDF.addTask(new Task(i,i+30));
        }
        while(!mEDF.isEmpty()) {
            mEDF.tick();

        }
    }

    @Test
    public void testEDF_2(){
        EDF mEDF=new EDF();
        for(int i=1;i<=20;i++){
            mEDF.addTask(new Task(30-i,30));
        }
        while(!mEDF.isEmpty()) {
            mEDF.tick();

        }
    }

    @Test
    public void testDM_1(){
        DM mDM=new DM();
        for(int i=1;i<=20;i++){
            mDM.addTask(new Task(i,i+30));
        }
        while(!mDM.isEmpty()) {
            mDM.tick();

        }
    }

    @Test
    public void testDM_2(){
        DM mDM=new DM();
        for(int i=1;i<=20;i++){
            mDM.addTask(new Task(30-i,30));
        }
        while(!mDM.isEmpty()) {
            mDM.tick();

        }
    }

    @Test
    public void testDM_3(){
        DM mDM=new DM();
        for(int i=1;i<=20;i++){
            mDM.addTask(new Task(30+i,30-i));
        }
        while(!mDM.isEmpty()) {
            mDM.tick();

        }
    }

}
