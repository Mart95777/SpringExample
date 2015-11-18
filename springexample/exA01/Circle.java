package springexample.exA01;

public class Circle implements Shape {
	private Point center;
	
	@Override
	public void draw() {
		System.out.println("--> circle");
		System.out.println("Circle is drawn! ("+ center.getX()+ ", "+center.getY()+")");
		
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}
	

}
