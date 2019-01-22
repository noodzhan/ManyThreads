package os;

public class Worker2 implements Runnable{

	private int speed;
	private Box2 box2;
	
	
	public Worker2(Box2 box2,int speed) {
		this.box2=box2;
		this.speed=speed;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(Main.back_control) {
			if(Main.flag) {
				
				try {
					for(int i=0;i<speed;i++)
						box2.put();
					System.out.println(Thread.currentThread().getName()+"生产"+speed+"车轮");
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
