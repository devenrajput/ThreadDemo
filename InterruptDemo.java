package ThreadDemo;

class MyThread extends Thread
{
    public MyThread(String string) {
        super(string);
    }

    public void run()
    {
        System.out.println(Thread.currentThread().getName());
        try {
            sleep(2000);
        } catch (InterruptedException e)
        {
            //e.printStackTrace();
            System.out.println("Thread are feeling fresh");
        }
        System.out.println("Hello...");
        

    }
}

class MyThread1 extends Thread
{
    MyThread th;
    public MyThread1(String string, MyThread th) {
        super(string);
        this.th=th;
    }

    public void run()
    {
        System.out.println(Thread.currentThread().getName());

        try {
            System.out.println("Thread are going to be join..");
            th.join(1000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
           
        }

        System.out.println(th.isInterrupted());

        th.interrupt();

        System.out.println(th.isInterrupted());

    }
}

public class InterruptDemo 
{
    public static void main(String[] args) 
    {
        MyThread th = new MyThread("mythread"); 
        th.start(); 

        MyThread1 th1 = new MyThread1("mythread1",th); 
        th1.start(); 
        th1.interrupt(); 
       
        System.out.println(th1.isInterrupted());

       
    }
}