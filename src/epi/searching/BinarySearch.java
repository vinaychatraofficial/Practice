package epi.searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearch {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		Student eight = new Student(8.0, "eight");
		Student nine = new Student(9.0, "nine");
		Student ten = new Student(10.0, "ten");
		Student five = new Student(5.0, "five");
		Student six = new Student(6.0, "six");
		Student seven = new Student(7.0, "seven");
		students.add(eight);
		students.add(nine);
		students.add(ten);
		students.add(five);
		students.add(six);
		students.add(seven);
		
		for(Student st:students){
			System.out.println(st.name + " has gpa "+st.gpa);
		}
		
		int index = Collections.binarySearch(students,seven,stComp);
		System.out.println("index is "+index);
		
		Collections.sort(students,stComp);
		
		
		
		System.out.println("-------");
		System.out.println("after sorting with comparator");
		
		for(Student st:students){
			System.out.println(st.name + " has gpa "+st.gpa);
		}
		
		index = Collections.binarySearch(students,eight,stComp);
		System.out.println("index is "+index);
		
		List<StudentWithComparable> studentsWithC = new ArrayList<>();
		StudentWithComparable eightWithC = new StudentWithComparable(8.0, "eight");
		StudentWithComparable nineWithC = new StudentWithComparable(9.0, "nine");
		StudentWithComparable tenWithC = new StudentWithComparable(10.0, "ten");
		StudentWithComparable fiveWithC = new StudentWithComparable(5.0, "five");
		StudentWithComparable sixWithC = new StudentWithComparable(6.0, "six");
		StudentWithComparable sevenWithC = new StudentWithComparable(7.0, "seven");
		studentsWithC.add(eightWithC);
		studentsWithC.add(nineWithC);
		studentsWithC.add(tenWithC);
		studentsWithC.add(fiveWithC);
		studentsWithC.add(sixWithC);
		studentsWithC.add(sevenWithC);
		
		System.out.println("-------");
		System.out.println("Before sorting with comparable");
		
		for(StudentWithComparable st:studentsWithC){
			System.out.println(st.name + " has gpa "+st.gpa);
		}
		
		index = Collections.binarySearch(studentsWithC,sevenWithC);
		System.out.println("index is "+index);
		
		Collections.sort(studentsWithC);
		
		System.out.println("-------");
		System.out.println("after sorting with comparable");
		
		for(StudentWithComparable st:studentsWithC){
			System.out.println(st.name + " has gpa "+st.gpa);
		}
		
		index = Collections.binarySearch(studentsWithC,sevenWithC);
		System.out.println("index is "+index);
		
	}
	
	public static class Student{
		public Double gpa;
		public String name;
		
		public Student(Double gpa, String name) {
			super();
			this.gpa = gpa;
			this.name = name;
		}
		
		
	}
	
	public static class StudentWithComparable implements Comparable<StudentWithComparable>{
		public Double gpa;
		public String name;
		
		public StudentWithComparable(Double gpa, String name) {
			super();
			this.gpa = gpa;
			this.name = name;
		}

		@Override
		public int compareTo(StudentWithComparable o) {
			StudentWithComparable st = (StudentWithComparable)o;
			if(this.gpa!=st.gpa)
				return Double.compare(this.gpa, st.gpa);
			return this.name.compareTo(st.name);
		}
		
		
	}
	
	public static Comparator stComp = new Comparator<Student>(
			) {

				@Override
				public int compare(Student o1, Student o2) {
					if(o1.gpa!=o2.gpa)
						return Double.compare(o1.gpa, o2.gpa);
					return o1.name.compareTo(o2.name);
				}
	};

}
