package os;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyFrame extends JFrame implements ActionListener{
	
	
	
	private static final long serialVersionUID = 1L;

	private static JFrame jf=new JFrame();
	
	private static MyPanel jp=new MyPanel();
	
	
	MystartJPanel mystartJpanel=null;
	JMenuBar jmb=null;
	MySetJPanel mysetjpanel=null;
	
	//菜单
	JMenu jm1=null;
	
	//设置
	JMenuItem jmi1=null;
	//退出
	JMenuItem jmi2=null;
	
	
	
	/**
	 * 开启后端控制
	 */
	public static void back_control() {

		
		
		new Thread(jp).start();
		jf.add(jp);
		jf.setSize(1100,600);
		jf.setLocation(200, 200);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.setVisible(true);
		jf.setTitle("工厂模拟自行车生产");
		
		jf.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				
				System.out.println(e.getWindow());
				Main.back_control=false;
				//System.out.println(e.toString());
				MyFrame.jp=new MyPanel();
				//清除后端的数据
				Data.clear0();
			}
		});
		
		//开启后端线程标志位
		Main.back_control=true;
	
		
		//创建各种线程
		CreateManyThreads t=new CreateManyThreads();
		t.CreateThread(Data.worker1num,"Worker1");
		t.CreateThread(Data.worker2num, "Worker2");
		t.CreateThread(Data.worker3num, "Worker3");
		t.CreateThread(Data.carriernum, "Carrier");
		
		t.ThreadStart();
		
	
	}
	public MyFrame() {
		
		mystartJpanel =new MystartJPanel();
		
		jmb=new JMenuBar();
		jm1=new JMenu("菜单");
		
		jmi1=new JMenuItem("设置");
		jmi1.addActionListener(this);
		jmi1.setActionCommand("start");
		
		
		jmi2=new JMenuItem("退出");
		jmi2.addActionListener(this);
		jmi2.setActionCommand("exit");
		
		jm1.add(jmi1);
		jm1.add(jmi2);
		jmb.add(jm1);
		
		this.setJMenuBar(jmb);
		this.add(mystartJpanel);
	
		
		
		Thread st=new Thread(mystartJpanel);
		st.start();
		
		this.setSize(800, 600);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("start")) {
			this.mystartJpanel.life=false;
			this.remove(mystartJpanel);
		
			//开启设置界面
			
			mysetjpanel=new MySetJPanel();
			this.add(mysetjpanel);
			this.setVisible(true);
			
		}else if(arg0.getActionCommand().equals("exit")) {
			
			
			//可以实现相应的界面
			System.exit(0);
		}
	}
	
	
	/**
	 * 修改界面的Box中车架、车轮、自行车的容量
	 * @param all   修改的值
	 * @param kind  BOX的种类 
	 */
	
	public static synchronized void changeBox(int all,int kind) {
		
		switch(kind) {
		case 1:
			MyPanel.box1all=all;
			System.out.println("jp.box1all:"+MyPanel.box1all);
			break;
		case 2:
			MyPanel.box2all=all;
			System.out.println("jp.box2all:"+MyPanel.box2all);
			break;
		case 3:
			MyPanel.box3all=all;
			System.out.println("jp.box3all:"+MyPanel.box3all);
			break;
			
		}
		return ;
	}
	
}
