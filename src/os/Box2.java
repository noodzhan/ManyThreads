package os;

import java.util.concurrent.Semaphore;

public class Box2 {
	public volatile int all;
	public int maxsize;
	
	public Semaphore semaphore2;//互斥信号量
	public Semaphore notfull;
	public Semaphore notempty=new Semaphore(0);

	public Box2(int all, int maxsize, Semaphore semaphore2) {
		super();
		this.all = all;
		this.maxsize = maxsize;
		this.semaphore2 = semaphore2;
		this.notfull=new Semaphore(maxsize);
		
		
	
	
	}
	
	
	 /** 
     * 把商品放入B0x1.<br> 
     *  
     * @param x 
     * @throws InterruptedException 
     */  
    public void put() throws InterruptedException {  
      // 保证非满  
      notfull.acquire();  
      // 保证不冲突  
      semaphore2.acquire();  
      try {  
        // 增加库存  
    	  all++;
    	  Data.wheel++;
    	  MyPanel.box2all=all;
    	  Thread.sleep(1000);
      } finally {  
        // 退出核心区  
    	  semaphore2.release();  
        // 增加非空信号量，允许获取商品  
        notempty.release();  
      } 
    }
    
    /** 
     * 从仓库获取商品 
     *  
     * @return 
     * @throws InterruptedException 
     */  
    public void take() throws InterruptedException {  
      // 保证非空  
      notempty.acquire();  
      // 核心区  
      semaphore2.acquire();  
      try {  
        // 减少库存  
    	  all--;
    	  MyPanel.box2all=all;
    	  Thread.sleep(1000);
      } finally {  
        // 退出核心区  
    	  semaphore2.release();  
        // 增加非满的信号量，允许加入商品  
        notfull.release();  
      }  
    }  
    
    
	
    /** 
     * 从仓库获取商品 
     *  
     * @return 
     * @throws InterruptedException 
     */  
    public void take(int speed) throws InterruptedException {  
      // 保证非空  
      notempty.acquire();  
      // 核心区  
      semaphore2.acquire();  
      try {  
        // 减少库存  
    	  if(all>=speed)
    		  all-=speed;
    	  else
    		  System.out.println("车轮不够");
    	  MyPanel.box2all=all;
    	  Thread.sleep(1000);
      } finally {  
        // 退出核心区  
    	  semaphore2.release();  
        // 增加非满的信号量，允许加入商品  
        notfull.release();  
      }  
    }  
    
	
	
	
	
	
	
	
	
	
	
}
