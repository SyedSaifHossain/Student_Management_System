import java.util.Scanner

// Define Data Class For Student.
data class Student(
    var name: String,
    var age: String,
    var gender: String,
    var studentID: String,
    var grade: String
)

// Define Data Class For Teacher.
data class Teacher(
    var name: String,
    var age: String,
    var gender: String,
    var employID: String,
    var subject: String
)

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val students = createStudentList()
    val teachers = createTeacherList()

    while (true) {
        println("Welcome to student management system")
        print("Enter Your UserName: ")
        val userName = input.nextLine()

        if (userName == "0" || userName.equals("Exit", ignoreCase = true) || userName.equals("exit", ignoreCase = true)) break

        if (userName == "Saif") {
            print("Enter Your Password: ")
            val password = input.nextLine()

            if (password == "12345") {
                println("Access Granted")
                while (true) {
                    print(
                        "Please Select your Choice:\n" +
                                "1. Teacher\n" +
                                "2. Student\n" +
                                "\n" +
                                "Enter the number corresponding to your Choice and press Enter.\n"
                    )
                    val choice = input.nextLine()
                    if (choice == "0" || choice.equals("Exit", ignoreCase = true)) break

                    when (choice) {
                        "1" -> {
                            println("You have chosen: Teacher")
                            searchTeacher(teachers, input)
                        }
                        "2" -> {
                            println("You have chosen: Student")
                            searchStudent(students, input)
                        }
                        else -> {
                            println("Invalid Choice")
                        }
                    }
                }
            } else {
                println("Invalid User Name & Password. Try Again")
            }
        } else {
            println("Invalid User Name. Try Again")
        }
    }
}

// Function to create a list of students
fun createStudentList(): List<Student> {
    return listOf(
        //------------------------Grade A------------------------
        Student("Habib", "18", "Male", "101", "A"),
        Student("Bob", "17", "Male", "102", "A"),
        Student("Rayhan", "19", "Male", "103", "A"),
        Student("Grace", "17", "Female", "105", "A"),
        Student("David", "18", "Male", "105", "A"),
        //------------------------Grade B--------------------------
        Student("John", "17", "Male", "106", "B"),
        Student("Tareq", "18", "Male", "107", "B"),
        Student("Mark", "19", "Male", "108", "B"),
        Student("Sophia", "18", "Female", "109", "B"),
        Student("Oliver", "17", "Male", "110", "B"),
        //------------------------Grade C--------------------------
        Student("Tanzim", "19", "Male", "111", "C"),
        Student("Michael", "18", "Male", "112", "C"),
        Student("Chloe", "17", "Female", "113", "C"),
        Student("Ava", "18", "Female", "114", "C"),
        Student("William", "17", "Male", "115", "C"),
        //------------------------Grade D---------------------------
        Student("Danial", "19", "Male", "116", "D"),
        Student("Mia", "17", "Female", "117", "D"),
        Student("James", "18", "Male", "118", "D"),
        Student("Emma", "19", "Female", "119", "D"),
        Student("Logan", "17", "Male", "120", "D"),
        //------------------------Grade E----------------------------
        Student("Olivia", "18", "Female", "121", "E"),
        Student("Benjamin", "17", "Male", "122", "E"),
        Student("Aria", "19", "Female", "123", "E"),
        Student("Lucas", "18", "Male", "124", "E"),
        Student("Isabella", "17", "Female", "125", "E"),
        //------------------------Grade F---------------------------
        Student("Jackson", "19", "Male", "126", "F"),
        Student("Sofia", "18", "Female", "127", "F"),
        Student("Logan", "17", "Male", "128", "F"),
        Student("Ella", "18", "Female", "129", "F"),
        Student("Jacob", "17", "Male", "130", "F")
    )
}

