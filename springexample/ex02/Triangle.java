package springexample.ex02;

public class Triangle {
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private TextWithId tid;

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
	
	public TextWithId getTid() {
		return tid;
	}



	public void setTid(TextWithId tid) {
		this.tid = tid;
	}



	public void draw(){
		System.out.println("Triangle drawn, its points:");
		System.out.println("("+getPointA().getX()+", "+getPointA().getY()+")");
		System.out.println("("+getPointB().getX()+", "+getPointB().getY()+")");
		System.out.println("("+getPointC().getX()+", "+getPointC().getY()+")");
		System.out.println("Text: (id: "+getTid().getId()+"): "+getTid().getS());
	}
}// end of class Triangle
