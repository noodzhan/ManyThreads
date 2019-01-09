package os;


public class Carrier implements Runnable{
	private Box3 box3;
	private int speed;
		
	public Carrier(Box3 box3, int speed) {
		super();
		this.box3 = box3;
		this.speed = speed;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(Main.back_control) {
			
			if(Main.flag) {
				try {
					
					for(int i=0;i<speed;i++)
						box3.take();
					Data.move++;
					System.out.println(Thread.currentThread().getName()+"搬出"+speed+"自行车");
					
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
