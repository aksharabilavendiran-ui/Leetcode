class Foo {
    boolean x;
    boolean y;

    public Foo() {
     x = false;
     y = false;   
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        
        printFirst.run();
        x = true;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        
        while(!x){
            wait();
        }
        printSecond.run();
        y = true;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        
        while(!y){
            wait();
        }
        printThird.run();
    }
}
