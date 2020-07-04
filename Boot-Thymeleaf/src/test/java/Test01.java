import org.junit.Test;

import java.io.File;

/**
 * @author XULEI
 * @ClassName Test01
 * @description TODO
 * @Date 2020/7/4 10:45
 * @Version 1.0
 */
public class Test01 {

    @Test
    public void test1(){

        String property = System.getProperty("user.dir");

        property=property+ File.separator;


        System.out.println(property);
    }
}
