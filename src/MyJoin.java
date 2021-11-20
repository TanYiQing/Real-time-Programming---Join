import java.util.Scanner;

public class MyJoin {
    static int x,y,z,z1,total;

    public static void main(String [] args) throws InterruptedException{
        Scanner scan = new Scanner(System.in);
        System.out.print("Please input x:");
        x= scan.nextInt();

        Thread t1 = new Thread(new Runnable(){
            public void run() {
                y=x+5;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int i=x;i<=y;i++){
                    if(isPrime(i)){
                        System.out.println(Thread.currentThread().getName()+ ": "+i);
                        total+=i;
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                z=x+10;
                for(int i=y;i<=z;i++){
                    if(isPrime(i)){
                        System.out.println(Thread.currentThread().getName()+ ": "+i);
                        total+=i;
                    }
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            public void run() {
                z1=x+15;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int i=z;i<=z1;i++){
                    if(isPrime(i)){
                        System.out.println(Thread.currentThread().getName()+ ": "+i);
                        total+=i;
                    }
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

        System.out.print("Total: "+total);

    }

    public static boolean isPrime(int checknum){
        if (checknum <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(checknum); i++) {
            if (checknum % i == 0) {
                return false;
            }
        }
        return true;
    }

}
