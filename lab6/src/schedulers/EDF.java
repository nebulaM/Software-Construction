package schedulers;

import java.util.Set;

public class EDF extends CommonScheduler{
    public EDF(){
        super();
    }
    @Override
    public Task getPriorTask(Set<Task> tasks){
        int shortest=Integer.MAX_VALUE;
        Task priorTask=null;
        for (Task task: tasks) {
            try{
                task.release(getTime());
                int time=task.getAbsDeadline();
                if(time<shortest){
                    shortest=time;
                    priorTask=task;
                }
            }catch (TaskNotReadyException e){
                System.err.println("task not ready");
            }
        }
        return priorTask;
    }
}
