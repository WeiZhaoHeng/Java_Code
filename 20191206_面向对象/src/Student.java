/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/6
 * Time: 19:06
 */
class Student implements Comparable<Student>{
    public String name;
    public int age;
    public double point;
    public Student(String name,int age,double point){
        this.name = name;
        this.age = age;
        this.point = point;
    }

    @Override
    public String toString() {
        return "Student: "+ "name = "+name+"  " +"age = "+age+ "  "+"point = "+ point+'\n';
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }
}

