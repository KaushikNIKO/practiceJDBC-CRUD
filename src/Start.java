import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args)throws IOException {
		
		System.out.println("Welcome to Student Management App");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean Exit = false;
		while(!Exit) 
		{
			System.out.println("PRESS 1 to ADD student");
			System.out.println("PRESS 2 to Delete student");
			System.out.println("PRESS 3 to Display all student");
			System.out.println("PRESS 4 to Update student");
			System.out.println("PRESS 5 to Display by studentID");
			System.out.println("PRESS 6 to Exit");
			System.out.println("_____________________________");
			
			int outerInput = Integer.parseInt(br.readLine());
			
			switch(outerInput)
			{
			
			case 1: 
			//add student..
				System.out.println("Enter the student Name:");
				String name  = br.readLine();
				
				System.out.println("Enter the student Phone:");
				String phone = br.readLine();
				
				System.out.println("Enter the student City:");
				String city = br.readLine();
				
				Student st = new Student(name,phone,city);
				boolean ansInsert = StudentDao.insertStudentToDB(st);
				if(ansInsert)
				{
				System.out.println("Student added successfully...");
				}else System.out.println("Something went wrong!!");
				
				System.out.println(st);
				break;//caseEnd
				
			case 2:
			//delete student..
				System.out.println("For deletion of Student..");
				System.out.println("Enter Student ID:");
				int userId = Integer.parseInt(br.readLine());
				
				boolean ansDelete = StudentDao.deleteStudent(userId);
				if(ansDelete) {
					System.out.println("Student deleted successfully..");
				}else System.out.println("Something went wrong!!");
				System.out.println(userId);
				break;//caseEnd
				
			case 3:
			//For Display of Student..
				StudentDao.displayAllStudent();
				break;//caseEnd
				
			case 4:
			//Update student..
				boolean flag = false;
				while(!flag) {
					
					System.out.println("Press 1  to update name");
					System.out.println("Press 2 to update phone");
					System.out.println("Press 3 to update city");
					System.out.println("PRESS 4 to Exit");
					
					System.out.println("_____________________________");
					
					int innerInput = Integer.parseInt(br.readLine());
					boolean ansUpdate = false;
					switch(innerInput)
					{
					case 1:
						
						System.out.println("Enter Student ID:");
						userId = Integer.parseInt(br.readLine());
						
						System.out.println("Enter Student Name:");
						String userName = br.readLine();
						
						
						ansUpdate=StudentDao.updateStudentName(userId,userName);
						
						if(ansUpdate) {
							System.out.println("Student updated successfully..");
						}else System.out.println("Something went wrong!!");
						System.out.println(userId);
						break;//caseEnd
						
					case 2:

						System.out.println("Enter Student ID:");
						userId = Integer.parseInt(br.readLine());
						
						System.out.println("Enter Student Phone:");
						String userPhone = br.readLine();
						
						
						ansUpdate=StudentDao.updateStudentPhone(userId,userPhone);
						
						if(ansUpdate) {
							System.out.println("Student updated successfully..");
						}else System.out.println("Something went wrong!!");
						System.out.println(userId);
						break;//caseEnd
						
					case 3:
						System.out.println("Enter Student ID:");
						userId = Integer.parseInt(br.readLine());
						
						System.out.println("Enter Student City:");
						String userCity = br.readLine();
						
						
						ansUpdate=StudentDao.updateStudentCity(userId,userCity);
						
						if(ansUpdate) {
							System.out.println("Student updated successfully..");
						}else System.out.println("Something went wrong!!");
						System.out.println(userId);
						break;//caseEnd
						
					case 4:
						flag=true;
						break;//caseEnd
						
					default :
						System.out.println("Invalid input!!");//caseEnd
						
					}//SwitchEnd	
				}//WhileEnd
				break;//UpdateStudentcaseEnd
					
			case 5:
			//diplay student..
				System.out.println("For Display of Student..");
				System.out.println("Enter Student ID:");
				String sID = br.readLine();
					
				StudentDao.displayStudentById(sID);
				break;//caseEnd
				
				
			case 6:
			//Exit student..
				Exit = true;
				break;//caseEnd
				
			default:
			System.out.println("Invalid Input");
			System.out.println("_____________________________");
				break;//caseEnd
			}//OuterSwitchEnd
			
		}//OuterWhileEnd
		
		System.out.println("Thank you for using my application");
		System.out.println("See you soon...Bye! Bye!!");

	}//MainEnd

}//ClassStartEnd
