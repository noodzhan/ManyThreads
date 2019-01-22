package os;

public class Worker3 implements Runnable {
	private int speed;
	
	private Box1 box1;
	private Box2 box2;
	private Box3 box3;
	
	
	public Worker3(Box1 box1,Box2 box2,Box3 box3,int speed) {
		this.box1=box1;
		this.box2=box2;
		this.box3=box3;
		this.speed=speed;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(Main.back_control) {
			
			if(Main.flag) {
				
				try {
					for(int i=0;i<speed;i++)
						box1.take();
					for(int i=0;i<speed;i++)
						box2.take();
					for(int i=0;i<speed;i++)
						box2.take();
					for(int i=0;i<speed;i++)
						box3.put();
					System.out.println(Thread.currentThread().getName()+"生产"+speed+"自行车");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}












