import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/8/10 12:55
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {

        List list=new ArrayList();


        list.add("AA");
        list.add("AA");
        list.add("AAc");
        list.add("AAd");


        list=new ArrayList(new HashSet(list));


        System.out.println(list);


    }

}
