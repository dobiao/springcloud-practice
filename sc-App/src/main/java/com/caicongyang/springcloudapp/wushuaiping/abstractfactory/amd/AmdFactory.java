package com.caicongyang.springcloudapp.wushuaiping.abstractfactory.amd;


import com.caicongyang.springcloudapp.wushuaiping.abstractfactory.Cpu;

/**
 * @author wushuaiping
 * @date 2018/3/12 下午11:08
 */
public class AmdFactory implements Cpu {
    public void produceCpu() {
        System.out.println("Amd生产的CPU");
    }
}
