package org.hdw.test;

import org.junit.Test;

/**
 * @author hdw
 * @create 2020-07-17-10:40
 * @desc 描述
 *
 */
public class TestCountDownLatch {
    @Test
    public void test() throws InterruptedException {

      /* // 创建2个线程的线程池
        Executor executor = Executors.newFixedThreadPool(2);
        while(存在未对账订单){
            // 计数器初始化为2
            CountDownLatch latch = new CountDownLatch(2);
            // 查询未对账订单
            executor.execute(()-> {
                pos = getPOrders();
                latch.countDown();

            });
            // 查询派送单
            executor.execute(()-> {
                dos = getDOrders();
                latch.countDown();
            });

            // 等待两个查询操作结束
            latch.await();

            // 执行对账操作
            diff = check(pos, dos);
            // 差异写入差异库
            save(diff);*/
        }

}
