/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2020/1/14
 * Time: 9:53
 */
class Students implements Comparable<Students>{
    private String name;
    private String team;
    private double score;

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", score=" + score +
                '}';
    }

    public Students(String name, String team, double score) {
        this.name = name;
        this.team = team;
        this.score = score;
    }

    @Override
    public int compareTo(Students o) {
        return (int)(this.score-o.score);
    }
}
