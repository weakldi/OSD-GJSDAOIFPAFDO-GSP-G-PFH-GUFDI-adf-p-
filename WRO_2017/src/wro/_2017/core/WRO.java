package wro._2017.core;

//import java.sql.Driver; <-----
import lejos.hardware.ev3.EV3;
import lejos.hardware.ev3.LocalEV3;
import lejos.robotics.navigation.Waypoint;
import wro._2017.grabber.Grabber;
import wro._2017.navigation.Driver;

public class WRO {
//	enum 
	public static void main(String[] args) throws InterruptedException {
		EV3 ev3 = LocalEV3.get();
		Robot robot = new Robot(ev3);
		robot.init();
		Driver driver = new Driver(robot);
		
		
//		while(robot.getMovementControler().isMoving()){}
		
//		robot.getMovementControler().travel(30);
//		watiTillStop(robot);
//		robot.getMovementControler().rotate(90);
//		watiTillStop(robot);
//		robot.getMovementControler().travel(45);
//		watiTillStop(robot);
//		robot.getMovementControler().rotate(90);
//		watiTillStop(robot);
//		robot.getMovementControler().travel(7);
//		watiTillStop(robot);
		
		
		
//		try {
//			SVGMapLoader loader = new SVGMapLoader(new FileInputStream("map2.svg"));
//			LineMap MAP = loader.readLineMap();
		
		driver.getPath().add(new Waypoint(0 , 45));
		driver.getPath().add(new Waypoint(44, 45));
		driver.getPath().add(new Waypoint(44, 23));
		
//		
		driver.follow();
			
//		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		Grabber g = new Grabber(robot.getMotor_A(), robot.getMotor_D()); 
//		g.grab();
//		waitMillis(1000);
//		g.open();
		watiTillStop(robot);
		System.exit(1);
	}
	public static void waitMillis(long delay){
		long timeStop = System.currentTimeMillis()+delay;
		while(true)
			if(System.currentTimeMillis()>=timeStop)break;
	}
	public static void watiTillStop(Robot robot){
		while(robot.getMovementControler().isMoving()){}
	}
}
