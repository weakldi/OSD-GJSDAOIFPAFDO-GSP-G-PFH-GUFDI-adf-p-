package wro._2017.core;

import lejos.hardware.ev3.EV3;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.Port;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;

public class Robot {
	private EV3 ev3;
	
	private Port	OUT_A,
					OUT_B,
					OUT_C,
					OUT_D,
					IN_1,
					IN_2,
					IN_3,
					IN_4;
	//A & D == greifer
	//B & C == driver
	private EV3MediumRegulatedMotor motor_A;
	private EV3LargeRegulatedMotor  motor_B;
	private EV3LargeRegulatedMotor  motor_C;
	private EV3MediumRegulatedMotor motor_D;
	
	//SENSOREN
	//
	
	
	private Chassis chassis;
	private MovePilot movementControler;
	private boolean initialized = false;
	
	public Robot(EV3 ev3){
		this.ev3 = ev3;
	}
	
	public void init(){
		if(initialized)
			return;
		//Portsetup
		OUT_A = ev3.getPort("A");
		OUT_B = ev3.getPort("B");
		OUT_C = ev3.getPort("C");
		OUT_D = ev3.getPort("D");
		
		IN_1  = ev3.getPort("S1");
		IN_2  = ev3.getPort("S2");
		IN_3  = ev3.getPort("S3");
	    IN_4  = ev3.getPort("S4");
	    //Motorsetup
	    motor_A = new EV3MediumRegulatedMotor(OUT_A);
	    motor_B = new EV3LargeRegulatedMotor(OUT_B);
	    motor_C = new EV3LargeRegulatedMotor(OUT_C);
	    motor_D = new EV3MediumRegulatedMotor(OUT_D);
	    //Sensorsetup
	    
	    //Movementsetup
	    Wheel wheel1 = WheeledChassis.modelWheel(motor_B, 4.2).offset(-7.1);
		Wheel wheel2 = WheeledChassis.modelWheel(motor_C, 4.2).offset(7.1);
		chassis = new WheeledChassis(new Wheel[] { wheel1, wheel2 }, WheeledChassis.TYPE_DIFFERENTIAL);
		movementControler = new MovePilot(chassis);
	    
	    initialized = true;
	}

	public EV3 getEv3() {
		return ev3;
	}

	public Port getOUT_A() {
		return OUT_A;
	}

	public Port getOUT_B() {
		return OUT_B;
	}

	public Port getOUT_C() {
		return OUT_C;
	}

	public Port getOUT_D() {
		return OUT_D;
	}

	public Port getIN_1() {
		return IN_1;
	}

	public Port getIN_2() {
		return IN_2;
	}

	public Port getIN_3() {
		return IN_3;
	}

	public Port getIN_4() {
		return IN_4;
	}

	public EV3MediumRegulatedMotor getMotor_A() {
		return motor_A;
	}

	public EV3LargeRegulatedMotor getMotor_B() {
		return motor_B;
	}

	public EV3LargeRegulatedMotor getMotor_C() {
		return motor_C;
	}

	public EV3MediumRegulatedMotor getMotor_D() {
		return motor_D;
	}

	public Chassis getChassis() {
		return chassis;
	}

	public MovePilot getMovementControler() {
		return movementControler;
	}

	public boolean isInitialized() {
		return initialized;
	}
}
