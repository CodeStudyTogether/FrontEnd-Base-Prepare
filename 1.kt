1.mipmap和drawable的区别
android 通过 mipmap 技术提前对按缩小层级生成图片预先存储在内存中，这样就提高了图片渲染的速度和质量。
2.jar和aar的区别
JAR 文件就是 Java Archive File，顾名思意，它的应用是与 Java 息息相关的，是 Java 的一种文档格式。只包含了class文件与清单文件 ，不包含资源文件
3.面向对象的特征有哪些方面  
抽象：
继承：继承与接口的区别
封装：
多态性：
4.String,StringBuffer,StringBuilder
在这方面运行速度快慢为：StringBuilder > StringBuffer > String
5.String 为什么要设计成不可变的？
字符串常量池(String pool, String intern pool, String保留池) 是Java堆内存中一个特殊的存储区域, 当创建一个String对象时,假如此字符串值已经存在于常量池中,则不会创建一个新的对象,而是引用已经存在的对象。
