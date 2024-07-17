import java.lang.reflect.Field;

public class Main {
    // вывод значения без использования getAge, правда я решил переопределить toString
    public static void outputWithoutGet () {
        try {
            Mentor mentor = new Mentor();
            Field f = mentor.getClass().getDeclaredField("age");
            f.setAccessible(true);
            f.setInt(mentor, 110);
            System.out.println(mentor);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    // вывод значения используя  getAge
    public static void outputWithGet () {
        Mentor mentor = new Mentor();
        mentor.setAge(100);
        System.out.println(mentor.getAge());
    }
    // присвоение невалдиного значения с помощи рефлексии, как я
    // валидация не работает так как мы не используем наш set метод, а как-то"напрямую" задаем значение
    public static void unValidationWithReflaction () {
        try {
            Mentor mentor = new Mentor();
            Field f = mentor.getClass().getDeclaredField("age");
            f.setAccessible(true);
            f.setInt(mentor, 200);
            System.out.println(mentor);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        outputWithGet();
        outputWithoutGet();
        unValidationWithReflaction();

    }
}