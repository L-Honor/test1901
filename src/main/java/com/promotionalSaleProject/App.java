package com.promotionalSaleProject;


import com.promotionalSaleProject.dao.UserDOMapper;
import com.promotionalSaleProject.dataobject.UserDO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */

@SpringBootApplication(scanBasePackages = {"com.promotionalSaleProject"})
@RestController
@MapperScan("com.promotionalSaleProject.dao")
public class App {
    @Autowired
    private UserDOMapper userDOMapper;

    @RequestMapping("/")
    public String home(){
        UserDO userDO = userDOMapper.selectByPrimaryKey(1);
        if(userDO == null){
            return "用户对象不存在";
        }else{
            return userDO.getName();
        }

    }



    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class,args);
        int[] bs = new int[] {2,5,7,1,8,6,4,3,9,10,15,4,5};
//        bubbleSort(bs);
        quickSort(bs,0,bs.length-1);
        print(bs);

//        int a = 20;
//        System.out.println(20<<3);

    }

    //冒泡法按从小到大排列
    public static void bubbleSort(int[] bs){
        int temp;
        for(int i = 0; i < bs.length - 1; i ++){
            for(int j = i+1; j< bs.length; j++){
                if(bs[i] > bs[j]){
                    temp = bs[i];
                    bs[i] = bs[j];
                    bs[j] = temp;
                }
            }
        }

    }


    //快速排序 按从小到大排列
    public static void quickSort(int[] arr, int left, int right){
        //进行判断，如果左边索引比右边大则是不合法的，直接使用return结束这个方法
        if(left > right){
            return;
        }
        //定义变量保存基准数
        int base = arr[left];
        //定义变量i指向最左边
        int i = left;
        //定义变量j指向最左边
        int j = right;
        //当i和J不相遇的时候，在循坏中进行检索
        while(i != j){
            //由j从右往左检索比基准数小的，如果检索到比基准数小的则停下
            //如果检索到的比基准书大的或者相等的，就继续检索
            while(arr[j] >= base && i < j){
                j--; //j从右往左移动
            }
            //i从左往右检索
            while(arr[i] <= base && i < j){
                i++;//i从左往右移动
            }
            //i和j都停下，交换i和j位置的元素
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        //如果i和j相遇了，就交换基准数这个元素和相遇位置的元素
        arr[left] = arr[i];
        arr[i] = base;
        // 排基准数的左边
        quickSort(arr,left,i - 1);
        //排右边
        quickSort(arr,i+1,right);
    }


    public static void print(int[] a){
        for(int i = 0; i< a.length; i++){
            System.out.println(a[i]);
        }
    }


    /*
    -----------------------------
     */
    String s = "sdadweiaew";

}
