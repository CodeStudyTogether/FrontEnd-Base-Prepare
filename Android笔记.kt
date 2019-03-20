https://www.jianshu.com/p/0f82b0650909
https://zhuanlan.zhihu.com/p/59738065

App中唤醒其他进程的实现方式
进程保活的方式
如何保证一个后台服务不被杀死？

开启一个像素的Activity
前台服务
相互唤醒的意思就是，假如你手机里装了支付宝、淘宝、天猫、UC等阿里系的app，那么你打开任意一个阿里系的app后，有可能就顺便把其他阿里系的app给唤醒了。这个完全有可能的。此外，开机，网络切换、拍照、拍视频时候，利用系统产生的广播也能唤醒app
这个是系统自带的，onStartCommand方法必须具有一个整形的返回值，这个整形的返回值用来告诉系统在服务启动完毕后，如果被Kill，系统将如何操作，这种方案虽然可以，但是在某些情况or某些定制ROM上可能失效，我认为可以多做一种保保守方案。

Android为每个应用程序分配的内存大小是多少
我们在应用中可以通过ActivityManager的MemoryInfo内部类获取内存信息

App启动流程，从点击桌面开始
我们平时在手机桌面上点击一个app 图标， 就能启动一个app应用。从用户角度来看，这个过程看起来很简单，但是它的背后又隐藏着什么玄机 

每个Android App都在一个独立空间里, 意味着其运行在一个单独的进程中, 拥有自己的VM, 被系统分配一个唯一的user ID。
Android进程与Linux进程一样. 默认情况下, 每个apk运行在自己的Linux进程中. 另外, 默认一个进程里面只有一个线程---主线程. 这个主线程中有一个Looper实例, 通过调用Looper.loop()从Message队列里面取出Message来做相应的处理.
Click事件会调用startActivity(Intent), 会通过Binder IPC机制, 最终调用到ActivityManagerService.
ActivityManagerService会检查并在新的task中启动目标activity.
现在, 是时候检查这个进程的ProcessRecord是否存在了.
如果ProcessRecord是null, ActivityManagerService会创建新的进程来实例化目标activity.
ActivityManagerService调用startProcessLocked()方法来创建新的进程, 该方法会通过前面讲到的socket通道传递参数给Zygote进程. Zygote孵化自身, 并调用ZygoteInit.main()方法来实例化ActivityThread对象并最终返回新进程的pid.
ActivityThread随后依次调用Looper.prepareLoop()和Looper.loop()来开启消息循环.

系统启动流程是什么？（提示：Zygote进程 –> SystemServer进程 –> 各种系统服务 –> 应用进程）

简述Activity启动全部过程
Android中，一个应用程序的开始可以说就是从ActivityThread.java中的main()方法开始的。都是学过Java的人，想必也都知道Java的程序入口就是main()方法。Android其实也就是一个Java程序而已。
初始化主线程的Looper、主Handler。并使主线程进入等待接收Message消息的无限循环状态。
ActivityManagerService调度发送初始化消息
https://juejin.im/entry/58f5b68e61ff4b005807ab47

对Dalvik、ART虚拟机有什么了解？
我们写的所有的 Java 代码最终都会被编译器编译为以 .class 结尾的字节码文件，然后最终被 Java 虚拟机执行，从而得到我们想要的结果。
首先 Java 虚拟机是一个规范，由 Sun 公司制定，任何实现该规范的虚拟机都可以用来执行 Java 代码。
由于 Androd 运行在移动设备上，内存以及电量等诸多方面跟一般的 PC 设备都有本质的区别 ，一般的 JVM 没法满足移动设备的要求，所以在开发 Android 过程中，Android 团队一开始就必须打造一个符合移动设备的可以执行 Java 代码的虚拟机。
这就是我们说的 Dalvik 虚拟机 。
Dalvik 是一个更符合移动设备的用于执行 Java 代码的虚拟机，但又不是一个严格按照 JVM 规范的虚拟机实现
JVM 可以执行的文件是 .class 结尾的字节码文件，而 Dalvik 执行的是 dex 文件。
为什么 Dalvik 执行 dex 文件而不是 .class 文件，其实这里是 Android 专为 Dalvik 虚拟机做的一个优化。
Dalvik 基于寄存器，而 JVM 基于栈，很明显，基于寄存器的 Dalvik 在速度方面优势会更明显。
从 Android L 开始，Android 开始启用了新设计的虚拟机 ART。与 Dalvik 不同，在Dalvik下，应用每次运行的时候，字节码都需要通过即时编译器（Just In Time ，JIT）转换为本地机器码，这会拖慢应用的运行效率。
而在ART 环境中，应用在第一次安装的时候，会使用设备上的dex2oat工具进行字节码转码，把字节码预先编译成本地机器码，使其成为真正的本地应用。这个过程叫做预编译（Ahead-Of-Time，AOT）。
采用 AOT 策略后的好处显而易见，应用的启动速度会因此快很多，但是与此同时，应用的安装时间就会因为执行 AOT 操作而变长，但是相比之下还是非常值得。
另外，ART的另一个缺点就是对存储空间占用变大。一般的字节码在编译转码后占用的空间大小比之前要增大10%-20%。

java语言的重要特点是与平台无关性

java虚拟机在执行字节码时，把字节码解释成具体平台的机器指令执行。

JVM初始运行的时候都会分配好Method Area（方法区）和Heap（堆），而JVM 每遇到一个线程，就为其分配一个Program Counter Register（程序计数器）, VM Stack（虚拟机栈）和Native Method Stack （本地方法栈），当线程终止时，三者（虚拟机栈，本地方法栈和程序计数器）所占用的内存空间也会被释放掉。

