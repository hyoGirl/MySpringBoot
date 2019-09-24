package com.mianshi.test;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/9/24 10:59
 * @Version 1.0
 */
public class Test002 {

    private  Test002(){}
    public static  class  Inner{
        public  static Test002 instance=new Test002();
    }

    public static  Test002 getInstance(){
        return Inner.instance;
    }

    public static void main(String[] args) {

        Test001 instance = Test001.getInstance();

        int hashCode1 = Test001.getInstance().hashCode();
        int hashCode2 = Test001.getInstance().hashCode();

        System.out.println(hashCode1);
        System.out.println(hashCode1==hashCode2);


    }
}
