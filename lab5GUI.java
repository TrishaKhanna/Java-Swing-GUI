import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class lab5GUI
{
	public static void main(String[] args)
	{
		GUItest obj = new GUItest();
	}
}

class Student
    {
        private String program;
        private String year;
        private Float avgGrade;
        private String lastName;

        public Student(String program, String year, Float avgGrade, String lastName) throws Exception
        {
            this.program = program;
            this.year = year;
            this.avgGrade = avgGrade;
            this.lastName = lastName;
        }

        public String getProgram()
        {
            return this.program;
        }

        public String getYear()
        {
            return this.year;
        }

        public Float getaverageGrade()
        {
            return this.avgGrade;
        }

        public String getlastName()
        {
            return this.lastName;
        }

        // Convert arrayList to String
        public String toString()
        {
            super.toString();
            return ("<br />" + "Program: " + this.program + "<br />" + "Year: " + this.year + "<br />" + "Average Grade: " + this.avgGrade + "<br />" + "Last Name: " + this.lastName + "<br />");
        }

        // Properly print stuff in text file -- (Option 7)
        public String toFile()
        {
           // super.toFile();
            return (this.program + " " + this.year + " " + this.avgGrade + " " + this.lastName);
        }

        // Compare program with programs inputted in arrayList
        public boolean equals(Student anObject) 
        {
            if (anObject == null) 
            { 
                return false;    
            }

            else
            {
                System.out.println(program == anObject.program && year == anObject.year && avgGrade == anObject.avgGrade);
                return true;
            } 
        }
    }

    class GraduateStudent extends Student
    {
        private String supervisor;
        private boolean isPhD;
        private String undergraduateSchool;

        public GraduateStudent(String program, String year, Float avgGrade, String supervisor, boolean isPhD, String undergraduateSchool, String lastName) throws Exception
        {
            super(program, year, avgGrade, lastName);
            this.supervisor = supervisor;
            this.isPhD = isPhD;
            this.undergraduateSchool = undergraduateSchool;
            //this.lastName = lastName;
        }

        // Convert arrayList to String
        public String toString()
        {
            String output;
            if(this.isPhD == true)
            {
                output = "PHD";
            }

            else
            {
                output = "MASTERS";
            }
            super.toString();
            return ("<br />" + "Program: " + getProgram() + "<br />" + "Year: " + getYear() + "<br />" + "Average Grade: " + getaverageGrade() + "<br />" + "PhD/Masters: " + output + "<br />" + "Supervisor: " + this.supervisor + "<br />" + "Undergraduate School: " + this.undergraduateSchool + "<br />" + "Last Name: " + getlastName() + "<br />");
        }

        // Properly print stuff in text file -- (Option 7)
        public String toFile()
        {
            int output;
            if(this.isPhD == true)
            {
                output = 1;
            }

            else
            {
                output = 0;
            }

            super.toFile();
            return (getProgram() + " " + getYear() + " " + getaverageGrade() + " " + this.supervisor + " " + output + " " + this.undergraduateSchool + " " + getlastName());
        }

    }

class GUItest extends JFrame
{
	JLabel checkUNpy;
	JLabel checkUNavgGr;
	JLabel checkUNlastnm;
	JLabel unUserAwareness;
	JLabel unInfo;

	JLabel checkGRADpy;
	JLabel checkGRADavgGr;
	JLabel checkGRADsupNm;
	JLabel checkGRADphd;
	JLabel checkGRADnmSchl;
	JLabel checkGRADlastnm;
	JLabel gradUserAwareness;
	JLabel gradInfo;
	JLabel correctLoad;

	JLabel showStudentInfo;
	JList<String> displayList;
	JScrollPane scrollPane;

	JLabel totalStudents;
	JLabel totalAVGgr;

	JLabel enterFile;

	JLabel saveFile;

	JLabel file7;
	JLabel num3;
	JLabel num4;
	JLabel num5;
	JLabel num6;
	JLabel num7;

	JLabel l;
	JLabel l1;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JLabel label5;
	JLabel label6;
	JLabel label7;
	JLabel label8;

