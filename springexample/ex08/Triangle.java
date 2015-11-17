package springexample.ex08;

import org.springframework.beans.BeansException;

import springexample.ex08.Point;

public class Triangle {
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
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
		
	}
	
}// end of class Triangle