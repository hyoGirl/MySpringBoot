package com.spring.boot.Jichu;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/11/2 9:46
 * @Version 1.0
 */
public class Final003 extends Demo{


    public static void main(String[] args) {
        Demo demo=new Demo();
        demo.show(1);

    }


}

class Demo{

    final void show(){
        System.out.println("1");
    }
    final void show(int a){
        System.out.println("1"+a);
    }

    private void method(){
        System.out.println("method");
    }
}