	JLabel unProYr;
	JLabel unAvgGr;
	JLabel unLastName;
	JLabel gradProYr;
	JLabel gradAvgGr;
	JLabel gradSupName;
	JLabel infoPT1;
	JLabel gradPorM;
	JLabel gradSchoolName;
	JLabel gradLastName;
	JLabel studentInfo;
	JLabel numStudents;
	JLabel avgGrade;
	JLabel search;
	JLabel loadFile;
	JButton createStudent;
	JButton createGraduateStudent;
	JButton b;
	JButton b1;
	JButton b2;
	JButton b5;
	JButton readButton;
	JButton b7;
	JFrame f1;
	JFrame f2;
	JFrame f3;
	JFrame f4;
	JFrame f5;
	JFrame f6;
	JFrame f7;
	JFrame f8;
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	JPanel panel5;
	JPanel panel6;
	JPanel panel7;
	JPanel panel8;
	JTextField unPY;
	JTextField unAG;
	JTextField unLN;
	JTextField gradPY;
	JTextField gradAG;
	JTextField gradSUP;
	JTextField gradPM;
	JTextField gradSCNM;
	JTextField gradLN;
	JTextField fileLoad;
	JTextField fileNAME;
	JMenuBar bar; // Whole bar
	JMenu option1; // Individual options available in that menu bar
	JMenu option2;
	JMenu option3;
	JMenu option4;
	JMenu option5;
	JMenu option6;
	JMenu option7;
	JMenu option8;
	JMenu option9;
	JMenuItem op1; // each individual item under each individual option in the menu bar
	JMenuItem op2;
	JMenuItem op3;
	JMenuItem op4;
	JMenuItem op5;
	JMenuItem op6;
	JMenuItem op7;
	JMenuItem op8;

	// Declare an arrayList
    ArrayList<Student> collection = new ArrayList<Student>();

    /*********************************************
			OPTION 1 METHOD - CREATE STUDENT
    **********************************************/
	private void createStudentOP1(Container parent) 
	{
		String [] array = {};
		float userGrade = 0.0f;
		String input1;
		String lastName;

        // PROGRAM + YEAR
		array = unPY.getText().split("[ ]+");

        if(array.length == 2)
        {
            try
            {
                int x = Integer.parseInt(array[1]);
                System.out.println("Parsing has correctly occured.");
            }

            catch(Exception e)
            {
                System.out.println("This is not the correct input format.");
            }

            checkUNpy.setText("Undergraduate Program + Year -- FORMAT CORRECTLY INPUTTED");
        }

        else
        {
            checkUNpy.setText("User Program + Year have been INCORRECTLY INPUTTED!");
        }

        // GRADE
        input1 = unAG.getText();
        if (!input1.isEmpty())
        {
            try
            {
                userGrade = Float.parseFloat(input1);
                System.out.println("Parsing to float has correctly occured.");
                checkUNavgGr.setText("FORMAT CORRECTLY INPUTTED");
            }

            catch(NumberFormatException e)
            {
                checkUNavgGr.setText("This is not the correct input format -- Undergraduate Average Grade");
            }
        }

        else
        {
            userGrade = 0.0f;
            checkUNavgGr.setText("Undergraduate Average Grade -- SET to 0.0 by default due to blank input");
        }

        System.out.println("Grade Entered = " + userGrade);

        // LAST NAME
        lastName = unLN.getText();

        if(lastName.isEmpty())
        {
            checkUNlastnm.setText("This is not the correct input format -- Undergraduate Last Name");
        }

        else
        {
        	checkUNlastnm.setText("Undergraduate LAST NAME -- FORMAT CORRECTLY INPUTTED");
        }

        System.out.println("Last Name Entered = " + lastName);

        // Save newly inputted userinfo in the Student Class
        try
        {
        	if((array.length == 2) && (!(lastName.isEmpty())))
        	{
        		Student student1 = new Student(array[0], array[1], userGrade, lastName);
        		collection.add(student1);
        	}
        }

        catch(Exception e)
        {
        	gradInfo.setText("Formats Were NOT correctly Inputted:(");
        }
    }

