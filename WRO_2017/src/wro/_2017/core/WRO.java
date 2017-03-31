package wro._2017.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.XMLStreamException;

import lejos.hardware.ev3.EV3;
import lejos.hardware.ev3.LocalEV3;
import lejos.remote.nxt.FileInfo;
import lejos.robotics.mapping.EV3NavigationModel;
import lejos.robotics.mapping.LineMap;
import lejos.robotics.mapping.SVGMapLoader;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.navigation.Waypoint;
import wro._2017.navigation.Driver;

public class WRO {
	public static void main(String[] args) {
		EV3 ev3 = LocalEV3.get();
		System.out.println(ev3);
		Robot robot = new Robot(ev3);
		robot.init();
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
		Driver driver = new Driver(robot);
		driver.getPath().add(new Waypoint(0, 30));
		driver.getPath().add(new Waypoint(30,30));
		driver.getPath().add(new Waypoint(-30,30));
		driver.getPath().add(new Waypoint(10,10));
		driver.follow();
			
//		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		watiTillStop(robot);
		System.exit(1);
	}
	
	public static void watiTillStop(Robot robot){
		while(robot.getMovementControler().isMoving()){}
	}
}
