package nju.test.exercise02_B;

//书本分发，和漆狗屋类似

public class _03
{
    // Utility method to check if current minimum value
    // is feasible or not.
    static boolean isPossible(int arr[], int n, int m, int curr_min)
    {
        int studentsRequired = 1;
        int curr_sum = 0;

        // iterate over all books
        for (int i = 0; i < n; i++)
        {
            // check if current number of pages are greater
            // than curr_min that means we will get the result
            // after mid no. of pages
            if (arr[i] > curr_min)
                return false;

            // count how many students are required
            // to distribute curr_min pages
            if (curr_sum + arr[i] > curr_min)
            {
                // increment student count
                studentsRequired++;

                // update curr_sum
                curr_sum = arr[i];

                // if students required becomes greater
                // than given no. of students,return false
                if (studentsRequired > m)
                    return false;
            }

            // else update curr_sum
            else
                curr_sum += arr[i];
        }
        return true;
    }

    // method to find minimum pages
    static int findPages(int arr[], int n, int m)
    {
        long sum = 0;

        // return -1 if no. of books is less than
        // no. of students
        if (n < m)
            return -1;

        // Count total number of pages
        for (int i = 0; i < n; i++)
            sum += arr[i];

        // initialize start as 0 pages and end as
        // total pages
        int start = 0, end = (int) sum;
        int result = Integer.MAX_VALUE;

        // traverse until start <= end
        while (start <= end)
        {
            // check if it is possible to distribute
            // books by using mid is current minimum
            int mid = (start + end) / 2;
            if (isPossible(arr, n, m, mid))
            {
                // if yes then find the minimum distribution
                result = Math.min(result, mid);

                // as we are finding minimum and books
                // are sorted so reduce end = mid -1
                // that means
                end = mid - 1;
            }

            else
                // if not possible means pages should be
                // increased so update start = mid + 1
                start = mid + 1;
        }

        // at-last return minimum no. of  pages
        return result;
    }

    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int loop = Integer.parseInt(sc.nextLine().trim());
    //     while (loop-- > 0) {
    //         int len = Integer.parseInt(sc.nextLine().trim());
    //         int[] pages = new int[len];
    //         String s = sc.nextLine();
    //         String[] nums = s.split(" ");
    //         for (int i = 0; i < pages.length; i++) {
    //             pages[i] = Integer.parseInt(nums[i]);
    //         }
    //         int m = Integer.parseInt(sc.nextLine().trim()); //学生个数
    //         int res = findPages(pages, pages.length, m);
    //         System.out.println(res);
    //
    //     }
    // }

    public static int sum(int[] arr, int from, int to) {
        int sum = 0;
        for (int i = from; i <= to; i++) {
            sum += arr[i];
        }
        return sum;
    }
    /**
     * @param arr
     * @param k     //k个学生
     * @param n     //n本书
     */
    public static int solve(int[] arr, int k, int n) {
        if (k == 1) {       //如果只有一个学生，那他得全搞
            return sum(arr, 0, n-1);
        }
        if (n == 1) {       //如果只有一本书的情况
            return arr[0];
        }
        int best = Integer.MAX_VALUE;       //存储最佳结果

        //连续数组条件很重要，这里使用递归解决
        //最佳结果是这样的：我们不断的从左至右切arr，在k个人的情况下，整个数组分为两部分，前一部分分给k个人，后一部分分给第k个人
        //我们要找到前一部分和后一部分的最大值，这个最大值是当前切割状态下，符合条件的分配的值
        //我们所需要的结果是所有切割状态下的最小值。
        //i是代表切的位置，从1开始切（最后要回到递归条件n==1的情况），切到第n个位置
            for (int i = 1; i <= n; i++) {
            best = Math.min(best,Math.max(solve(arr,k-1,i),sum(arr,i,arr.length-1)));
        }
        return best;
    }

    public static void main(String[] args) {
        int[] a = {12, 34, 67, 90,15, 60};
        int solve = solve(a, 3, 4);
        System.out.println(solve);
    }
}