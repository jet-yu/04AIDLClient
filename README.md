
链接来源：https://blog.csdn.net/yihuangol/article/details/107077323

个人总结：
service：
aidl文件，定义犯法
创建aidl的实现类
创建service onBinder返回一个 aidl的实现类（定义action）
java中启动service 隐士启动

client
复制aidl文件到当前工程 编译
创建一个ServiceConnection 对象 = aidl接口的Sub.asInterface(bindservice) 
mainActivity 中bindService(intent,ServiceConnection,Service.Bind_auto_create)
ondestory unbindService(connection);
对象去操作，跨进程通讯


1.遇到的问题
java.lang.SecurityException: Binder invocation to an incorrect interface
aidl两个文件的的目录名要完全一致
（https://blog.csdn.net/tfslovexizi/article/details/50698663）

注意事项：

