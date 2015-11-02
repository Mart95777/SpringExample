package springexample.ex03;

import java.util.List;

import springexample.ex03.TextWithId;

public class Triangle {
	
	private List<Point> points;
	private TextWithId tid;
	
	
	public List<Point> getPoints() {
		return points;
	}


	public void setPoints(List<Point> points) {
		this.points = points;
	}
	
	public TextWithId getTid() {
		return tid;
	}



	public void setTid(TextWithId tid) {
		this.tid = tid;
	}


	public void draw(){
		for (Point point : points){
			System.out.println("Point = ("+point.getX()+", "+point.getY()+")");
		}
		
		
	}//end of draw

}
