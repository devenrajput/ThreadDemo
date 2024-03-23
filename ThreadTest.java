package ThreadDemo;

class Table //Table class
{
    synchronized void printTable(int x){
        for(int i=1;i<=10;i++){
            System.out.println(i*x);
        }
    }
}

class FirstThread extends Thread //Thread class
{
    Table t;
    public FirstThread(Table t) {
        this.t=t;
    }

    public void run(){
       t.printTable(2);
    }
}

class SecondThread extends Thread //Thread class
{
    Table t;
    public SecondThread(Table t) {
        this.t=t;
    }

    public void run(){
        t.printTable(3);
    }
}

public class ThreadTest //Main class
{
    public static void main(String args[]){

        Table t = new Table();
        FirstThread  threadObj = new FirstThread(t);
        threadObj.start();
        SecondThread  threadObj1 = new SecondThread(t);
        threadObj1.start();

    }
}