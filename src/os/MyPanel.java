package os;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements Runnable ,KeyListener{

	//public JFrame jf=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static volatile int box1all=0;
	public static volatile int box2all=0;
	public static volatile int box3all=0;
	
	
	
	public String Box1Size="";
	public String Box2Size="";
	public String Box3Size="";
	
	
	public String Worker1speed="";
	public String Worker2speed="";
	public String Worker3speed="";
	public String Carrierspeed="";
	

	
	public void paint(Graphics g) {
		super.paint(g);
		//g.setColor(Color.WHITE);
		g.fillRect(0, 0, 800, 600);//控制面板
		
		
		this.drawBox(g);
		
		this.showBox_frame(g,box1all,1);
		this.showBox_frame(g,box2all,2);
		this.showBox_frame(g,box3all,3);
		
		showInfo(g);
		
	}
	
	
	
	//画箱子函数
	private void drawBox(Graphics g) {
	
		g.setColor(Color.white);
		g.fillRect(200, 50, 100, 200);//画出BOx1
		g.fillRect(200,300, 100, 200);//画出BOx2
		g.fillRect(500,80, 100, 400);//画出BOx3
		
		g.setColor(Color.black);
		g.drawString("车架", 240, 240);//写出车架数目
		g.drawString("车轮", 240, 490);//写出车轮数目
		g.drawString("自行车", 540, 470);//写出自行车
		
		
		
	}
	
	

	public MyPanel() {
		//注册监听
		this.addKeyListener(this);
		this.setFocusable(true);
	}
	
	
	
	/**
	 * 在界面上显示BOX内含有车架、车轮、自行车的数量
	 * @param g  画笔
	 * @param all 车架的数量
	 * @param kind BOX的种类
	 */
	public void showBox_frame(Graphics g,int all,int kind) {
		
		String s=String.valueOf(all);
	
		g.setColor(Color.black);
		Font f=new Font("宋体", 0, 20);
		g.setFont(f);
		switch(kind) {
		
		case 1:
			g.drawString(s, 240, 100);
			break;
		case 2:
			g.drawString(s, 240, 350);
			break;
		case 3:
			g.drawString(s, 540, 300);
			break;
		}
		
		return;
	}
	
	
	/**
	 * 暂停后显示出车架、车轮、自行车的总产量
	 * @param g
	 */
	public void showInfo(Graphics g) {
		
		g.setColor(Color.red);
		g.drawString("自行车的总数目: "+String.valueOf(Data.bicycle), 810, 20);
		g.drawString("车轮的总数目: "+String.valueOf(Data.wheel), 810, 50);
		g.drawString("车架的总数目: "+String.valueOf(Data.frame), 810, 80);
		g.drawString("搬走的总自行车: "+String.valueOf(Data.move), 810, 110);
		
		
		
		//显示设置的数据
		g.drawString("Box1的容量: "+String.valueOf(Data.box1size), 810, 300);
		g.drawString("Box2的容量: "+String.valueOf(Data.box2size), 810, 330);
		g.drawString("Box3的容量: "+String.valueOf(Data.box3size), 810, 360);
		g.drawString("工人1的速度: "+String.valueOf(Data.worker1speed), 810, 390);
		g.drawString("工人2的速度: "+String.valueOf(Data.worker2speed), 810, 420);
		g.drawString("工人3的速度: "+String.valueOf(Data.worker3speed), 810, 450);
		g.drawString("搬运工的速度: "+String.valueOf(Data.carrarspeed), 810, 480);
		
		
		
	}
	 
	
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			
		try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		this.repaint();
		
		}
	}



	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		System.out.println(arg0.toString());
		if(arg0.getKeyCode()==KeyEvent.VK_SPACE) {
			System.out.println("空格键按下");
			Main.flag=false;
			
		}else if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
			
			Main.flag=true;
			System.out.println("enter键按下");
		}
	}



	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode()==KeyEvent.VK_SPACE) {
			
			System.out.println("空格键松开");
		}
	}



	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

