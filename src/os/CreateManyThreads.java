package os;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class CreateManyThreads {
	
	private Box1 box1;
	private Box2 box2;
	private Box3 box3;
	
	private ArrayList<Thread> worker1Threads=null;
	private ArrayList<Thread> worker2Threads=null;
	private ArrayList<Thread> worker3Threads=null;
	private ArrayList<Thread> carrierThreads=null;
	

	
	public CreateManyThreads() {
		
		box1=new Box1(0,Data.box1size,new Semaphore(1));
		box2=new Box2(0,Data.box2size,new Semaphore(1));
		box3=new Box3(0,Data.box3size,new Semaphore(1));
		
		
		
		worker1Threads=new ArrayList<Thread>();
		worker2Threads=new ArrayList<Thread>();
		worker3Threads=new ArrayList<Thread>();
		carrierThreads=new ArrayList<Thread>();
	}
	
	/**
	 * 
	 * @param num   创建线程的数量
	 * @param kind  创建线程的种类
	 */
	public void CreateThread(int num ,String kind) {
		switch(kind) {
		case "Worker1":
			for(int i=0;i<num;i++) {
				worker1Threads.add(new Thread(new Worker1(box1,Data.worker1speed),"worker1_"+i));
			}
			break;
		case "Worker2":
			for(int i=0;i<num;i++) {
				worker2Threads.add(new Thread(new Worker2(box2,Data.worker2speed),"worker2_"+i));
			}
			
			break;
		case "Worker3":
			for(int i=0;i<num;i++) {
				worker3Threads.add(new Thread(new Worker3(box1,box2,box3,Data.worker3speed),"worker3_"+i));
			}
			
			break;
			
		case "Carrier":
			for(int i=0;i<num;i++) {
				carrierThreads.add(new Thread(new Carrier(box3,Data.carrarspeed),"carrier_"+i));
			}
			break;
		
		
		}
		

	}
	
	/**
	 * 开启所有线程
	 */
	public void ThreadStart() {
		
		
		System.out.println(worker1Threads.size());
		System.out.println(worker2Threads.size());
		System.out.println(worker3Threads.size());
		System.out.println(carrierThreads.size());
		for(Thread t:worker1Threads) {
			t.start();
		}
		
		for(Thread t:worker2Threads) {
			t.start();
		}
		for(Thread t:worker3Threads) {
			t.start();
		}
		for(Thread t:carrierThreads) {
			t.start();
		}
		

		
		
	}
	
}
