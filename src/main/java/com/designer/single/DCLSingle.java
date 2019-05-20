package com.designer.single;

/**
 * @author Administrator 2019-02-18 10:38
 * 是否 Lazy 初始化：是
    是否多线程安全：是
    实现难度：较复杂
    描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
    getInstance() 的性能对应用程序很关键。
 **/
public class DCLSingle {

    private volatile static DCLSingle dclSingle;

    private DCLSingle(){}

    public static DCLSingle getDclSingle(){
        if (dclSingle == null){
            synchronized (DCLSingle.class){
                if (dclSingle == null){
                    dclSingle = new DCLSingle();
                }
            }
        }
        return dclSingle;
    }

}
