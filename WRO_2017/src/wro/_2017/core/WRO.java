package wro._2017.core;

import java.util.ArrayList;

import lejos.hardware.Button;
//import java.sql.Driver; <-----
import lejos.hardware.ev3.EV3;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;
import lejos.robotics.navigation.Waypoint;
import lejos.robotics.navigation.WaypointListener;
import wro._2017.grabber.Grabber;
import wro._2017.navigation.Driver;
import wro.color.Colorreader;

public class WRO {
//	enum 
	public static void main(String[] args) throws InterruptedException {
		System.out.print("INIT...");
		EV3 ev3 = LocalEV3.get();
		Robot robot = new Robot(ev3);
		robot.init();
		Driver driver = new Driver(robot,new ArrayList<Waypoint>(), 100,118,0);
		Colorreader cr = new Colorreader(new EV3ColorSensor(robot.getIN_4()), new EV3ColorSensor(robot.getIN_1()));
		System.out.println("Done!");
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
//		
//		driver.getPath().add(new Waypoint(0 , 45));
//		driver.getPath().add(new Waypoint(44, 45));
//		driver.getPath().add(new Waypoint(44, 23));
//		
//		driver.getPath().add(new Waypoint(58.66,118.3));
//		driver.getPath().add(new Waypoint(58.26,185.61));
//		

//		cr.getColorL();
//		waitMillis(5000);
		while(!Button.ENTER.isDown())waitMillis(1);
		Grabber g = new Grabber(robot.getMotor_A(), robot.getMotor_D());
		g.moveTo(0.5f);
		driver.getPath().add(new Waypoint(57.08,118));
		driver.getPath().add(new Waypoint(57.08,184.83));
		driver.getPath().add(new Waypoint(27.48,184.83));
		
//		driver.getPath().add(new Waypoint(57.48,118));
//		driver.getPath().add(new Waypoint(57.48,192.11));
//		driver.getPath().add(new Waypoint(36.81,192.31));
		
		driver.follow();
		driver.getPath().clear();
		
		int color = cr.getColorR();
		System.out.println(color);
//		waitMillis(4000);
		if(color >=0){
			robot.getMovementControler().travel(-4);
			watiTillStop(robot);
			robot.getMovementControler().rotate(-90);
			
			g.bottom();
			robot.getMovementControler().travel(5);
			watiTillStop(robot);
			g.grab();
			g.moveTo(01f);
			robot.getMovementControler().travel(-5);
			watiTillStop(robot);
			robot.getMovementControler().rotate(90);
			robot.getMovementControler().travel(4);
			watiTillStop(robot);
		}else{
			robot.getMovementControler().travel(2);
			watiTillStop(robot);
			robot.getMovementControler().rotate(90);
			watiTillStop(robot);
			robot.getMovementControler().travel(5);
			watiTillStop(robot);
			
			color = cr.getColorR();
			robot.getMovementControler().rotate(-90);
			g.bottom();
			robot.getMovementControler().travel(2);
			watiTillStop(robot);
			g.grab();
			g.top();
		}
		
		driver.getPath().add(new Waypoint(57.67,183.83));
		driver.getPath().add(new Waypoint(57.67,114.16));
		switch (color) {
		case Color.RED:
			driver.getPath().add(new Waypoint(42.91,72.43));
			driver.getPath().add(new Waypoint(50.42,66.92));

			break;
		case Color.BLUE:
//			driver.getPath().add(new Waypoint(57.67,72.43));
//			driver.getPath().add(new Waypoint(57.67,72.43));
			driver.getPath().add(new Waypoint(29.33,59.84));
			driver.getPath().add(new Waypoint(29.33,44.09));

			break;
		case Color.GREEN:
//			driver.getPath().add(new Waypoint(57.67,114.16));
			driver.getPath().add(new Waypoint(78.93,91.92));
			break;
			
		case Color.YELLOW:
			driver.getPath().add(new Waypoint(57.67,78.73));
			driver.getPath().add(new Waypoint(103.34,45.67));
			driver.getPath().add(new Waypoint(94.68,37));
			break;
			
		case Color.BLACK:
//			driver.getPath().add(new Waypoint(57.67,114.16));
//			driver.getPath().add(new Waypoint(57.67,114.16));
			driver.getPath().add(new Waypoint(36.02,92.51));
			break;
		default:
			driver.getPath().add(new Waypoint(57.67,69.29));
			break;
		}
		driver.follow();
		g.moveTo(0.4f);
		g.open();
		driver.getPath().clear();
		driver.getPath().add(new Waypoint(57.87,114.16));
		driver.getPath().add(new Waypoint(57.87,137.78));
		driver.getPath().add(new Waypoint(45.86,137.78));
		driver.getPath().add(new Waypoint(45.86,137.78));
		driver.getPath().add(new Waypoint(79.72,158.65));
		driver.getPath().add(new Waypoint(57.67,137));
		driver.getPath().add(new Waypoint(57.67,118.49));
		driver.getPath().add(new Waypoint(100.98,118.49));

		driver.follow();
		waitMillis(4000);
//		Color
//		
//		g.bottom();
//		
//		g.moveTo(0.4f);
//		g.bottom();
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
