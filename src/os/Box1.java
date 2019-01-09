package os;

import java.util.concurrent.Semaphore;

/**
 * @author zhihu
 *
 */
public class Box1 {
	
	public volatile int all;  //资源的数目
	public int maxsize;
	public Semaphore semaphore1;//互斥信号量
	public Semaphore notfull;
	public Semaphore notempty=new Semaphore(0);
	
	
	public Box1(int all, int maxsize, Semaphore semaphore1) {
		super();
		this.all = all;
		this.maxsize = maxsize;
		this.semaphore1 = semaphore1;
		notfull=new Semaphore(maxsize);
		
		
		
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
      semaphore1.acquire();  
      try {  
    	  all++;
    	  Data.frame++;
    	  MyPanel.box1all=all;
    	  Thread.sleep(1000);
      } finally {  
        // 退出核心区  
    	  semaphore1.release();  
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
      semaphore1.acquire();  
      try {  
    	  all--;
    	  MyPanel.box1all=all;
    	  Thread.sleep(1000);
       
      } finally {  
        // 退出核心区  
    	  semaphore1.release();  
        // 增加非满的信号量，允许加入商品  
        notfull.release();  
      }  
    }  
    
    
	
	
}
