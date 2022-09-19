package creationalDesignPattern.singleton.lazy2;

/**
 * @name: Singleton
 * @description: Lazy Load (类加载不会导致该单实例对象被创建，而是首次使用该对象时才会创建) 2: thread-safe
 *                                                                                 getInstance()绝大部分都是读操作，读操作是thread-safe的，没有必要让每个thread必须持有同步锁(synchronized)才能call getInstance()以影响performance, 需要调整加锁时机
 * @author: Flora Zhong
 * @date: 8/16/22
 */

public class Singleton {
	// 声明一个Singleton类型的变量instance
	private static Singleton instance;

	// 私有构造方法
	private Singleton() {
	}

	// 对外提供公共访问方式
	// synchronized makes sure only one thread can access getInstance(), 在这个thread上执行完此方法，才能有另一个thread access getInstance()
	public static synchronized Singleton getInstance() {
		// check the variable instance是否为null: 如果为null, 说明还没有创建Singleton类的object, 则需要创建一个并返回；如果不为null, 直接返回instance
		if (instance == null) {
			// thread 1 gets the execution right of CPU进入到该check里，创建一个Singleton object, 然后返回，执行完getInstance()
			// 此时thread 2才能get the execution right of CPU to access getInstance(), 但此时instance已经不为null了，thread 2不会再创建一个singleton object了，而是直接返回instance
			instance = new Singleton();
		}
		return instance;
	}
}
