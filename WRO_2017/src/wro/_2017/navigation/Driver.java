package wro._2017.navigation;

import java.util.ArrayList;
import java.util.Vector;

import lejos.robotics.navigation.Waypoint;
import wro._2017.core.Robot;
import wro._2017.core.WRO;
import wro._2017.math.Vector2;

public class Driver {
	private Robot robot;
	
	public ArrayList<Waypoint> path;
	
	private float x,y,rotz;
	private Vector2 heading = new Vector2(0, 1);
	public Driver(Robot robot) {
		super();
		this.robot = robot;
		this.path = new ArrayList<>();
		x = 0;
		y = 0;
		rotz = 0;
	}

	public Driver(Robot robot, ArrayList<Waypoint> path, float x, float y, float rotz) {
		super();
		this.robot = robot;
		this.path = path;
		this.x = x;
		this.y = y;
		this.rotz = rotz;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setRotz(float rotz) {
		this.rotz = rotz;
	}

	public Driver(Robot robot, ArrayList<Waypoint> path) {
		super();
		this.robot = robot;
		this.path = path;
	}

	public void follow(){
		for (Waypoint waypoint : path) {
			
			//		__ 
			//Dir = AB = B-A
			Vector2 dir = new Vector2(waypoint.x - x, waypoint.y - y);
			
//			dir.x = x-waypoint.x;
//			dir.y = y-waypoint.y;
			float rot = dir.angle(heading);
			heading.x = dir.x;
			heading.y = dir.y;
			heading.normailze();
			System.out.println("R:\t" + rot);
			System.out.println(x + " " + y);
			robot.getMovementControler().rotate(rot);
			while(robot.getMovementControler().isMoving()){
				
			}
			rotz+=rot;
			robot.getMovementControler().travel(dir.length());
			WRO.watiTillStop(robot);
			x = waypoint.x;
			y = waypoint.y;
		}
	}
	
	
	public Robot getRobot() {
		return robot;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	public ArrayList<Waypoint> getPath() {
		return path;
	}

	public void setPath(ArrayList<Waypoint> path) {
		this.path = path;
	}
	
	
}