    /*********************************************
	   OPTION 2 METHOD - CREATE GRADUATE STUDENT
    **********************************************/
	private void createGradStudentOP2(Container parent)
	{
		String [] arrayGS = {};
		String input1;
		float userGrade = 0.0f;
		String userSupervisor;
		String checkPHD;
		int convertPHD;
		boolean phd = true;
		String underGrad;
		String lastName;

		// PROGRAM + YEAR:
		arrayGS = gradPY.getText().split("[ ]+");

        if(arrayGS.length == 2)
        {
            try
            {
                int x = Integer.parseInt(arrayGS[1]);
                System.out.println("Parsing has correctly occured.");
            }

            catch(Exception e)
            {
                System.out.println("This is not the correct input format.");
            }

            checkGRADpy.setText("Graduate Program + Year -- FORMAT CORRECTLY INPUTTED");
        }

        else
        {
            System.out.println("ERROR: Incorrect Input");
            checkGRADpy.setText("Graduate User Program + Year have been INCORRECTLY INPUTTED!");
        }

        // AVERAGE GRADE:
        input1 = gradAG.getText();
        if (!input1.isEmpty())
        {
        	try
        	{
        		userGrade = Float.parseFloat(input1);
        		System.out.println("Parsing to float has correctly occured.");
        		checkGRADavgGr.setText("Graduate Average Grade -- FORMAT CORRECTLY INPUTTED");
        	}

        	catch(NumberFormatException e)
        	{
        		checkGRADavgGr.setText("This is not the correct input format -- Graduate Average Grade");
        	}
        }

        else
        {
            userGrade = 0.0f;
            checkGRADavgGr.setText("Graduate Average Grade -- SET to 0.0 by default due to blank input");
        }

        System.out.println("Grade Entered = " + userGrade);

        // SUPERVISOR NAME
        userSupervisor = gradSUP.getText();

        if(userSupervisor.isEmpty())
        {
        	checkGRADsupNm.setText("This is not the correct input format -- Graduate Supervisor's Name");
        }

        else
        {
        	checkGRADsupNm.setText("GRADUATE SUPERVISOR's NAME -- FORMAT CORRECTLY INPUTTED");
        }

        System.out.println("Supervisor Name Entered = " + userSupervisor);

        // PhD or MASTERS
        checkPHD = gradPM.getText();
        convertPHD = Integer.parseInt(checkPHD); 

        if(convertPHD == 1)
        {
            phd = true; // This graduate student is a PHD Student
            checkGRADphd.setText("Graduate Student is a PhD Student");
        }

        if(convertPHD == 0)
        {
            phd = false; // This graduate student is a MASTERS Student
            checkGRADphd.setText("Graduate Student is a MASTERS Student");
        }

        System.out.println("The graduate Student is a PhD Student? " + phd);

        // NAME OF GRADUATE SCHOOL
        underGrad = gradSCNM.getText();

        if(underGrad.isEmpty())
        {
            checkGRADnmSchl.setText("This is not the correct input format -- Graduate Student's School's Name");
        }

        else
        {
        	checkGRADsupNm.setText("GRADUATE STUDENT's SCHOOL's NAME -- FORMAT CORRECTLY INPUTTED");
        }

        System.out.println("Graduate School Name Entered = " + userSupervisor);

        // LAST NAME
        lastName = gradLN.getText();

        if(lastName.isEmpty())
        {
        	checkGRADlastnm.setText("This is not the correct input format -- Graduate Last Name");
        }

        else
        {
        	checkGRADlastnm.setText("Graduate LAST NAME -- FORMAT CORRECTLY INPUTTED");
        }

        System.out.println("Last Name Entered = " + lastName);

        // Save newly inputted userinfo in the Graduate Student Class
        try
        {
        	if((arrayGS.length == 2) && (!(lastName.isEmpty())))
        	{
        		GraduateStudent graduateStudent1 = new GraduateStudent(arrayGS[0], arrayGS[1], userGrade, userSupervisor, phd, underGrad, lastName);
            	collection.add(graduateStudent1);
        	}
        }

        catch(Exception e)
        {
        	unInfo.setText("Formats Were NOT correctly Inputted:(");
        }
	}

