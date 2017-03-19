package task1;


public class SimpleLambda {

    /**
     * (T->R, T)->R
     */
    public static <T,R> R bar(SimpleFunction<T,R> f, T t){
        return f.foo(t);
    }

    public static void main(String args[]){
        SimpleFunction<Integer, String> xPlusOne=new  SimpleFunction<Integer, String>(){
            public String foo(Integer x){
                return "Value of "+x+" plus one is "+(x+1);
            }
        };

        System.out.println(bar(xPlusOne, 320));
    }
}
