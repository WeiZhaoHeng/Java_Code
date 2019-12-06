/**
 * Created with IntelliJ IDEA.
 * Description:
 * User：WeiZhaoheng
 * Date: 2019/12/6
 * Time: 20:10
 */
class Money implements Cloneable{
    double money = 10.5;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Person implements Cloneable{
    public String name;
    public Money m;
    public Person(){
        this.m = new Money();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person per = (Person)super.clone();
        per.m = (Money)this.m.clone();
        return per;
    }
}
