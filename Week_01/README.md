# 学习笔记

## 作业

### 必做题: 题目-2
**题目内容**：
> 自定义一个Classloader，加载一个名为Hello.xlass的加密文件，执行 hello 方法，此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件。
> Hello.xlass文件地址: 学习群下载；
> 

**题解**：
1. 自定义ClassLoader类
    > ./src/main/java/com/geek/learning/CustomClassloader.java
    > 

2. Hello.xlass加密文件
    > ./src/main/resources/Hello.xlass
    > 

3. 执行自定义ClassLoader类(CustomClassloader)的main方法，即可完成题目要求；
    > 1. 使用IDEA导入Week_01模块；
    > 2. Run CustomClassloader.java中的main方法；
    > 


### 必做题: 题目-3
**题目内容**：
> 画一张图，展示 Xmx、Xms、Xmn、Meta、DirectMemory、Xss 这些内存参数的关系。
> 

**题解**：
1. JVM内存参数关系图
    > ./src/main/resources/JVM内存参数关系图.jpg
    > 


## 心得
第一周的课程体感不佳，暂不表示心得了，希望能有改善；


## 建议
1. 希望讲师讲课时，能根据知识点的重要程度 **调整讲课节奏** 和 **增加课程中的问答互动**，两次直播课程的感受就是平淡冗长，即使内容再有含金量，讲授体感不好也是无用；

2. 建议调整课程知识点的时间规划，只靠 超级拖堂 来进行 知识点蛮灌，体感很差；

