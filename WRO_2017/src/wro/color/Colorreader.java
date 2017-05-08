package wro.color;

import javax.swing.colorchooser.ColorSelectionModel;

import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;

public class Colorreader {
	private EV3ColorSensor l,r;
	private SensorMode rgbl;
	
	public Colorreader(EV3ColorSensor l ,EV3ColorSensor r){
		this.l = l;
		this.r = r;
		rgbl = l.getRGBMode();
//		int colorid = l.getColorID();
		
		
	}
	
	public int getColorL(){
//		float[] data = new float[rgbl.sampleSize()];
//		rgbl.fetchSample(data, 0);
//		for(int i = 0; i < data.length;i++)System.out.println(data [i]);
		return l.getColorID();
	}
	
	public int getColorR(){
		return r.getColorID();
	}
}
