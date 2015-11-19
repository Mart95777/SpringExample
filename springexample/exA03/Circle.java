package springexample.exA03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


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
	
	@Autowired
	@Qualifier("forcircle")
	public void setCenter(Point center) {
		this.center = center;
	}
	

}
