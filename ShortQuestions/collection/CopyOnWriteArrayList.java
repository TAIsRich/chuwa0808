package collection;

import java.util.Iterator;

public class CopyOnWriteArrayList<S> {
    public class ConcurrentDemo extends Thread {

        CopyOnWriteArrayList<S> l
                = (CopyOnWriteArrayList<S>) new CopyOnWriteArrayList<String>();

        public void run()
        {
            // Child thread trying to
            // add new element in the
            // Collection object
            l.add("D");
        }

        public void main(String[] args)
                throws InterruptedException
        {
            l.add("A");
            l.add("B");
            l.add("c");

            // We create a child thread
            // that is going to modify
            // ArrayList l.
            ConcurrentDemo t = new ConcurrentDemo();
            t.run();

            Thread.sleep(1000);

            // Now we iterate through
            // the ArrayList and get
            // exception.
            Iterator itr = l.iterator();
            while (itr.hasNext()) {
                String s = (String)itr.next();
                System.out.println(s);
                Thread.sleep(1000);
            }
            System.out.println(l);
        }
    }

    private Iterator iterator() {
        return null;
    }

    private void add(String d) {
    }
}
