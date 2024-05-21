package schoolSite;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

    private static Map<String, Map<String, String>> studentData = new HashMap<>();
    private static Map<String, Map<String, String>> staffData = new HashMap<>();
    private static Map<String, LocalDate> studentAttendance = new HashMap<>();
    private static Map<String, LocalDate> staffAttendance = new HashMap<>();
    private static Map<String, Double> feeStructure = new HashMap<>();
    private static Map<LocalDate, String> notices = new TreeMap<>();
    private static Map<String, String> queries = new HashMap<>();
    private static Map<String, String> answeredQueries = new HashMap<>();
    private static Map<LocalDate, String[]> parentNotices = new HashMap<>();
    private static Map<String, Map<String, String>> schools = new HashMap<>();
    private static Map<String, Map<String, String>> colleges = new HashMap<>();
    private static Map<String, Map<String, String>> universities = new HashMap<>();
    private static Map<String, Map<String, String>> reviewsAndRatings = new HashMap<>();
    private static Map<String, String> supportQuestions = new HashMap<>();
    private static Map<String, String> answeredSupportQuestions = new HashMap<>();

    public static void main(String[] args) 
    {
    	Map<String, String> student1 = new HashMap<>();
        student1.put("name", "Krishna");
        student1.put("rollNumber", "101");
        student1.put("password", "1234");
        studentData.put("krishna123", student1);

        Map<String, String> student2 = new HashMap<>();
        student2.put("name", "Radha");
        student2.put("rollNumber", "102");
        student2.put("password", "1234");
        studentData.put("radha123", student2);

        
        Map<String, String> staff1 = new HashMap<>();
        staff1.put("name", "Ganesh");
        staff1.put("id", "S001");
        staff1.put("role", "Teacher");
        staff1.put("password", "1234");
        staffData.put("ganesh123", staff1);

        Map<String, String> staff2 = new HashMap<>();
        staff2.put("name", "Virat");
        staff2.put("id", "S002");
        staff2.put("role", "Teacher");
        staff2.put("password", "1234");
        staffData.put("virat123", staff2);

        
        studentAttendance.put("rahul123", LocalDate.now().minusDays(1));
        studentAttendance.put("radha123", LocalDate.now());

        staffAttendance.put("ganesh123", LocalDate.now().minusDays(1));
        staffAttendance.put("virat123", LocalDate.now());

        String adminUsername = "admin";
        String adminPassword = "admin";
        
        feeStructure.put("Tuition Fee", 5000.0);
        feeStructure.put("Library Fee", 200.0);
        feeStructure.put("Examination Fee", 300.0);
        
     
        schools.put("The Doon School", createSchool("The Doon School", "Dehradun", "Radhe Mohan"));
        schools.put("St. Xavier's Collegiate School", createSchool("St. Xavier's Collegiate School", "Kolkata", "Narayan Varma"));
        schools.put("Little Flower High School", createSchool("Little Flower High School", "Hyderabad", "Ayan Mirje"));
        schools.put("The Shri Ram School,", createSchool("The Shri Ram School,", "Gurgaon", "Krishna Tiwari"));
        schools.put("Mother's International", createSchool("Mother's International", "Delhi", "Pratap Singh"));

        
        colleges.put("college1", createCollege("Indian Institute of Science", "Mumbia", "mr. sanjay kumar"));
        colleges.put("college2", createCollege("University of Delhi", "Delhi", "mrs. Rani Shriwastav"));
        colleges.put("college3", createCollege("IIT Kharagpur", "Kharagpur", "mr. Rahul Raj"));
        colleges.put("college4", createCollege("Anna University", "Pune", "Vishwajeet Guraw"));


        
        universities.put("university1", createUniversity("Jawaharlal Nehru University", "Delhi", "mr. Ram Raghuveer"));
        universities.put("university2", createUniversity("Indian Institute of Science", "Mumbai", "mr. Pramod Sham"));
        universities.put("university3", createUniversity("Jamia Millia Islamia", "New Delhi", "mr. Rahim Shekh"));
        universities.put("university4", createUniversity("Jadavpur University", "Bengaluru", "mr. Malikarjun Jaur"));
        universities.put("university5", createUniversity("Manipal Academy of Higher Educatio", "Manipal", "mrs. Sneha Sagar"));
        
        Scanner scanner = new Scanner(System.in);
        boolean continueToMenu = true;

        while (continueToMenu) 
        {
            System.out.println("1. Student Login");
            System.out.println("2. Staff Login");
            System.out.println("3. Admin Login");
            System.out.println("4. Parent Dashboard");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    studentLogin(scanner);
                    break;
                case 2:
                    staffLogin(scanner);
                    break;
                case 3:
                    adminLogin(adminUsername, adminPassword, scanner);
                    break;
                case 4:
                	parentDashboard(scanner);
                    break;
                case 5:
                    continueToMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
    
    private static Map<String, String> createSchool(String name, String address, String principal) {
        Map<String, String> school = new HashMap<>();
        school.put("Name", name);
        school.put("Address", address);
        school.put("Principal", principal);
        return school;
    }

    private static Map<String, String> createCollege(String name, String address, String dean) {
        Map<String, String> college = new HashMap<>();
        college.put("Name", name);
        college.put("Address", address);
        college.put("Dean", dean);
        return college;
    }

    private static Map<String, String> createUniversity(String name, String address, String president) {
        Map<String, String> university = new HashMap<>();
        university.put("Name", name);
        university.put("Address", address);
        university.put("President", president);
        return university;
    }

    private static void studentLogin(Scanner scanner) 
    {
        System.out.println("\nStudent Login");
        System.out.println("1. Have an account");
        System.out.println("2. Register");
        System.out.print("Choose an option: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) 
        {
            case 1:
                System.out.print("Enter student username: ");
                String username = scanner.nextLine();
                System.out.print("Enter student password: ");
                String password = scanner.nextLine();

                if (studentData.containsKey(username)) 
                {
                    if (studentData.get(username).get("password").equals(password)) 
                    {
                        System.out.println("\nStudent login successful.");
                        studentMenu(username, scanner);
                    } 
                    else 
                    {
                        System.out.println("Incorrect password.");
                        System.out.println("1. Retry");
                        System.out.println("2. Forgot password");
                        System.out.print("Choose an option: ");
                        int choice = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice) {
                            case 1:
                                studentLogin(scanner);
                                break;
                            case 2:
                                forgotPassword(username, studentData);
                                break;
                            default:
                                System.out.println("Invalid choice. Exiting...");
                                break;
                        }
                    }
                } 
                else 
                {
                    System.out.println("User does not exist. Exiting...");
                }
                break;
            case 2:
                createStudentAccount(scanner);
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
                break;
        }
    }

    private static void staffLogin(Scanner scanner) 
    {
        System.out.println("\nStaff Login");
        System.out.println("1. Have an account");
        System.out.println("2. Register");
        System.out.print("Choose an option: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) 
        {
            case 1:
                System.out.print("Enter staff username: ");
                String username = scanner.nextLine();
                System.out.print("Enter staff password: ");
                String password = scanner.nextLine();

                if (staffData.containsKey(username)) 
                {
                    Map<String, String> staffDetails = staffData.get(username);
                    if (staffDetails.get("password").equals(password)) 
                    {
                        String role = staffDetails.get("role");
                        System.out.println("\nStaff login successful. Role: " + role);
                        staffMenu(username, role, scanner);
                    } 
                    else 
                    {
                        System.out.println("Incorrect password.");
                        System.out.println("1. Retry");
                        System.out.println("2. Forgot password");
                        System.out.print("Choose an option: ");
                        int choice = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice) 
                        {
                            case 1:
                                staffLogin(scanner);
                                break;
                            case 2:
                                forgotPassword(username, staffData);
                                break;
                            default:
                                System.out.println("Invalid choice. Exiting...");
                                break;
                        }
                    }
                } 
                else 
                {
                    System.out.println("User does not exist. Exiting...");
                }
                break;
            case 2:
                createStaffAccount(scanner);
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
                break;
        }
    }

    private static void forgotPassword(String username, Map<String, Map<String, String>> userData) 
    {
        if (userData.containsKey(username)) 
        {
            System.out.print("Enter a new password: ");
            Scanner scanner = new Scanner(System.in);
			String newPassword = scanner .nextLine();
            Map<String, String> userDetails = userData.get(username);
            userDetails.put("password", newPassword);
            userData.put(username, userDetails);
            System.out.println("Password updated successfully.");
        } 
        else 
        {
            System.out.println("User does not exist.");
        }
    }

    private static void adminLogin(String adminUsername, String adminPassword, Scanner scanner) 
    {
        System.out.print("Enter admin username: ");
        String username = scanner.next();
        
        System.out.print("Enter admin password: ");
        String password = scanner.next();

        if (username.equals(adminUsername) && password.equals(adminPassword)) 
        {
            System.out.println("Admin login successful.");
            adminMenu(scanner);
        } 
        else 
        {
            System.out.println("Incorrect username or password. Exiting...");
        }
    }

    private static void adminMenu(Scanner scanner) 
    {
        boolean continueToAdminMenu = true;

        while (continueToAdminMenu) 
        {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. View all staff details");
            System.out.println("2. View all student details");
            System.out.println("3. View attendance");
            System.out.println("4. Add notice/event for staff");
            System.out.println("5. Edit fee structure");
            System.out.println("6. Answer Queries");
            System.out.println("7. Add notice/event for Parents");
            System.out.println("8. Answer Support Questions");
            System.out.println("9. Logout");
            System.out.print("Choose an option: ");

            int adminChoice = scanner.nextInt();
            scanner.nextLine();

            switch (adminChoice) {
                case 1:
                    viewStaffDetails();
                    break;
                case 2:
                    viewStudentDetails();
                    break;
                case 3:
                    viewAttendanceMenu(scanner);
                    break;
                case 4:
                    addNoticeEvent(scanner);
                    break;
                case 5:
                    editFeeStructure(scanner);
                    break;
                case 6:
                    answerQueries(scanner);
                    break;
                case 7:
                	addParentNotice(scanner);
                    break;
                case 8:
                	answerSupportQuestions(scanner);
                    break;
                case 9:
                    continueToAdminMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    
    private static void viewAnsweredQueries(String username, String userType) 
    {
        System.out.println("Answered Queries:");
        if (userType.equals("student")) 
        {
            if (answeredQueries.containsKey(username)) {
                System.out.println("Your Query: " + queries.get(username));
                System.out.println("Answer: " + answeredQueries.get(username));
            } 
            else 
            {
                System.out.println("You have not raised any queries or your queries have not been answered yet.");
            }
        } 
        else if (userType.equals("staff")) 
        {
            for (Map.Entry<String, String> entry : answeredQueries.entrySet()) 
            {
                System.out.println("Username: " + entry.getKey());
                System.out.println("Query: " + queries.get(entry.getKey()));
                System.out.println("Answer: " + entry.getValue());
                System.out.println();
            }
        }
    }
    
    private static void answerQueries(Scanner scanner) 
    {
        System.out.println("List of Queries:");
        for (Map.Entry<String, String> entry : queries.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Enter username of query to answer:");
        String username = scanner.nextLine();
        if (queries.containsKey(username)) 
        {
            System.out.println("Enter your answer:");
            String answer = scanner.nextLine();
            answeredQueries.put(username, answer);
            System.out.println("Query answered successfully.");
        } 
        else {
            System.out.println("Query not found.");
        }
    }
    
    private static void editFeeStructure(Scanner scanner) 
    {
        boolean continueEditing = true;

        while (continueEditing) 
        {
            System.out.println("\nCurrent Fee Structure:");
            for (Map.Entry<String, Double> entry : feeStructure.entrySet()) 
            {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            System.out.println("\nEdit Fee Structure:");
            System.out.println("1. Edit an existing fee item");
            System.out.println("2. Add a new fee item");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) 
            {
                case 1:
                    editExistingFeeItem(scanner);
                    break;
                case 2:
                    addNewFeeItem(scanner);
                    break;
                case 3:
                    continueEditing = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
    
    private static void addNoticeEvent(Scanner scanner) 
    {
        System.out.println("Enter the date of the event or notice (YYYY-MM-DD):");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        System.out.println("Enter the role of staff (or type 'all' to show to all staff):");
        String role = scanner.nextLine();

        System.out.println("Enter the description of the notice/event:");
        String description = scanner.nextLine();

        notices.put(date, role + ": " + description);
        System.out.println("Notice/Event added successfully.");
    }

    private static void editExistingFeeItem(Scanner scanner) 
    {
        System.out.print("Enter the fee item to edit (or type 'exit' to go back): ");
        String feeItem = scanner.nextLine();

        if (feeItem.equalsIgnoreCase("exit")) 
        {
            return;
        }

        if (!feeStructure.containsKey(feeItem)) 
        {
            System.out.println("Invalid fee item. Please try again.");
            return;
        }

        System.out.print("Enter the new fee amount: ");
        double newFeeAmount = scanner.nextDouble();
        scanner.nextLine();

        feeStructure.put(feeItem, newFeeAmount);
        System.out.println("Fee structure updated successfully.");
    }

    private static void addNewFeeItem(Scanner scanner) 
    {
        System.out.print("Enter the new fee item: ");
        String newFeeItem = scanner.nextLine();

        if (feeStructure.containsKey(newFeeItem)) 
        {
            System.out.println("Fee item already exists. Please enter a different fee item.");
            return;
        }

        System.out.print("Enter the fee amount for " + newFeeItem + ": ");
        double feeAmount = scanner.nextDouble();
        scanner.nextLine();

        feeStructure.put(newFeeItem, feeAmount);
        System.out.println("New fee item added successfully.");
    }

    private static void studentMenu(String username, Scanner scanner) {
        boolean continueToStudentMenu = true;

        while (continueToStudentMenu) {
            System.out.println("\nStudent Menu:");
            System.out.println("1. About");
            System.out.println("2. Contact Us");
            System.out.println("3. Teaching Staff");
            //System.out.println("4. Give Attendance");
            System.out.println("4. View Fee Structure");
            System.out.println("5. Raise Query");
            System.out.println("6. View Answered Queries");
            System.out.println("7. Logout");
            System.out.println("8. Go back to main menu");
            System.out.print("Choose an option: ");

            int studentChoice = scanner.nextInt();
            scanner.nextLine();

            switch (studentChoice) {
                case 1:
                	displayAboutUs();
                    break;
                case 2:
                	displayContactUs();
                    break;
                case 3:
                    displayTeachingStaff();
                    break;
               /* case 4:
                    giveStudentAttendance(username);
                    break;*/
                case 4:
                    viewFeeStructure();
                    break;
                case 5:
                    raiseQuery(username, "student", scanner);
                    break;
                case 6:
                    viewAnsweredQueries(username, "student");
                    break;
                case 7:
                    System.out.println("Logging out...");
                    return;
                case 8:
                    continueToStudentMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    
    private static void displayAboutUs() 
    {
        
        JFrame frame = new JFrame("About Us");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\TaskPhase3\\img\\about2.jpg"); 
        JLabel label = new JLabel(imageIcon);
        frame.add(label);

        frame.setVisible(true);
    }

    private static void displayContactUs() 
    {
        
        JFrame frame = new JFrame("Contact Us");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);

        try {
            File imageFile = new File("C:\\Users\\HP\\eclipse-workspace\\TaskPhase3\\img\\about1.jpg");
            if (imageFile.exists()) {
                ImageIcon imageIcon = new ImageIcon(imageFile.getPath());
                JLabel label = new JLabel(imageIcon);
                frame.add(label);
                frame.setVisible(true);
            } 
            else 
            {
                System.out.println("Image file not found.");
            }
        } 
        catch (Exception e) 
        {
            System.out.println("An error occurred while trying to display the image.");
            e.printStackTrace();
        }
    }

    private static void displayTeachingStaff() 
    {
    	System.out.println("Teaching Staff:");
        System.out.println("1. Mathematics - Ganesh Suryawanshi");
        System.out.println("2. Science - Mis. Javed");
        System.out.println("3. English - Marshal pirera");
        System.out.println("4. History - Ravi Athawale");
        System.out.println("5. Geography - Raju Rastogi");
        System.out.println("6. Computer Science - Sarah Lee");
        System.out.println("7. Physical Education - James Taylor");
        System.out.println();
    }
    
    private static void viewFeeStructure() 
    {
        System.out.println("\nFee Structure:");
        for (Map.Entry<String, Double> entry : feeStructure.entrySet()) 
        {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


    private static void staffMenu(String username, String role, Scanner scanner) {
        boolean continueToStaffMenu = true;

        while (continueToStaffMenu) {
            System.out.println("\nStaff Menu:");
            System.out.println("1. Give Attendance");
            System.out.println("2. Take Attendance");
            System.out.println("3. View Notices/Events");
            System.out.println("4. Raise Query");
            System.out.println("5. View Answered Queries");
            System.out.println("6. View Student Attendance");
            System.out.println("7. Change Absent to Present");
            System.out.println("8. Change Present to Absent");
            System.out.println("9. Answer Student Queries");
            System.out.println("10. Go back to main menu");
            System.out.print("Choose an option: ");

            int staffChoice = scanner.nextInt();
            scanner.nextLine();

            switch (staffChoice) {
                case 1:
                    giveStaffAttendance(username);
                    break;
                case 2:
                    takeAttendance(scanner, role);
                    break;
                case 3:
                    viewNotices(role);
                    break;
                case 4:
                    raiseQuery(username, "staff", scanner);
                    break;
                case 5:
                    viewAnsweredQueries(username, "staff");
                    break;
                case 6:
                    viewStudentAttendance2();
                    break;
                case 7:
                    changeAttendanceStatus("present", scanner);
                    break;
                case 8:
                    changeAttendanceStatus("absent", scanner);
                    break;
                case 9:
                	answerStudentQueries(scanner);
                    break;
                case 10:
                    continueToStaffMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    
    private static void answerStudentQueries(Scanner scanner) 
    {
        System.out.println("List of Student Queries:");
        for (Map.Entry<String, String> entry : queries.entrySet()) 
        {
            String username = entry.getKey();
            if (studentData.containsKey(username) && !answeredQueries.containsKey(username)) 
            {
                System.out.println(username + ": " + entry.getValue());
            }
        }

        System.out.println("Enter username of query to answer:");
        String username = scanner.nextLine();
        if (queries.containsKey(username) && !answeredQueries.containsKey(username)) 
        {
            System.out.println("Enter your answer:");
            String answer = scanner.nextLine();
            answeredQueries.put(username, answer);
            System.out.println("Query answered successfully.");
        } 
        else 
        {
            System.out.println("Query not found or already answered.");
        }
    }

 
    private static void viewStudentAttendance2() 
    {
        System.out.println("\nStudent Attendance:");
        for (Map.Entry<String, Map<String, String>> entry : studentData.entrySet()) 
        {
            String username = entry.getKey();
            Map<String, String> studentDetails = entry.getValue();
            String rollNumber = studentDetails.get("rollNumber");
            String name = studentDetails.get("name");

            if (studentAttendance.containsKey(username)) 
            {
                System.out.println("Roll Number: " + rollNumber + ", Name: " + name + ", Status: Present");
            } 
            else 
            {
                System.out.println("Roll Number: " + rollNumber + ", Name: " + name + ", Status: Absent");
            }
        }
    }
    
    private static void changeAttendanceStatus(String status, Scanner scanner) 
    {
        LocalDateTime now = LocalDateTime.now();
        LocalTime time = now.toLocalTime();

        if (time.isBefore(LocalTime.of(10, 0)) || time.isAfter(LocalTime.of(17, 0))) 
        {
            System.out.println("Attendance status can only be changed between 10:00 AM and 5:00 PM.");
            return;
        }

        System.out.print("Enter the roll number of the student: ");
        String rollNumber = scanner.nextLine();

        for (Map.Entry<String, Map<String, String>> entry : studentData.entrySet()) 
        {
            String username = entry.getKey();
            Map<String, String> studentDetails = entry.getValue();
            String studentRollNumber = studentDetails.get("rollNumber");

            if (studentRollNumber.equals(rollNumber)) 
            {
                if (status.equals("present")) 
                {
                    studentAttendance.put(username, LocalDate.now());
                    System.out.println("Attendance status changed to Present for student with roll number " + rollNumber);
                } 
                else if (status.equals("absent")) 
                {
                    studentAttendance.remove(username);
                    System.out.println("Attendance status changed to Absent for student with roll number " + rollNumber);
                }
                return;
            }
        }

        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    
    private static void takeAttendance(Scanner scanner, String role) 
    {
        if (role.equals("Teacher")) 
        { 
            System.out.print("Enter the roll number of the student: ");
            String rollNumber = scanner.nextLine();

            LocalDateTime now = LocalDateTime.now();
            LocalTime time = now.toLocalTime();
            LocalDate date = now.toLocalDate();

            if (time.isBefore(LocalTime.of(10, 0)) || time.isAfter(LocalTime.of(17, 0))) 
            {
                System.out.println("Attendance cannot be taken at this time.");
                return;
            }

            String username = ""; 

          
            for (Map.Entry<String, Map<String, String>> entry : studentData.entrySet()) 
            {
                Map<String, String> studentDetails = entry.getValue();
                if (studentDetails.get("rollNumber").equals(rollNumber)) 
                {
                    username = entry.getKey(); 
                    break;
                }
            }

            if (username.isEmpty()) 
            { 
                System.out.println("Student not found.");
                return;
            }

            if (!studentAttendance.containsKey(username) || !studentAttendance.get(username).equals(date)) 
            {
                studentAttendance.put(username, date);
                System.out.println("Attendance taken successfully for today.");
            } 
            else 
            {
                System.out.println("Attendance already taken for today.");
            }
        } 
        else 
        {
            System.out.println("You do not have permission to take attendance.");
        }
    }
    
    private static void raiseQuery(String username, String userType, Scanner scanner) 
    {
        System.out.println("Enter your query:");
        String query = scanner.nextLine();
        queries.put(username, query);
        System.out.println("Query raised successfully.");
    }

    
    private static void viewNotices(String staffRole) 
    {
        System.out.println("Notices/Events:");

        notices.entrySet().stream()
                .filter(entry -> entry.getKey().isAfter(LocalDate.now())) 
                .filter(entry -> {
                    String[] parts = entry.getValue().split(":");
                    String role = parts[0].trim();
                    return role.equalsIgnoreCase("all") || role.equalsIgnoreCase(staffRole);
                })
                .sorted(Comparator.comparing(Map.Entry::getKey)) 
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    private static void viewStaffDetails() 
    {
        System.out.println("\nStaff Details:");
        for (Map.Entry<String, Map<String, String>> entry : staffData.entrySet()) 
        {
            System.out.println("Username: " + entry.getKey());
            Map<String, String> details = entry.getValue();
            System.out.println("Name: " + details.get("name"));
            System.out.println("ID: " + details.get("id"));
            System.out.println("Role: " + details.get("role"));
            System.out.println();
        }
    }

    private static void viewStudentDetails() 
    {
        System.out.println("\nStudent Details:");
        for (Map.Entry<String, Map<String, String>> entry : studentData.entrySet()) 
        {
            System.out.println("Username: " + entry.getKey());
            Map<String, String> details = entry.getValue();
            System.out.println("Name: " + details.get("name"));
            System.out.println("Roll Number: " + details.get("rollNumber"));
            System.out.println();
        }
    }

    private static void viewAttendanceMenu(Scanner scanner) 
    {
        boolean continueToAttendanceMenu = true;

        while (continueToAttendanceMenu) 
        {
            System.out.println("\nAttendance Menu:");
            System.out.println("1. View staff attendance");
            System.out.println("2. View student attendance");
            System.out.println("3. Go back to admin menu");
            System.out.print("Choose an option: ");

            int attendanceChoice = scanner.nextInt();
            scanner.nextLine();

            switch (attendanceChoice) 
            {
                case 1:
                    viewStaffAttendance();
                    break;
                case 2:
                    viewStudentAttendance();
                    break;
                case 3:
                    continueToAttendanceMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void viewStaffAttendance() 
    {
        System.out.println("\nStaff Attendance:");
        for (Map.Entry<String, LocalDate> entry : staffAttendance.entrySet()) 
        {
            String username = entry.getKey();
            LocalDate date = entry.getValue();
            Map<String, String> staffDetails = staffData.get(username);

            System.out.println("Name: " + staffDetails.get("name"));
            System.out.println("ID: " + staffDetails.get("id"));
            System.out.println("Role: " + staffDetails.get("role"));
            System.out.println("Date: " + date);
            System.out.println();
        }
    }

    private static void viewStudentAttendance() 
    {
        System.out.println("\nStudent Attendance:");
        for (Map.Entry<String, LocalDate> entry : studentAttendance.entrySet()) 
        {
            String username = entry.getKey();
            LocalDate date = entry.getValue();
            Map<String, String> studentDetails = studentData.get(username);

            if (studentDetails != null) {
                System.out.println("Name: " + studentDetails.get("name"));
                System.out.println("Roll Number: " + studentDetails.get("rollNumber"));
                System.out.println("Date: " + date);
                System.out.println();
            } 
            else 
            {
                System.out.println("Student details not found for username: " + username);
            }
        }
    }

    private static void createStudentAccount(Scanner scanner) 
    {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student roll number: ");
        String rollNumber = scanner.nextLine();
        System.out.print("Enter student username: ");
        String username = scanner.nextLine();
        if(studentData.containsKey(username)) 
        {
            System.out.println("Username already exists. Please choose another username.");
            return;
        }
        System.out.print("Enter student password: ");
        String password = scanner.nextLine();

        Map<String, String> studentDetails = new HashMap<>();
        studentDetails.put("name", name);
        studentDetails.put("rollNumber", rollNumber);
        studentDetails.put("password", password);

        studentData.put(username, studentDetails);
        System.out.println("Student account created successfully.");
    }

    private static void createStaffAccount(Scanner scanner) 
    {
        System.out.print("Enter staff name: ");
        String name = scanner.nextLine();
        System.out.print("Enter staff ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter staff role: ");
        String role = scanner.nextLine();
        System.out.print("Enter staff username: ");
        String username = scanner.nextLine();
        if(staffData.containsKey(username)) 
        {
            System.out.println("Username already exists. Please choose another username.");
            return;
        }
        System.out.print("Enter staff password: ");
        String password = scanner.nextLine();

        Map<String, String> staffDetails = new HashMap<>();
        staffDetails.put("name", name);
        staffDetails.put("id", id);
        staffDetails.put("role", role);
        staffDetails.put("password", password);

        staffData.put(username, staffDetails);
        System.out.println("Staff account created successfully.");
    }

    private static void giveStudentAttendance(String username) 
    {
        LocalDateTime now = LocalDateTime.now();
        LocalTime time = now.toLocalTime();
        LocalDate date = now.toLocalDate();
        if (time.isBefore(LocalTime.of(10, 0)) || time.isAfter(LocalTime.of(18, 0))) 
        {
            System.out.println("Attendance cannot be given at this time.");
            return;
        }

        if (!studentAttendance.containsKey(username) || !studentAttendance.get(username).equals(date)) {
            studentAttendance.put(username, date);
            System.out.println("Attendance given successfully for today.");
        } 
        else 
        {
            System.out.println("Attendance already given for today.");
        }
    }

    private static void giveStaffAttendance(String username) 
    {
        LocalDateTime now = LocalDateTime.now();
        LocalTime time = now.toLocalTime();
        LocalDate date = now.toLocalDate();
        if (time.isBefore(LocalTime.of(10, 0)) || time.isAfter(LocalTime.of(17, 0))) 
        {
            System.out.println("Attendance cannot be given at this time.");
            return;
        }

        if (!staffAttendance.containsKey(username) || !staffAttendance.get(username).equals(date)) {
            staffAttendance.put(username, date);
            System.out.println("Attendance given successfully for today.");
        } 
        else 
        {
            System.out.println("Attendance already given for today.");
        }
    }
    
    private static void parentDashboard(Scanner scanner) {
        boolean continueToParentDashboard = true;

        while (continueToParentDashboard) {
            System.out.println("\nParent Dashboard:");
            System.out.println("1. Home");
            System.out.println("2. About Us");
            System.out.println("3. Contact Us");
            System.out.println("4. Notice");
            System.out.println("5. Career");
            System.out.println("6. Faculty Details");
            System.out.println("7. Schools");
            System.out.println("8. Colleges");
            System.out.println("9. University");
            System.out.println("10. Awards & Certifications");
            System.out.println("11. Reviews & Ratings");
            System.out.println("12. Support");
            System.out.println("13. Go back");
            System.out.print("Choose an option: ");

            int parentChoice = scanner.nextInt();
            scanner.nextLine();

            switch (parentChoice) {
                case 1:
                	parentDashboard(scanner);
                    break;
                case 2:
                	displayAboutUs();
                    break;
                case 3:
                    displayContactUs();
                    break;
                case 4:
                	displayParentNotices();
                    break;
                case 5:
                	displayCareer();
                    break;
                case 6:
                    displayFacultyDetails();
                    break;
                case 7:
                	displaySchools();
                    break;
                case 8:
                	displayColleges();
                    break;
                case 9:
                	displayUniversities();
                    break;
                case 10:
                	displayAwardsAndCertifications();
                    break;
                case 11:
                	handleReviewsAndRatings(scanner);
                    break;
                case 12:
                	supportOption(scanner);
                    break;
                case 13:
                    continueToParentDashboard = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    
    private static void displayCareer() 
    {
        System.out.println("Career Opportunities at Our School:");

        System.out.println("1. Internship Programs: We offer internship programs in collaboration with various industries to provide students with practical experience.");
        System.out.println("2. Career Counseling: Our experienced counselors provide guidance and support to help students explore career options and make informed decisions.");
        System.out.println("3. Job Placement Assistance: We assist students in finding suitable job opportunities by organizing career fairs and connecting them with potential employers.");
        System.out.println("4. Skill Development Workshops: We conduct workshops and training sessions to enhance students' skills and prepare them for the workforce.");
        System.out.println("5. Alumni Network: Our strong alumni network provides mentorship and networking opportunities for current students to learn from successful professionals.");

        System.out.println("For more information, please contact the school administration.");
    }

    
    private static void displayFacultyDetails() 
    {
        System.out.println("Faculty Details:");

        System.out.println("1. Mathematics Department:");
        System.out.println("   - Mr. Ganesh Suryawanshi (Head of Department)");
        System.out.println("   - Ms. Mahi koli");
        System.out.println("   - Mr. Rajesh Harale");

        System.out.println("2. Science Department:");
        System.out.println("   - Ms. Jyoti Pawar (Head of Department)");
        System.out.println("   - Mr. Akash Yadav");
        System.out.println("   - Ms. Radha Mali");

        System.out.println("3. English Department:");
        System.out.println("   - Mr. Sunil Kulkarni (Head of Department)");
        System.out.println("   - Ms. Priya Mane");
        System.out.println("   - Mr. Anil Rathod");
    }
    
    private static void addParentNotice(Scanner scanner) 
    {
        System.out.print("Enter the topic of the notice: ");
        String topic = scanner.nextLine();
        System.out.print("Enter the content of the notice: ");
        String content = scanner.nextLine();

        LocalDate date = LocalDate.now();
        String[] noticeDetails = {topic, content};
        parentNotices.put(date, noticeDetails);

        System.out.println("Notice added successfully for parents.");
    }
    
    private static void displayParentNotices() 
    {
        System.out.println("Notices for Parents:");
        for (Map.Entry<LocalDate, String[]> entry : parentNotices.entrySet()) 
        {
            LocalDate date = entry.getKey();
            String[] noticeDetails = entry.getValue();
            System.out.println("Date: " + date);
            System.out.println("Topic: " + noticeDetails[0]);
            System.out.println("Content: " + noticeDetails[1]);
            System.out.println();
        }
    }
    
    private static void displayUniversities() 
    {
        System.out.println("Universities:");
        universities.forEach((key, value) -> {
            System.out.println("Name: " + value.get("Name"));
            System.out.println("Address: " + value.get("Address"));
            System.out.println("President: " + value.get("President"));
            System.out.println();
        });
    }

    private static void displayColleges() 
    {
        System.out.println("Colleges:");
        colleges.forEach((key, value) -> {
            System.out.println("Name: " + value.get("Name"));
            System.out.println("Address: " + value.get("Address"));
            System.out.println("Dean: " + value.get("Dean"));
            System.out.println();
        });
    }

    private static void displaySchools() 
    {
        System.out.println("Schools:");
        schools.forEach((key, value) -> {
            System.out.println("Name: " + value.get("Name"));
            System.out.println("Address: " + value.get("Address"));
            System.out.println("Principal: " + value.get("Principal"));
            System.out.println();
        });
    }
    
    private static void displayAwardsAndCertifications() 
    {
        System.out.println("Awards for the School:");
        System.out.println("- Best School Award");
        System.out.println("- Academic Excellence Award");
        System.out.println("- Sports Championship Trophy");

        System.out.println("Certifications for the School:");
        System.out.println("- Green School Certification");
        System.out.println("- National Quality Award");
    }
    
    private static void handleReviewsAndRatings(Scanner scanner) 
    {
        System.out.println("Reviews & Ratings Options:");
        System.out.println("1. See Reviews & Ratings");
        System.out.println("2. Give Reviews & Ratings");

        int choice = scanner.nextInt();
        switch (choice) 
        {
            case 1:
                seeReviewsAndRatings();
                break;
            case 2:
                giveReviewsAndRatings(scanner);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private static void seeReviewsAndRatings() 
    {
        if (reviewsAndRatings.isEmpty()) 
        {
            System.out.println("No reviews and ratings available.");
        } 
        else 
        {
            System.out.println("Reviews & Ratings:");
            for (Map.Entry<String, Map<String, String>> entry : reviewsAndRatings.entrySet()) {
                System.out.println("Gmail ID: " + entry.getKey());
                Map<String, String> reviewDetails = entry.getValue();
                for (Map.Entry<String, String> reviewEntry : reviewDetails.entrySet()) {
                    System.out.println(reviewEntry.getKey() + ": " + reviewEntry.getValue());
                }
                System.out.println();
            }
        }
    }

    private static void giveReviewsAndRatings(Scanner scanner) 
    {
        System.out.println("Enter your Gmail ID:");
        String gmailId = scanner.next();

        System.out.println("Enter your name:");
        String name = scanner.next();

        System.out.println("Enter your review:");
        String review = scanner.next();

        System.out.println("Enter your rating (1 to 5):");
        int rating = scanner.nextInt();

        if (rating < 1 || rating > 5) 
        {
            System.out.println("Invalid rating. Please enter a rating between 1 and 5.");
            return;
        }

        Map<String, String> reviewMap = new HashMap<>();
        reviewMap.put("Name", name);
        reviewMap.put("Review", review);
        reviewMap.put("Rating", String.valueOf(rating));

        reviewsAndRatings.put(gmailId, reviewMap);
        System.out.println("Review and rating submitted successfully.");
    }
    
    private static void supportOption(Scanner scanner) 
    {
        System.out.println("Support Option:");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your Gmail ID: ");
        String gmailId = scanner.nextLine();

        System.out.print("Enter your question: ");
        String question = scanner.nextLine();

        
        supportQuestions.put(name + " (" + gmailId + ")", question);

        System.out.println("Thank you! Your question has been submitted.");
    }
    
    private static void answerSupportQuestions(Scanner scanner) 
    {
        System.out.println("Answer Support Questions:");

        
        for (Map.Entry<String, String> entry : supportQuestions.entrySet()) 
        {
            String parentInfo = entry.getKey();
            String question = entry.getValue();
            System.out.println("Question from: " + parentInfo);
            System.out.println("Question: " + question);
        }

        
        System.out.print("Enter the email ID of the user to answer the question: ");
        String parentEmail = scanner.nextLine();

        
        if (supportQuestions.containsKey(parentEmail)) 
        {
            
            String question = supportQuestions.get(parentEmail);

           
            System.out.print("Enter your answer: ");
            String answer = scanner.nextLine();

           
            answeredSupportQuestions.put(parentEmail, answer);

            
            sendEmail(parentEmail, answer);

            System.out.println("Question answered successfully.");
        } 
        else 
        {
            System.out.println("No question found for the entered email ID.");
        }
    }
    
    private static void sendEmail(String recipient, String answer) 
    {

        System.out.println("Email sent to " + recipient + " with the answer: " + answer);
    }
}
