package os;

public class Data {
	
	static int frame=0; //车架
	static int wheel=0;//车轮
	static int bicycle=0;//自行车
	static int move=0;
	
	static int box1size;
	static int box2size;
	static int box3size;
	static int worker1speed;
	static int worker2speed;
	static int worker3speed;
	static int carrarspeed;
	
	
	static int worker1num;
	static int worker2num;
	static int worker3num;
	static int carriernum;
	
	
	//重置清零操作
	static void clear0() {
		frame=0;
		wheel=0;
		bicycle=0;
		move=0;
		box1size=0;
		box2size=0;
		box3size=0;
		worker1speed=0;
		worker2speed=0;
		worker3speed=0;
		carrarspeed=0;
		worker1num=0;
		worker2num=0;
		worker3num=0;
		carriernum=0;
		MyPanel.box1all=0;
		MyPanel.box2all=0;
		MyPanel.box3all=0;
	}
	
	
	static void clear_Boxall(Box1 box1,Box2 box2,Box3 box3) {
		
		box1.all=0;
		box2.all=0;
		box3.all=0;
		
	}
	
	
	
	
}
