package com.hdw.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @author hdw
 * @create 2020-06-19-10:23
 * @desc 描述
 */
public class ForkJoinCalculater extends RecursiveTask<Long> {

    private long start;
    private long end;
    private final long RULE = 10000l;

    public ForkJoinCalculater(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        long length =end-start;

        if (length <= RULE) {
            for (long i = start; i <= end; i++) {
                sum = sum + i;
            }

        } else {
            long middile = (start + end) / 2;
            ForkJoinCalculater one = new ForkJoinCalculater(start, middile);
            one.fork();//拆分子任务，压入线程栈
            ForkJoinCalculater two = new ForkJoinCalculater(middile + 1, end);
            two.fork();
            sum = one.join() + two.join();

        }
        return sum;

    }

}
