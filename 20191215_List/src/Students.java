/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/15
 * Time: 13:31
 */
 class Students  {
     private String name;
     private String team;
     private double grade;

    public Students(String name, String team, double grade) {
        this.name = name;
        this.team = team;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", grade=" + grade +
                '}'+'\n';
    }
}
