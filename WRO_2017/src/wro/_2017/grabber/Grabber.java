package wro._2017.grabber;

import lejos.hardware.motor.EV3MediumRegulatedMotor;

public class Grabber {
	private EV3MediumRegulatedMotor vert, grab;

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
