public class Daemon {
    public static void main(String[] args) {
        // System.out.println("sdf");
        Thread g1 = new Thread(new God());
        Thread g2 = new Thread(new God());
        Thread p = new Thread(new Ppl());
        Thread p2 = new Thread(new Ppl());

        g1.setDaemon(true);
        g1.start();
        // p.start();
        
        g2.setDaemon(true);
        g2.start();
        
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            //TODO: handle exception
        }
        
        // p2.start();

        System.out.println("main thread stop");
    }    
}

class Ppl implements Runnable {
    @Override
    public void run() {
        // TODO Auto-generated method stub
        for(int i = 0;i < 5;i++){
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
            System.out.println("ppl thread: "+i);
        }
        System.out.println("ppl thread end");
    }
}

class God implements Runnable{
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(true){
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
            System.out.println("上帝守护你");
        }
    }
}