	/*********************************************
	   OPTION 3 METHOD - SHOW ALL STUDENT INFO
    **********************************************/
	private void showAllStudentInfoOP3(Container parent)
	{
		StringBuffer sb = new StringBuffer("<html>");
      
      	for (Student s : collection) 
      	{
      		sb.append(s);
         	s.toString();
      	}

      	sb.append("</html>");

        String str = sb.toString();
        System.out.println(str);

        showStudentInfo.setText(str);
	}

	/**************************************************************************************
	   OPTION 4 METHOD - SHOW AVERAGE GRADES OF ALL STUDENTS + TOTAL NO. OF ALL STUDENTS
    ***************************************************************************************/ 
	private void showAllStudentGradesOP4(Container parent)
	{
		// NUMBER OF STUDENTS
		int total = collection.size();
		String conversion = Integer.toString(total);
		System.out.println("Conversion = " + conversion);
		totalStudents.setText(conversion);

		// AVERAGE GRADE OF ALL STUDENTS
		float sum = 0.0f;
		float average = 0.0f;
		float avgConvert;
		String stringConvert;

		for(int i = 0; i < collection.size(); i++)
        {
            System.out.println("The average grade of the individual student is: " + collection.get(i).getaverageGrade());
            sum = sum + (collection.get(i).getaverageGrade());
            average = sum / (collection.size()); // Calculate average
            //avgConvert = Float.parseFloat(average);
            stringConvert = String.valueOf(average);  
            totalAVGgr.setText(stringConvert);
        }

        System.out.println("The TOTAL AVERAGE grade of this class is: " + average);

	}

	/*********************************************************
	   OPTION 5 METHOD - LOAD STUDENT INFO FROM INPUT FILE
    *********************************************************/
    private void loadFromInputFileOP5(Container parent)
    {
    	try
		{
			String str = fileLoad.getText();

			System.out.println("str = " + str);

			File f = new File(str);
            Scanner file1 = new Scanner(f);

            if (f.length() == 0) 
            {
                System.out.println("This file is empty."); 
            } 
            
            else 
            { 
                System.out.println("File is not empty; its contents are printed below: "); 
            }

            while(file1.hasNextLine())
            {
                System.out.println("Entering wwhile loop ");

                String textData = file1.nextLine();
                // Obtain user's program and year
                String array[] = textData.split("[ ]+");

                System.out.println("Array length = " + array.length);

                if(array.length == 4)
                {
                    Float floatVal = Float.valueOf(array[2]).floatValue();

                    // Save file loaded Student info in the Student Class
                    Student student2 = new Student(array[0], array[1], floatVal, array[3]);

                    // Add the newly loaded student data from file into the arrayList
                    collection.add(student2);
                }

                if(array.length == 7)
                {
                    Float floatVal = Float.valueOf(array[2]).floatValue();

                    boolean bool = Boolean.parseBoolean(array[4]);

                    // Save file loaded Student info in the Student Class
                    GraduateStudent gradstudent1 = new GraduateStudent(array[0], array[1], floatVal, array[3], bool, array[5], array[6]);

                    // Add the newly loaded student data from file into the arrayList
                    collection.add(gradstudent1);
                }

                System.out.println(textData);
                correctLoad.setText("File was loaded properly:)");
            }
		}

		catch(Exception e)
        {
            System.out.println("Could not open file.");
        }	
    }

    /*********************************************************
	   OPTION 6 METHOD - SAVE STUDENT INFO TO FILE
    *********************************************************/
    private void saveInfoToFileOP6(Container parent)
    {
    	String filename = "";

        try
        {
            filename = fileNAME.getText();

            System.out.println("filename = " + filename);

            FileWriter writer = new FileWriter(filename);

            for(Student str : collection)
            {
                writer.write(str.toFile() + System.lineSeparator());
            }

            writer.close();
            saveFile.setText("Contents were properly saved:)");
        }

        catch(Exception e)
        {
            System.out.println("Could not open file.");
        }
    }