// Function to create a list of teachers
fun createTeacherList(): List<Teacher> {
    return listOf(
        //------------------------Grade A------------------------
        Teacher("Anisul Islam", "18", "Male", "101", "Java"),
        Teacher("Bob", "17", "Male", "102", "HTML"),
        Teacher("Eva", "19", "Female", "103", "Kotlin"),
        Teacher("David", "18", "Male", "104", "C++"),
        Teacher("Lukman", "17", "Male", "105", "Python"),
        //------------------------Grade B--------------------------
        Teacher("John", "17", "Male", "106", "C++"),
        Teacher("Lily", "18", "Female", "107", "HTML"),
        Teacher("Mark", "19", "Male", "108", "Kotlin"),
        Teacher("Sophia", "18", "Female", "109", "Java"),
        Teacher("Oliver", "17", "Male", "110", "Python"),
        //------------------------Grade C--------------------------
        Teacher("Emily", "19", "Female", "111", "C++"),
        Teacher("Michael", "18", "Male", "112", "HTML"),
        Teacher("Chloe", "17", "Female", "113", "Kotlin"),
        Teacher("William", "17", "Male", "114", "Java"),
        Teacher("Ava", "18", "Female", "115", "Python"),
        //------------------------Grade D---------------------------
        Teacher("Danial", "19", "Male", "116", "C++"),
        Teacher("Mia", "17", "Female", "117", "HTML"),
        Teacher("James", "18", "Male", "118", "Kotlin"),
        Teacher("Emma", "19", "Female", "119", "Java"),
        Teacher("Logan", "17", "Male", "120", "Python"),
        //------------------------Grade E----------------------------
        Teacher("Olivia", "18", "Female", "121", "C++"),
        Teacher("Benjamin", "17", "Male", "122", "HTML"),
        Teacher("Aria", "19", "Female", "123", "Kotlin"),
        Teacher("Lucas", "18", "Male", "124", "Java"),
        Teacher("Isabella", "17", "Female", "125", "Python"),
        //------------------------Grade F---------------------------
        Teacher("Jackson", "19", "Male", "126", "C++"),
        Teacher("Sofia", "18", "Female", "127", "HTML"),
        Teacher("Logan", "17", "Male", "128", "Kotlin"),
        Teacher("Ella", "18", "Female", "129", "Java"),
        Teacher("Jacob", "17", "Male", "130", "Python")
    )
}

// Function to search for a teacher
fun searchTeacher(teachers: List<Teacher>, input: Scanner) {
    print("Enter teacher keyword: ")
    val keyword = input.nextLine()

    val filteredTeachers = teachers.filter {
        it.employID == keyword ||
                it.age == keyword ||
                it.name.equals(keyword, ignoreCase = true) ||
                it.subject.equals(keyword, ignoreCase = true) ||
                it.gender.equals(keyword, ignoreCase = true)
    }

    if (filteredTeachers.isNotEmpty()) {
        println("Found teacher(s):")
        for (teacher in filteredTeachers) {
            println("Name: ${teacher.name}")
            println("Age: ${teacher.age}")
            println("Gender: ${teacher.gender}")
            println("Teacher ID: ${teacher.employID}")
            println("Subject: ${teacher.subject}")
            println()
        }
    } else {
        println("No matching teacher found.")
    }
}

// Function to search for a student
fun searchStudent(students: List<Student>, input: Scanner) {
    print("Enter student keyword: ")
    val keyword = input.nextLine()

    val filteredStudents = students.filter {
        it.studentID == keyword ||
                it.grade == keyword ||
                it.age == keyword ||
                it.name.equals(keyword, ignoreCase = true) ||
                it.gender.equals(keyword, ignoreCase = true)
    }

    if (filteredStudents.isNotEmpty()) {
        println("Found student(s):")
        for (student in filteredStudents) {
            println("Name: ${student.name}")
            println("Age: ${student.age}")
            println("Gender: ${student.gender}")
            println("Student ID: ${student.studentID}")
            println("Grade: ${student.grade}")
            println()
        }
    } else {
        println("No matching student found.")
    }
}