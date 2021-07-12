package test.co.yedam;

import java.util.Scanner;




public class MainApp {
	static Student[] students = new Student[10];
	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		//1.입력 2.수정 3.삭제 4.리스트 5.단건조회 6.분석 7.종료
		
		while (true) {
			showMenu();
			int menu = scn.nextInt();
			scn.nextLine();
			if (menu == 1) {
				insert();
			} else if (menu == 2) {
				studentEdit();
			} else if (menu == 3) {
				studentDelete();
			} else if (menu == 4) {
				studentList();
			} else if (menu == 5) {
				searchBystuNo();
			} else if (menu == 6) {
				topShowInfo();
			} else if (menu == 7) {
				break;
			}
		}
		System.out.println("프로그램이 종료되었습니다.");
		
		
		
	} //end of main
	
	public static void searchBystuNo() {
		int stuNo = scanInt("조회할 학생의 학번을 입력하세요>> ");
		boolean exist = false;
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getStuNo() == stuNo) {
				System.out.println(students[i].showInfo());
				exist = true;
			}
		}
		if (!exist) {
			System.out.println("조회한 이름이 없습니다.");
		}
	}
	
	public static void studentDelete() {
		int delId = scanInt("삭제하실  학생의 학번을 입력하세요>> ");
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getStuNo() == delId) {
				students[i] = null;
				System.out.println("입력하신 아이디가 삭제되었습니다. 복구하실 수 없습니다.");
				break;
			}
		}
	}
 	
	public static void studentList() {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) { 
				System.out.println(students[i].showInfo());
			}
		}
	}
	
	public static void topShowInfo() {
		Student s1 = new Student();
		s1.setName("박씨");
		s1.setStuNo(1);
		s1.seteScore(100);
		s1.setmScore(90);

		Student s2 = new Student();
		s1.setName("김씨");
		s1.setStuNo(2);
		s1.seteScore(70);
		s1.setmScore(80);

		Student s3 = new Student();
		s1.setName("이씨");
		s1.setStuNo(3);
		s1.seteScore(60);
		s1.setmScore(50);
		
		Student[] students = { s1, s2, s3 };
		int maxValue = 0;
		String name = "";

		Student maxStudent = null;
		for (int i = 0; i < students.length; i++) {
			if (maxValue < students[i].geteScore()) {
				maxValue = students[i].geteScore();
				maxStudent = students[i];
				System.out.println("최고영어점수 :" + maxStudent.geteScore());
			} 
		} 
		
	}
	
	
	
	public static void studentEdit() {

		int editId = scanInt("수정하실 학생의 학번을 입력하세요.");
		scn.nextLine();
		for (int i = 0; i < students.length; i++) {
			boolean exist = false;
			if (students[i] != null && students[i].getStuNo() == editId) {	
				int eScore = scanInt("수정할 영어점수를 입력하세요.");
				int mScore = scanInt("수정할 수학점수를 입력하세요.");
				if (students[i] != null) {
					students[i].seteScore(eScore);
					exist = true;
				}
				if (students[i] != null) {
					students[i].setmScore(mScore);
					exist = true;
				}
				if (exist) {
					System.out.println("수정되었습니다.");
				}
			}
		}
	}
	
	public static String scanString(String arg) { 
		System.out.println(arg);
		String val = scn.nextLine();
		return val;
	}
	
	public static void insert() {
		int stuNo = scanInt("학번을 입력하세요>> ");
		String name = scanString("이름을 입력하세요>> ");
		scn.nextLine();
		int eScore = scanInt("영어점수를 입력하세요>> ");
		int mScore = scanInt("수학점수를 입력하세요>> ");

		Student student = new Student(stuNo, name, eScore, mScore);

		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) { // 입력시 비워져 있는 곳에 입력.
				students[i] = student;
				break; // 비어있는 위치에 한건 입력 후 종료.
			}
		}
		
	}
	
	public static int scanInt(String arg) { 
		int val = 0;
		while (true) {
			try {
				System.out.println(arg);
				val = scn.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("숫자만 입력 가능합니다.");
				scn.nextLine();
			}
		}
		return val;
	}
	
	public static void showMenu() {
		System.out.println("----------------------------------------------------------");
		System.out.println("1.입력 | 2.수정 | 3.삭제 | 4.리스트 | 5.단건조회 | 6.분석 | 7.종료");
		System.out.println("----------------------------------------------------------");
		System.out.println("선택> ");
	}
	
	
}
