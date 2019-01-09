package os;

public class Worker1 implements Runnable{

	private int speed;
	private Box1 box1;
	
	public Worker1(Box1 box1,int speed) {
		this.box1=box1;
		this.speed=speed;
	}
	

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(Main.flag) {
			if(Main.back_control) {
				for(int i=0;i<speed;i++)
					try {
						box1.put();
						System.out.println(Thread.currentThread().getName()+"生产"+speed+"车架");
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
		}
	}
	

}
