package wro._2017.grabber;

import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.robotics.LinearActuator;

public class Grabber {
	private EV3MediumRegulatedMotor vert, grab;
	private float linearPos = 0;
	private float MAX_ROT = 5.5f;
	public Grabber(EV3MediumRegulatedMotor vert, EV3MediumRegulatedMotor grab) {
		super();
		this.vert = vert;
		this.grab = grab;
	}
	private final int rot = 65;
	public void grab(){
		grab.rotate(rot);
	}
	
	public void open(){
		grab.rotate(-rot);
	}
	
	public void top(){
		vert.rotate((int) ((MAX_ROT-linearPos)*360));
		
		linearPos = MAX_ROT;
	}
	
	public void moveTo(float percent){
		float pos = (MAX_ROT*percent);
		float rotations = pos-linearPos;
		vert.rotate((int) (rotations*360));
		linearPos = pos;
	}
	
	
	public void bottom(){
		vert.rotate((int) (-linearPos*360));
		linearPos = 0;
	}
	public EV3MediumRegulatedMotor getVert() {
		return vert;
	}

	public void setVert(EV3MediumRegulatedMotor vert) {
		this.vert = vert;
	}

	public EV3MediumRegulatedMotor getGrab() {
		return grab;
	}

	public void setGrab(EV3MediumRegulatedMotor grab) {
		this.grab = grab;
	}
	
	

}
