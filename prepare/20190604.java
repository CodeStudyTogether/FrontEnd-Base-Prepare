1、Java 相关

容器（HashMap、HashSet、LinkedList、ArrayList、数组等）


需要了解其实现原理，还要灵活运用，如：自己实现 LinkedList、两个栈实现一个队列，数组实现栈，队列实现栈等。


内存模型
垃圾回收算法（JVM）
类加载过程（需要多看看，重在理解，对于热修复和插件化比较重要）
反射
多线程和线程池
HTTP、HTTPS、TCP/IP、Socket通信、三次握手四次挥手过程
设计模式（六大基本原则、项目中常用的设计模式、手写单例等）
断点续传

2、Android 基础

自定义 View（参考链接：自定义View，有这一篇就够了 - 简书、Android 自定义 View）
事件拦截分发(Android事件分发机制，大表哥带你慢慢深入 - 简书 )
解决过的一些性能问题，在项目中的实际运用。
性能优化工具  (TraceView、Systrace、调试 GPU 过度绘制 & GPU 呈现模式分析、Hierarchy Viewer、MAT、Memory Monitor & Heap Viewer & Allocation Tracker 等）
性能优化
（1）网络：API 优化、流量优化、弱网优化
（2）内存：OOM 处理、内存泄漏、内存检测、分析、Bitmap 优化
（3）绘制
（4）电量：WeakLock 机制、JobScheduler 机制
（5）APK 瘦身
（6）内存抖动
（7）内存泄漏
（8）卡顿
（9）性能优化：布局优化、过度渲染处理、ANR 处理、监控、埋点、Crash 上传。
IntentService 原理及应用
缓存自己如何实现（LRUCache 原理）
图形图像相关：OpenGL ES 管线流程、EGL 的认识、Shader 相关
SurfaceView、TextureView、GLSurfaceView 区别及使用场景
动画、差值器、估值器（Android中的View动画和属性动画 - 简书、Android 动画 介绍与使用）
MVC、MVP、MVVM
Handler、ThreadLocal、AsyncTask
Gradle（Groovy 语法、Gradle 插件开发基础）
热修复、插件化

3、Android Framework

AMS 、PMS
Activity 启动流程
Binder 机制（IPC、AIDL 的使用）
为什么使用 Parcelable，好处是什么？
Android 图像显示相关流程，Vsync 信号等

4、三方源码

Glide ：加载、缓存、LRU 算法
EventBus
LeakCanary
ARouter
插件化（不同插件化机制原理与流派，优缺点。局限性）
热修复
RXJava
Retrofit

5、算法与数据结构

单链表：反转、插入、删除
双链表：插入、删除
手写常见排序、归并排序、堆排序
二叉树前序、中序、后序遍历
最大 K 问题
广度、深度优先搜索算法
可以去刷一下 LeetCode ,对自己提升也会比较大。
