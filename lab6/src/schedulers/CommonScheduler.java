package schedulers;


import java.util.HashSet;
import java.util.Set;

public class CommonScheduler implements Scheduler{
    private long ticks;
    private Set<Task> tasks;
    private Task currTask;

    public CommonScheduler(){
        ticks=0;
        tasks=new HashSet<>();
    }

    /**
     * sort task by a given rule
     * @return new current task
     */
    public Task getPriorTask(Set<Task> tasks){
        System.err.println("CommonScheduler @getPriorTask: not implemented");
        return null;
    }

    public boolean isEmpty(){
        return tasks.isEmpty();
    }

    @Override
    public int getTime(){
        return (int)ticks;
    }

    @Override
    public boolean addTask(Task t){
        if(t==null){
            return false;
        }
        if(t.getRemProcTime()>0 && !tasks.contains(t)){
            tasks.add(t);
            //find highest priority task again since we added a new task
            currTask= getPriorTask(tasks);
            return true;
        }
        return false;
    }
    @Override
    public boolean delTask(Task t){
        if(t==null){
            return false;
        }
        if(t.getRemProcTime()<=0 && tasks.contains(t)){
            tasks.remove(t);
            currTask= getPriorTask(tasks);
            System.out.println("task "+t.getTaskID()+" finished at "+getTime());
            return true;
        }
        return false;
    }

    @Override
    public int currentTaskID(){
        return currTask==null? 0:currTask.getTaskID();
    }

    @Override
    public void tick(){
        ticks++;
        if(currTask!=null) {
            currTask.oneTick();
            delTask(currTask);
        }else {
            currTask = getPriorTask(tasks);
        }
    }
}
