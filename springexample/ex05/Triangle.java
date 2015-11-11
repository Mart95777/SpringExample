package springexample.ex05;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import springexample.ex05.Point;

public class Triangle implements ApplicationContextAware, BeanNameAware {
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private ApplicationContext context = null;
	
	//constructors
	public Triangle(){
		// default, empty??? It looks like it is needed for autowire to work, although it is only byName
	}
	public Triangle(Point pointA, Point pointB, Point pointC) {
		this.pointA = pointA;
		this.pointA = pointB;
		this.pointA = pointC;
	}

	public Point getPointA() {
		return pointA;
	}



	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}



	public Point getPointB() {
		return pointB;
	}



	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}



	public Point getPointC() {
		return pointC;
	}



	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public void draw(){
		//System.out.println("Triangle drawn, its points:");
		System.out.println("("+getPointA().getX()+", "+getPointA().getY()+")");
		System.out.println("("+getPointB().getX()+", "+getPointB().getY()+")");
		System.out.println("("+getPointC().getX()+", "+getPointC().getY()+")");
		if(context == null){
			System.out.println("context is null");
		}else{
			System.out.println("context is NOT null");
		}
		
	}
	
	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context = context;
		
	}
	@Override
	public void setBeanName(String beanName) {
		System.out.println("bean name is: "+beanName);
		
	}
}// end of class Triangle