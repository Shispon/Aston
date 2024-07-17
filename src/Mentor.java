public class Mentor {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int _age) {
        if (_age > 0 && _age < 120)
            this.age = _age;
        else {
            System.out.println("UnValidation value");
            this.age = 0;
        }
    }

    @Override
    public String toString() {
        return "Mentor{" +
                "age=" + age +
                '}';
    }
}
