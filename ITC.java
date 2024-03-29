package ThreadDemo;

class Account{

    int amount;

    synchronized void withdrawal(int amount)
    {

        System.out.println("Thread is going to withdrawal....");

        if (this.amount<amount) {
            System.out.println("insufficient amount!");

            try {
                wait();
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
            
        }
       
            this.amount -= amount;
            System.out.println("withdrawal done....: "+amount);
        

    }

    synchronized public void submit(int amount)
    {

        System.out.println("now amount is going to submit..");

        this.amount += amount;

        System.out.println("submit done..: "+amount);

        notify();


    }

}


public class ITC {

    public static void main(String[] args) {

        Account ac = new Account();

        new Thread() ////anonymous Thread
        {

            public void run(){
                ac.withdrawal(500);
            }

        }.start();
        

        new Thread() //anonymous Thread
        {

            public void run(){
                ac.submit(1000);
            }

        }.start();

        
    }
}
