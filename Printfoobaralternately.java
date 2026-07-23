import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    private Semaphore fooLock = new Semaphore(1);
    private Semaphore barLock = new Semaphore(0); 

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooLock.acquire();      
            printFoo.run();         
            barLock.release();      
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barLock.acquire();       
            printBar.run();          
            fooLock.release(); 
        }
    }
}
