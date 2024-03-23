package ThreadDemo;

class MyFirstThread extends Thread{
    public void run(){
        System.out.println("Hii everyone");
    }
}

public class ThreadTest{
    public static void main(String args[]){

        MyFirstThread  threadObj = new MyFirstThread();
        threadObj.start();

    }
}