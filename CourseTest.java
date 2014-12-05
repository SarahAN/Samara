/* Sarah AlNegheimish
434201998
Week 14
Section 40579
Ms. Arwa Alturki */

//Question 3, Add and Drop

import java.util.*;

public class CourseTest
{ //Identifying variables as static variables 
   static Scanner input = new Scanner(System.in);
   static int studentNum = 0;
   static String [] nameArr = new String [20];
   static int [] numID = new int [20];
   public static void main(String args[])
   { //Calling method to read the students' name and ID 
      read(nameArr, numID);
//choice (add, drop, exit)/ number (student ID)/ back (returned value of drop)/ result (returned value of add)
      int choice, number, back;
      String name; //student's name
      boolean result;
      do {  System.out.print("Enter 1 to add a student 2 to drop one, -1 to exit: ");
            choice = input.nextInt();
            switch(choice)
               {case(1): 
                  System.out.print("Enter student's name and number: ");
                  name = input.next();
                  number = input.nextInt();
                  result = add(name, number);
                  if (result)
                     System.out.println("You have registered successfully");
                  else
                     System.out.println("The class is full");
                  break;
               case(2):
                  System.out.print("Enter the student's ID number: ");
                  number = input.nextInt();
                  back = drop(number);
                  if (back == 1)
                     System.out.println("You have dropped from the course successfully");
                  else 
                     System.out.println("This student is not registered in the class");
               }
         }while(choice!=-1);
         
         System.out.println("The students inlisted in CSC111 are:");
         print();
  
   }
   
   public static void read(String [] listA, int [] listB)
   {  char answer;
      int i; //reading the students' name and ID
      for ( i = 0; i < 20; i++)
         {System.out.print("Enter student's name and ID number: ");
         nameArr[i] = input.next();
         numID[i] = input.nextInt();
         studentNum++; //counting the number of students 
         if (i == 19) //reached maximum
            break;
         System.out.print("Add another student's info?(Y/N): ");
         answer = input.next().charAt(0);
         if (answer == 'n' || answer == 'N')
            break;}
        
   } 
   
   public static boolean add(String name, int number)
   {  if (studentNum < 20) //adding a student if there is space left
         {  nameArr[studentNum] = name;
            numID[studentNum] = number;
            studentNum++;
            return true;
         }
      return false;
   }
   
   public static int drop(int number)
   {  for (int i = 0; i < studentNum; i++)
         if ( numID[i] == number ) //searching for the number
            { if (i != 19)
                 for ( ; i < studentNum-1; i++)
                    {//shifting the elements in the array
                    numID[i] = numID[i+1];
                    nameArr[i] = nameArr[i+1]; } 
              numID[19] = 0; //reseting the last element to its initial value
              nameArr[19] = null;
              studentNum--; //decreasing he number of student
              return 1;
               }
      return -1;
   }
   
   public static void print() //printing method
   {  for (int i = 0; i < studentNum; i++)
         System.out.println(nameArr[i] + ", " + numID[i]);
   }
}