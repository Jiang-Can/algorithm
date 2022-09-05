#Set

##Set接口常用方法
![img.png](img.png)

##HashSet
![img_2.png](img_2.png)
![img_1.png](img_1.png)

##HashSet底层
本质上就是HashMap
set.add("a") <==> map.put("a",PRESENT)
这里PRESENT就是一个 static final的object
![img_10.png](img_10.png)
##HashSet数据结构的作用
提升存储效率
##HashSet扩容机制
![img_3.png](img_3.png)
*修改 TREEIFY_THRESHOLD >=8个 && table到MIN__TREEIFY_CAPACITY(64) => TREEIFY
![img_9.png](img_9.png)
####notes
此处size是add的所有节点数量，不是数组tab[]被占用的节点
![img_13.png](img_13.png)

e.g. 初始情况数组容量16，loadFactor之后即12，只要加到第12个时，数组容量就会翻倍，即24 
###new HashSet() 第一次add
1. putVal
![img_4.png](img_4.png)
2. compute hashVal
![img_5.png](img_5.png)
3. initial table 
DEFAULT_INITIAL_CAPACITY  1<<4 = 16 
DEFAULT_LOAD_FACTOR 0.75 防止在增加数据量比较大到情况下需要扩容，提前缓冲扩容(即16的情况下 到12 就开始扩容)
![img_6.png](img_6.png) 
4. compute where to put node in this table
![img_7.png](img_7.png)
5. Add successfully (添加成功返回null)
![img_8.png](img_8.png)
###第二次add值(假设与第一次一样) 
1. 重复第一次add的 1，2 操作
2. 由于hash值相等进入else判断
![img_11.png](img_11.png)
   1. 调用equals方法判断
   2. 判断tab[i]处节点是否为树的跟节点，即判断该链条是否TREEIFY,如果是则加入该节点到树
   3. 遍历该链表，判断是否需要加入
    ![img_12.png](img_12.png)
      
##LinkedHashSet
![img_14.png](img_14.png)
![img_15.png](img_15.png)
![img_16.png](img_16.png·)