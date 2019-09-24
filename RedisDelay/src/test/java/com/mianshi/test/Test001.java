package com.mianshi.test;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/9/24 10:49
 * @Version 1.0
 */
public class Test001 {

   private Test001(){}
   private static  volatile Test001 test001;
   public static  Test001 getInstance(){
       if(test001==null){
           synchronized (Test001.class){
               if(test001==null){
                   /**
                    * 1:分配内存空间
                    * 2：初始化对象
                    * 3：设置引用指向刚分配的地址
                    */
                   return  test001=new Test001();
               }
           }
       }
       return  test001;
   }

    public static void main(String[] args) {

        int hashCode1 = Test002.getInstance().hashCode();
        int hashCode2 = Test002.getInstance().hashCode();

        System.out.println(hashCode1==hashCode2);


    }
}

