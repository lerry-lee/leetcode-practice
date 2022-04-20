package _其他._笔试题._外企;

import java.util.*;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/19
 */
public class _1487_保证文件名唯一 {

    public static void main(String[] args) {
        _1487_保证文件名唯一 instance = new _1487_保证文件名唯一();
        String[] names = new String[]{"pes", "fifa", "gta", "pes(2019)"};
        String[] names2 = new String[]{"gta", "gta(1)", "gta", "avalon"};
        String[] names3 = new String[]{"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"};
        String[] names4 = new String[]{"wano", "wano", "wano", "wano"};
        String[] names5 = new String[]{"kaido", "kaido(1)", "kaido", "kaido(1)"};
        String[] names6 = new String[]{"kaido","kaido(1)","kaido","kaido(1)","kaido(2)"};

        System.out.println(Arrays.toString(instance.getFolderNames(names)));
        System.out.println(Arrays.toString(instance.getFolderNames(names2)));
        System.out.println(Arrays.toString(instance.getFolderNames(names3)));
        System.out.println(Arrays.toString(instance.getFolderNames(names4)));
        System.out.println(Arrays.toString(instance.getFolderNames(names5)));
        System.out.println(Arrays.toString(instance.getFolderNames(names6)));
    }

    /**
     * 解法1：使用一个哈希表<文件名,可用编号>
     * 大概思路是：
     * 每次遍历当前文件名时，获取其计数值，如果为0，直接用改名字即可，然后更新计数为1；
     * 如果计数不为0，不断尝试新文件名是否可用，新文件名=旧文件名+(k)。
     * 值得注意的是，这里为什么要不断尝试新文件名，因为有的测试用例中，前面就把一些可用计数给用掉了，比如abc,abc(3)，第二个元素abc(3)把3给用了，后面如果再出现abc，只能用1、2，然后3不可用、接着4...
     */
    public String[] getFolderNames(String[] names) {
        int n = names.length;
        //names后面可以接的编号，默认为0，表示不用加编号
        Map<String, Integer> names_k = new HashMap();
        //保存结果的数组
        String[] res = new String[n];
        //遍历数组
        for (int i = 0; i < n; i++) {
            //当前文件名
            String name = names[i];
            //获取文件名的可用编号
            int k=names_k.getOrDefault(name,0);
            //如果k为0，说明当前name可用，直接赋值即可
            if(k==0){
                res[i]=name;
                //更新name可用编号+1
                names_k.put(name,k+1);
            }
            //否则，当前name不可用，需要追加新的编号
            else{
                //新name尝试
                String newName=name+"("+k+")";
                //只要新name不可用，就一直更新k
                while(names_k.containsKey(newName)){
                    k++;
                    newName=name+"("+k+")";
                }
                //得到一个可用的新name，直接用
                res[i]=newName;
                //更新原name的可用编号k，因为在while循环中，k可能已经更新
                names_k.put(name,k+1);
                //更新新name，已经被使用，下次从1开始
                names_k.put(newName,1);
            }
        }
        return res;
    }
}