类加载器（ClassLoader）是Java语言的一项创新，也是Java流行的一个重要原因。在类加载的第一阶段“加载”过程中，需要通过一个类的全限定名来获取定义此类的二进制字节流，完成这个动作的代码块就是类加载器。
双亲委派模型
某个特定的类加载器在接到加载类的请求时，首先将加载任务委托给父类加载器，依次递归，如果父类加载器可以完成类加载任务，就成功返回；只有父类加载器无法完成此加载任务时，才自己去加载。

垃圾回收只负责回收堆内存中的对象。
你可以调用System.gc()或者Runtime.getRuntime().gc()来建议JVM进行GC

==是运算符，用于比较两个变量是否相等。

equals，是Objec类的方法，用于比较两个对象是否相等，默认Object类的equals方法是比较两个对象的地址，跟==的结果一样。Object的equals方法如下：
    public boolean equals(Object obj) {
        return (this == obj);
    }
hashCode也是Object类的一个方法。返回一个离散的int型整数。在集合类操作中使用，为了提高查询速度。（HashMap，HashSet等）
如果两个对象根据equals()方法比较是相等的，那么调用这两个对象中任意一个对象的hashCode方法都必须产生同样的整数结果。
如果两个对象根据equals()方法比较是不相等的，那么调用这两个对象中任意一个对象的hashCode方法，则不一定要产生相同的整数结果
覆盖equals时总要覆盖hashCode 
一个很常见的错误根源在于没有覆盖hashCode方法。在每个覆盖了equals方法的类中，也必须覆盖hashCode方法。

一个字节等于8个bit
https://blog.csdn.net/nyistzp/article/details/12029917

Ingeter是int的包装类，int的初值为0，Ingeter的初值为null。

多态的实现的必要条件：继承，重写，父类引用指向子类对象（即，声明是父类，实际指向的是子类的一个对象）

String 不可变，因此是线程安全的
StringBuilder 不是线程安全的
StringBuffer 是线程安全的，内部使用 synchronized 进行同步

java内部类的四大作用
内部类可以很好的实现隐藏
内部类拥有外围类的所有元素的访问权限

接口中所有的方法隐含的都是抽象的。而抽象类则可以同时包含抽象和非抽象的方法。类可以实现很多个接口，但是只能继承一个抽象类类如果要实现一个接口，它必须要实现接口声明的所有方法。但是，类可以不实现抽象类声明的所有方法，当然，在这种情况下，类也必须得声明成是抽象的。抽象类可以在不提供接口方法实现的情况下实现接口。Java接口中声明的变量默认都是final的。抽象类可以包含非final的变量。Java接口中的成员函数默认是public的。抽象类的成员函数可以是private，protected或者是public。接口是绝对抽象的，不可以被实例化。抽象类也不可以被实例化，但是，如果它包含main方法的话是可以被调用的。

父类的静态方法能不能被重写。答案是不能。

静态代理和动态代理的区别，什么场景使用？
目的就是为其他对象提供一个代理以控制对某个对象的访问。代理类负责为委托类预处理消息，过滤消息并转发消息，以及进行消息被委托类执行后的后续处理。根据代理类的生成时间不同可以将代理分为静态代理和动态代理两种。
为了保持行为的一致性，代理类和委托类通常会实现相同的接口，所以在访问者看来两者没有丝毫的区别。通过代理类这中间一层，能有效控制对委托类对象的直接访问，也可以很好地隐藏和保护委托类对象，同时也为实施不同控制策略预留了空间，从而在设计上获得了更大的灵活性。
首先我们要介绍的就是 Java 动态代理，Java 的动态代理涉及到两个类：InvocationHandler 接口和 Proxy 类

编译之后，任何类都是个 .class 文件。当 jvm 在运行的时候需要用到某个类，就会去加载这个类的.class文件；加载之后立即生成一个实例，这个实例是一个类级的实例（此时还不涉及应用级对象的创建），类名是 Class;一个.class文件在jvm中仅有一个实例；这个实例提供了 这个类所拥有的一切方法和属性。在jvm中，这个Class对象存放在方法区（也叫永久区，非堆）。在这之后，创建该类任何一个实例对象，都需要先到方法区得到这个唯一的Class的对象；对象才能开始创建。

jvm对注解的支持，就是底层创建一个动态代理类，然后代理类中创建各个AnnotationInvocationHandler对象；每个AnnotationInvocationHandler对应一个我们声明的Annotation接口类，且AnnotationInvocationHandler收集对应注解接口类中的属性键值对。我们通过反射method.getAnnotation(**Annotation.class)或者field.getAnnotation(**Annotation.class)，底层就是调用代理类，获取AnnotationInvocationHandler中的memberValues。

Java中String的了解 ? String为什么要设计成不可变的？
为了安全
这样在大量使用字符串的情况下，可以节省内存空间，提高效率。

Object类的equal和hashCode方法重写，为什么？
说起equals方法，我们都知道是超类Object中的一个基本方法，用于检测一个对象是否与另外一个对象相等。而在Object类中这个方法实际上是判断两个对象是否具有相同的引用，如果有，它们就一定相等。
public boolean equals(Object obj) {   return (this == obj);     }
默认情况下也就是从超类Object继承而来的equals方法与‘==’是完全等价的，比较的都是对象的内存地址，但我们可以重写equals方法，使其按照我们的需求的方式进行比较，如String类重写了equals方法，使其比较的是字符的序列，而不再是内存地址。
