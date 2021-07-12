package test.co.yedam;


public class Student {
	private int stuNo;
	private String name;
	private int eScore;
	private int mScore;
	
	
	public int getStuNo() {
		return stuNo;
	}


	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int geteScore() {
		return eScore;
	}


	public void seteScore(int eScore) {
		this.eScore = eScore;
	}


	public int getmScore() {
		return mScore;
	}


	public void setmScore(int mScore) {
		this.mScore = mScore;
	}


	public Student(int stuNo, String name, int eScore, int mScore) {
		super();
		this.stuNo = stuNo;
		this.name = name;
		this.eScore = eScore;
		this.mScore = mScore;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}


	public String showInfo() {
		String info = "[학번: " + stuNo + 
				"이름: " + name + 
				"영어점수 " + eScore + 
				"수학점수: " + mScore +
				 "]";
		return info;
	}

	public String getInfo() {
		return "회원번호: " + this.stuNo + 
				"     이름: " + this.name + 
				"\n영어점수: " + this.eScore + 
				"  수학점수: " + this.mScore ;
		
	}
}
