package com.example.demo.algorithm;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLockController {
    
    @Autowired
    RedisLock lock;

    @RequestMapping("/test")
    public void test(){
        boolean flag = false; //标识  是否正常获取锁
        String uuid = UUID.randomUUID().toString(); //redis的value  是一串随机数
        flag = lock.lock("mykey1",uuid,5);
        if (flag){
            business(uuid);
        }else {

            //如果未正常获取锁  可以通过重试 直到获取锁成功
            while (!flag){
                try {

                    //重试 时间间隔  减少与redis交互次数
                    Thread.sleep(3000);
                    System.out.println("重试");
                    flag = lock.lock("mykey1",uuid,5);
                    if (flag){
                        business(uuid);
                    }else {
                        continue;
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void business(String uuid){
        
        try {
            System.out.println("加锁成功，执行业务");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //业务执行完成  正常释放锁
            lock.unlock("mykey1",uuid);
        }
    }
}