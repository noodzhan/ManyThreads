package os;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


class MySetJPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	 
	public MySetJPanel(){
		
	
		this.setBounds(300, 200, 300, 150);
		this.setLayout(null);
		
		//设置左侧用户名文字
		JLabel jl=new JLabel("Box1的容量：");
		jl.setBounds(10, 10, 200, 18);
		final JTextField jtf_box1=new JTextField();	//用户名框
		jtf_box1.setBounds(100, 10, 150, 18);	//设置用户名框的宽，高，x值，y值
		
		//设置左侧密码文字
		JLabel jl2=new JLabel("Box2的容量：");
		jl2.setBounds(10, 50, 200, 18);
		final JTextField jtf_box2=new JTextField();	//密码框：为加密的***
		jtf_box2.setBounds(100, 50, 150, 18);	//设置密码框的宽，高，x值，y值
		
		
		JLabel jl3=new JLabel("Box3的容量：");
		jl3.setBounds(10, 90, 200, 18);
		final JTextField jtf_box3=new JTextField();	//用户名框
		jtf_box3.setBounds(100, 90, 150, 18);	//设置用户名框的宽，高，x值，y值
		
		
		JLabel jl4=new JLabel("工人1的速度：");
		jl4.setBounds(10, 130, 200, 18);
		final JTextField jtf_worker1speed=new JTextField();	//用户名框
		jtf_worker1speed.setBounds(100, 130, 150, 18);	//设置用户名框的宽，高，x值，y值
		
		
		JLabel jl4_1=new JLabel("工人1的线程数量：");
		jl4_1.setBounds(300, 130, 200, 18);
		final JTextField jtf_worker1num=new JTextField();	//用户名框
		jtf_worker1num.setBounds(420, 130, 150, 18);	//设置用户名框的宽，高，x值，y值
		
		
		
		JLabel jl5=new JLabel("工人2的速度：");
		jl5.setBounds(10, 170, 200, 18);
		final JTextField jtf_worker2speed=new JTextField();	//用户名框
		jtf_worker2speed.setBounds(100, 170, 150, 18);	//设置用户名框的宽，高，x值，y值
		
		
		JLabel jl5_1=new JLabel("工人2的线程数量：");
		jl5_1.setBounds(300, 170, 200, 18);
		final JTextField jtf_worker2num=new JTextField();	//用户名框
		jtf_worker2num.setBounds(420, 170, 150, 18);	//设置用户名框的宽，高，x值，y值
		
		
		
		JLabel jl6=new JLabel("工人3的速度：");
		jl6.setBounds(10, 210, 200, 18);
		final JTextField jtf_worker3speed=new JTextField();	//用户名框
		jtf_worker3speed.setBounds(100,210, 150, 18);	//设置用户名框的宽，高，x值，y值
		
		JLabel jl6_1=new JLabel("工人3的线程数量：");
		jl6_1.setBounds(300, 210, 200, 18);
		final JTextField jtf_worker3num=new JTextField();	//用户名框
		jtf_worker3num.setBounds(420,210, 150, 18);	//设置用户名框的宽，高，x值，y值
		
		
		
		
		JLabel jl7=new JLabel("搬运工的速度：");
		jl7.setBounds(10, 250, 200, 18);
		final JTextField jtf_carrierspeed=new JTextField();	//用户名框
		jtf_carrierspeed.setBounds(100, 250, 150, 18);	//设置用户名框的宽，高，x值，y值
		
		JLabel jl7_1=new JLabel("搬运工的线程数量：");
		jl7_1.setBounds(300, 250, 200, 18);
		final JTextField jtf_carriernum=new JTextField();	//用户名框
		jtf_carriernum.setBounds(420, 250, 150, 18);	//设置用户名框的宽，高，x值，y值
		
		
		
		
		
		//将jl、name、jl2、password添加到容器cp中
		this.add(jl);
		this.add(jtf_box1);
		this.add(jl2);
		this.add(jtf_box2);
		this.add(jl3);
		this.add(jtf_box3);
		
		this.add(jl4);
		this.add(jtf_worker1speed);
		this.add(jl4_1);
		this.add(jtf_worker1num);
		
		
		
		this.add(jl5);
		this.add(jtf_worker2speed);
		this.add(jl5_1);
		this.add(jtf_worker2num);
		
		
		this.add(jl6);
		this.add(jtf_worker3speed);
		this.add(jl6_1);
		this.add(jtf_worker3num);
		
		this.add(jl7);
		this.add(jtf_carrierspeed);
		this.add(jl7_1);
		this.add(jtf_carriernum);
		
		
		
		//设置初始值
		jtf_box1.setText("10");
		jtf_box2.setText("10");
		jtf_box3.setText("10");
		jtf_worker1speed.setText("1");
		jtf_worker2speed.setText("1");
		jtf_worker3speed.setText("1");
		jtf_carrierspeed.setText("1");
		jtf_worker1num.setText("1");
		jtf_worker2num.setText("1");
		jtf_worker3num.setText("5");
		jtf_carriernum.setText("1");
		
		
		
		
		//确定按钮
		JButton jb=new JButton("确定");	//添加一个确定按钮
		jb.addActionListener(new ActionListener(){		//为确定按钮添加监听事件
			
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				if(jtf_box1.getText().trim().length()==0
						||jtf_box2.getText().trim().length()==0
						||jtf_box3.getText().trim().length()==0
						||jtf_worker1speed.getText().trim().length()==0
						||jtf_worker2speed.getText().trim().length()==0
						||jtf_worker3speed.getText().trim().length()==0
						||jtf_carrierspeed.getText().trim().length()==0
						
					){
						JOptionPane.showMessageDialog(null, "设置数目不允许为空");
						return;
				}else {
					
					JOptionPane.showMessageDialog(null, "设置成功");
					
					Data.box1size=Integer.valueOf(jtf_box1.getText().trim());
					Data.box2size=Integer.valueOf(jtf_box2.getText().trim());
					Data.box3size=Integer.valueOf(jtf_box3.getText().trim());
					
					
					Data.worker1speed=Integer.valueOf(jtf_worker1speed.getText().trim());
					Data.worker2speed=Integer.valueOf(jtf_worker2speed.getText().trim());
					Data.worker3speed=Integer.valueOf(jtf_worker3speed.getText().trim());
					
					Data.carrarspeed=Integer.valueOf(jtf_carrierspeed.getText().trim());
					
					Data.worker1num=Integer.valueOf(jtf_worker1num.getText().trim());
					Data.worker2num=Integer.valueOf(jtf_worker2num.getText().trim());
					Data.worker3num=Integer.valueOf(jtf_worker3num.getText().trim());
					Data.carriernum=Integer.valueOf(jtf_carriernum.getText().trim());
					
					
					
					MyFrame.back_control();					
					
				}
				
				
			}
		});
		
		jb.setBounds(80, 300, 60, 18);	//设置确定按钮的宽，高，x值，y值
		this.add(jb);	//将确定按钮添加到cp容器中
		
		//重置按钮
		final JButton button = new JButton();
		button.setText("重置");
		button.addActionListener(new ActionListener(){		//为重置按钮添加监听事件
			//同时清空name、password的数据
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成方法存根
				jtf_box1.setText("");
				jtf_box2.setText("");
				jtf_box3.setText("");
				jtf_worker1speed.setText("");
				jtf_worker2speed.setText("");
				jtf_worker3speed.setText("");
				jtf_carrierspeed.setText("");
				
				jtf_worker1num.setText("");
				jtf_worker2num.setText("");
				jtf_worker3num.setText("");
				jtf_carriernum.setText("");
				
				
				//清除后端的数据
				Data.clear0();
				
				
			}
		});
		button.setBounds(150, 300, 60, 18);	//设置重置按钮的宽，高，x值，y值
		this.add(button);
	}
	
}