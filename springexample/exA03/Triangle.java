package springexample.exA03;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import springexample.exA02.Point;

public class Triangle implements Shape {
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	//constructors
	public Triangle(){
		// default, empty??? It looks like it is needed?
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
		System.out.println("--> triangle");
		System.out.println("("+getPointA().getX()+", "+getPointA().getY()+")");
		System.out.println("("+getPointB().getX()+", "+getPointB().getY()+")");
		System.out.println("("+getPointC().getX()+", "+getPointC().getY()+")");
	}
		
}// end of class Triangle