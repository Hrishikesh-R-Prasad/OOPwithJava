class BMSCollegeThread extends Thread{
    public void run(){
        try {
            for(int i=0;i<2;i++){
                System.out.println("BMS College of Engineering");
                Thread.sleep(10000);
            }
            
        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted "+e.getMessage());
        }
    } 
}
class CSEThread extends Thread{
    public void run(){
        try {
                for(int i=0;i<10;i++){
                System.out.println("CSE");
                Thread.sleep(2000);
                }
            }
            
        catch (InterruptedException e) {
            System.out.println("Thread Interrupted "+e.getMessage());
        }
    } 
}
public class MultiThreadExample {
    public static void main(String[] args) {
        BMSCollegeThread bms = new BMSCollegeThread();
        CSEThread cse = new CSEThread();
        bms.start();
        cse.start();
    }

    
}
