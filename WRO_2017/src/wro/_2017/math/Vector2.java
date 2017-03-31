package wro._2017.math;


public class Vector2{
	public float x,y;
	
	
	
	public Vector2() {
		super();
	}

	public Vector2(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}


	public void normailze(){
		float len = length();
		x /= len;
		y /= len;
	}
	
	public void scale(float len){
		x *= len;
		y *= len;
	}
	
	public float length() {
		return (float) Math.sqrt((x*x+y*y));
	}
	
	public float dot(Vector2 b){
		return x*b.x+y*b.y;
	}
	
	public float angle(Vector2 test){
		float alpha = dot(test)/(length()*test.length());
		return ((float) Math.toDegrees(Math.acos(alpha)))*singAngle(test);
	}
	
	public int singAngle(Vector2 test){
		Vector3 v3 = new Vector3(x, y, 0);
		Vector3 v3_t = new Vector3(test.x, test.y, 0);
		return v3.cross(v3_t).y>0?-1:1;
	}
	
	public void add(Vector2 b){
		x+=b.x;
		y+=b.y;
	}
	
	public void sub(Vector2 b){
		x-=b.x;
		y-=b.y;
	}
	
}
