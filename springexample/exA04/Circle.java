package springexample.exA04;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

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
	
	@Resource
	public void setCenter(Point center) {
		this.center = center;
	}
	
	@PostConstruct
	public void initializeCircle(){
		System.out.println("Init of circle");
	}
	
	@PreDestroy
	public void destroyCircle(){
		System.out.println("Destroy of circle");
	}
	

}
