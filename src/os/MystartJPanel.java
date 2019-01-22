package os;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MystartJPanel extends JPanel implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean b=true;	
	boolean life=true;
	public void paint (Graphics  g) {
		super.paint(g);
		g.fillRect(0, 0, 600, 400);
		if(b) {
			g.setColor(Color.red);
			Font f=new Font("华文新魏",Font.BOLD,30);
			g.setFont(f);
			g.drawString("模拟生产自行车工厂", 140,200);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("start");
			b=!b;
			this.repaint();
			if(!life) {
				break;
			}
		}
	}
	

	
	
	
}

