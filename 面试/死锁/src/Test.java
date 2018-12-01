// 死锁程序 经常发生在同步中嵌套同步
public class Test {
    public static void main(String[] args) {

        new Thread(new DeadLockThread(true)).start();

//		如果让线程休眠一毫秒，发现有时能锁上有时锁不上。休眠两毫秒基本锁不上。
//		这说明判断锁还是比较耗时的操作
//		try {
//			Thread.sleep(1);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

        new Thread(new DeadLockThread(false)).start();
    }

}

class DeadLockThread implements Runnable {

    private boolean flag;

    public DeadLockThread(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        if (flag) {
            // 同步中嵌套同步
            // 一个线程执行if里面的，一个线程执行else里面的
            synchronized (MyLock.locka) {
                System.out.println("if...locka");
                synchronized (MyLock.lockb) {
                    System.out.println("if...lockb");
                }
            }
        } else {
            synchronized (MyLock.lockb) {
                System.out.println("else...lockb");
                synchronized (MyLock.locka) {
                    System.out.println("else...locka");
                }
            }
        }
    }
}

// 定义一个类来创建两把锁
class MyLock {
    static Object locka = new Object();
    static Object lockb = new Object();
}