class Solution {
    public int fib(int n) {
         int a = 0; 
        int b = 1; 

        if (n <= 1) {
            return n;
        }
        
        for (int i = 2; i <= n; i++) {
            int next = a + b; 
            a = b;       
            b = next;
        }
        
        return b;
    }
}