	public GUItest()
	{
		l = new JLabel("Welcome to the CIS*2430 LAB 5!"); /* HOW DO I PUSH THIS TO THE MIDDLE OF THE PAGE?*/
		l.setVerticalTextPosition(JLabel.BOTTOM); //Set the position of the text, relative to the icon:
		l.setHorizontalTextPosition(JLabel.CENTER);
		l.setBounds(10, 20, 80, 25);
		add(l);

		l1 = new JLabel("Read the menu options and choose an option from the menu bar above.");
		l1.setBounds(100, 20, 80, 25);
		add(l1);
		l1.setVerticalTextPosition(JLabel.BOTTOM); //Set the position of the text, relative to the icon:
		l1.setHorizontalTextPosition(JLabel.CENTER);

		label1 = new JLabel("(1) Enter information for a new Student.");
		add(label1);
		label2 = new JLabel("(2) Enter information for a new GraduateStudent.");
		add(label2);
		label3 = new JLabel("(3) Show all student information with each attribute on a separate line.");
		add(label3);
		label4 = new JLabel("(4) Print the average of the average grades for all students as well as the total number of students.");
		add(label4);
		label5 = new JLabel("(5) Load student information from an input file.");
		add(label5);
		label6 = new JLabel("(6) Save all student information to an output file.");
		add(label6);
		label7 = new JLabel("(7) Lookup via HashMap with program, year, and lastName.");
		add(label7);
		label8 = new JLabel("(8) End Program.");
		add(label8);


		bar = new JMenuBar();
		setJMenuBar(bar);

		option1 = new JMenu("Option 1");
		bar.add(option1);
		op1 = new JMenuItem("(1) Enter information for a new Student.");
		option1.add(op1);

		option2 = new JMenu("Option 2");
		bar.add(option2);
		op2 = new JMenuItem("(2) Enter information for a new GraduateStudent.");
		option2.add(op2);

		option3 = new JMenu("Option 3");
		bar.add(option3);
		op3 = new JMenuItem("(3) Show all student information with each attribute on a separate line.");
		option3.add(op3);

		option4 = new JMenu("Option 4");
		bar.add(option4);
		op4 = new JMenuItem("(4) Print the average of the average grades for all students as well as the total number of students.");
		option4.add(op4);

		option5 = new JMenu("Option 5");
		bar.add(option5);
		op5 = new JMenuItem("(5) Load student information from an input file.");
		option5.add(op5);

		option6 = new JMenu("Option 6");
		bar.add(option6);
		op6 = new JMenuItem("(6) Save all student information to an output file.");
		option6.add(op6);

		option7 = new JMenu("Option 7");
		bar.add(option7);
		op7 = new JMenuItem("(7) Lookup via HashMap with program, year, and lastName.");
		option7.add(op7);

		option8 = new JMenu("Option 8");
		bar.add(option8);
		op8 = new JMenuItem("(8) End Program.");
		option8.add(op8);

		/**************************************************************/
		// SUB FRAME -- OPTION 1 !
		/**************************************************************/
		f1 = new JFrame("Enter information for a new Student.!");
		panel1 = new JPanel();
		f1.add(panel1);

		unProYr = new JLabel("Enter Student Program and Year: ");
		unProYr.setBounds(10, 50, 20, 85);
		panel1.add(unProYr);
		unPY = new JTextField(20);
		unPY.setBounds(10, 20, 20, 85);
		panel1.add(unPY);

		unAvgGr = new JLabel("Enter Average grade, or leave blank: ");
		panel1.add(unAvgGr);
		unAG = new JTextField(20);
		panel1.add(unAG);

		unLastName = new JLabel("Enter the Student's last name: ");
		panel1.add(unLastName);
		unLN = new JTextField(20);
		panel1.add(unLN);

		createStudent = new JButton("Click here after inputting all the information.");
		createStudent.addActionListener(click -> createStudentOP1(panel1));
		panel1.add(createStudent);

		checkUNpy = new JLabel("***Check Undergraduate Program + Year***");
		panel1.add(checkUNpy);
		checkUNavgGr = new JLabel ("***Check Undergraduate Average Grade***");
		panel1.add(checkUNavgGr);
		checkUNlastnm = new JLabel("***Check Undergraduate Last Name***");
		panel1.add(checkUNlastnm);
		unInfo = new JLabel();
		panel1.add(unInfo);
		unUserAwareness = new JLabel("***Close window by clicking on --X-- ICON***");
		panel1.add(unUserAwareness);

		ActionListener al1 = new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				f1.setVisible(true);
				f1.setSize(550, 400);
				unPY.setText("");
				unAG.setText("");
				unLN.setText("");
			}
		};

		op1.addActionListener(al1);

		/**************************************************************/
		// SUB FRAME -- OPTION 2 !
		/**************************************************************/
		f2 = new JFrame("Enter information for a new GraduateStudent.");
		panel2 = new JPanel();
		f2.add(panel2);

		gradProYr = new JLabel("Enter Student Program and Year: ");
		panel2.add(gradProYr);
		gradPY = new JTextField(20);
		panel2.add(gradPY);

		gradAvgGr = new JLabel("Enter Average grade, or leave blank: ");
		panel2.add(gradAvgGr);
		gradAG = new JTextField(20);
		panel2.add(gradAG);

		gradSupName = new JLabel("Enter Supervisor's Name: ");
		panel2.add(gradSupName);
		gradSUP = new JTextField(20);
		panel2.add(gradSUP);

		infoPT1 = new JLabel("Are you a PhD Student of Masters Student?");
		panel2.add(infoPT1);
		gradPorM = new JLabel("(Enter 1 for PhD, 0 for MASTERS)");
		panel2.add(gradPorM);
		gradPM = new JTextField(20);
		panel2.add(gradPM);

		gradSchoolName = new JLabel("What Graduate School are you in? ");
		panel2.add(gradSchoolName);
		gradSCNM = new JTextField(20);
		panel2.add(gradSCNM);

		gradLastName = new JLabel("Enter the Graduate Student's last name: ");
		panel2.add(gradLastName);
		gradLN = new JTextField(20);
		panel2.add(gradLN);

		createGraduateStudent = new JButton("Click here after inputting all the information.");
		createGraduateStudent.addActionListener(click -> createGradStudentOP2(panel2));
		panel2.add(createGraduateStudent);

		checkGRADpy = new JLabel("Check Graduate Program + Year");
		panel2.add(checkGRADpy);
		checkGRADavgGr = new JLabel("Check Graduate Average Grade");
		panel2.add(checkGRADavgGr);
		checkGRADsupNm = new JLabel("Check Graduate Supervisor Name");
		panel2.add(checkGRADsupNm);
		checkGRADphd = new JLabel("Check whether Graduate Student is PhD/Masters student");
		panel2.add(checkGRADphd);
		checkGRADnmSchl = new JLabel("Check Graduate Student's School Name");
		panel2.add(checkGRADnmSchl);
		checkGRADlastnm = new JLabel("Check Graduate Student's Last Name");
		panel2.add(checkGRADlastnm);
		gradInfo = new JLabel("***Only click the button when all your inputs have been entered with the correct format***");
		panel2.add(gradInfo);
		gradUserAwareness = new JLabel("***Close window by clicking on --X-- ICON***");
		panel2.add(gradUserAwareness);

		ActionListener al2 = new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				f2.setVisible(true);
				f2.setSize(350, 600);
				gradPY.setText("");
				gradAG.setText("");
				gradSUP.setText("");
				gradPM.setText("");
				gradSCNM.setText("");
				gradLN.setText("");
			}
		};

		op2.addActionListener(al2);

		/**************************************************************/
		// SUB FRAME -- OPTION 3 !
		/**************************************************************/
		f3 = new JFrame("Show all student information with each attribute on a separate line.");
		panel3 = new JPanel();
		f3.add(panel3);

		studentInfo = new JLabel("All Student Information:- ");
		panel3.add(studentInfo);
		b = new JButton("Click here");
		b.addActionListener(click -> showAllStudentInfoOP3(panel3));
		panel3.add(b);

		showStudentInfo = new JLabel();
		showStudentInfo.setText("**Displayed here**");
		panel3.add(showStudentInfo);

		num3 = new JLabel("***Close window by clicking on --X-- ICON***");
		panel3.add(num3);

		ActionListener al3 = new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				f3.setVisible(true);
				f3.setSize(300, 400);
				showStudentInfo.setText("**Displayed here**");
			}
		};

		op3.addActionListener(al3);

		/**************************************************************/
		// SUB FRAME -- OPTION 4 !
		/**************************************************************/
		f4 = new JFrame("Print the average of the average grades for all students as well as the total number of students.");
		panel4 = new JPanel();
		f4.add(panel4);

		b1 = new JButton("Click here");
		b1.addActionListener(click -> showAllStudentGradesOP4(panel4));
		panel4.add(b1);

		numStudents = new JLabel("The total number of students in this class are: ");
		panel4.add(numStudents);

		totalStudents = new JLabel("");
		panel4.add(totalStudents);

		avgGrade = new JLabel("The TOTAL AVERAGE grade of this class is: ");
		panel4.add(avgGrade);

		totalAVGgr = new JLabel("");
		panel4.add(totalAVGgr);

		num4 = new JLabel("***Close window by clicking on --X-- ICON***");
		panel4.add(num4);

		ActionListener al4 = new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				f4.setVisible(true);
				f4.setSize(375, 400);
			}
		};

		op4.addActionListener(al4);

		/**************************************************************/
		// SUB FRAME -- OPTION 5 !
		/**************************************************************/
		f5 = new JFrame("Load student input from file");
		panel5 = new JPanel();
		f5.add(panel5);

		enterFile = new JLabel("Please enter the file name");
		panel5.add(enterFile);

		fileLoad = new JTextField(20);
		panel5.add(fileLoad);

		readButton = new JButton("Click here");
		readButton.addActionListener(click -> loadFromInputFileOP5(panel5));
		panel5.add(readButton);

		correctLoad = new JLabel();
		panel5.add(correctLoad);

		num5 = new JLabel("***Close window by clicking on --X-- ICON***");
		panel5.add(num5);

		ActionListener al5 = new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				f5.setVisible(true);
				f5.setSize(300, 400);
			}
		};

		op5.addActionListener(al5);

		/**************************************************************/
		// SUB FRAME -- OPTION 6 !
		/**************************************************************/
		f6 = new JFrame("Save all student information to an output file.");
		panel6 = new JPanel();
		f6.add(panel6);

		file7 = new JLabel("Please enter the file name");
		panel6.add(file7);

		fileNAME = new JTextField(20);
		panel6.add(fileNAME);

		b7 = new JButton("Click here");
		b7.addActionListener(click -> saveInfoToFileOP6(panel6));
		panel6.add(b7);

		saveFile = new JLabel();
		panel6.add(saveFile);

		num6 = new JLabel("***Close window by clicking on --X-- ICON***");
		panel6.add(num6);

		ActionListener al6 = new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				f6.setVisible(true);
				f6.setSize(300, 400);
			}
		};

		op6.addActionListener(al6);


		/**************************************************************/
		// SUB FRAME -- OPTION 7 !
		/**************************************************************/
		f7 = new JFrame("Lookup via HashMap with program, year, and lastName.");
		panel7 = new JPanel();
		f7.add(panel7);

		search = new JLabel("Sorry! This functionality wasn't implemented. Better luck next time!");
		panel7.add(search);

		num7 = new JLabel("***Close window by clicking on --X-- ICON***");
		panel7.add(num7);

		ActionListener al7 = new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				f7.setVisible(true);
				f7.setSize(500, 500);
			}
		};

		op7.addActionListener(al7);

		/**************************************************************/
		// SUB FRAME -- OPTION 8 !
		/**************************************************************/
		f8 = new JFrame("End Program.");
		panel8 = new JPanel();
		f8.add(panel8);

		ActionListener al8 = new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.exit(0);
			}
		};

		op8.addActionListener(al8);


		setLayout(new FlowLayout());
		setVisible(true); // JFrame is by default invisible -- hence we have to do this
		setSize(600, 400); // Set size of the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}