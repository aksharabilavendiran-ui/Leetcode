class Solution {
    public int[] findEvenNumbers(int[] digits) {

        int[] count = new int[10];

        // Count each digit
        for (int digit : digits) {
            count[digit]++;
        }

        List<Integer> list = new ArrayList<>();

        // Check every 3-digit even number
        for (int num = 100; num <= 998; num += 2) {

            int[] temp = count.clone();

            int a = num / 100;
            int b = (num / 10) % 10;
            int c = num % 10;

            if (temp[a] > 0) {
                temp[a]--;

                if (temp[b] > 0) {
                    temp[b]--;

                    if (temp[c] > 0) {
                        list.add(num);
                    }
                }
            }
        }

        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
