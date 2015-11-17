package springexample.ex07;

import javax.swing.JOptionPane;

public class Triangle2 {
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	//constructors
	public Triangle2(){
		// default, empty??? It looks like it is needed for autowire to work, although it is only byName
	}
	//constructor
	public Triangle2(Point pointA, Point pointB, Point pointC) {
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
	
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		System.out.println("--> afterPropertiesSet is called for triangle bean ...");
//	}
//	@Override
//	public void destroy() throws Exception {
//		System.out.println("--> destroy is called for triangle bean ...");
//		JOptionPane.showMessageDialog(null,"destroy is called for triangle bean","TITLE",JOptionPane.WARNING_MESSAGE);
//	}
	
	public void myInit() throws Exception {
		System.out.println("--> myInit is called for triangle2 bean ...");
	}
	
	public void myDestroy() throws Exception {
		System.out.println("--> myDestroy is called for triangle2 bean ...");
		JOptionPane.showMessageDialog(null,"destroy is called for triangle2 bean","TITLE",JOptionPane.WARNING_MESSAGE);
	}
	
	public void defaultInit(){
		System.out.println("--> defaultInit is called for triangle2 bean ...");
	}
	
	
}// end of class Triangle2