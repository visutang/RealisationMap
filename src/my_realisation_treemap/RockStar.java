package my_realisation_treemap;
/*
 * @author Bohdan Hnatusiv
 * 02.11.2020
 */
import com.sun.deploy.association.Action;
import jdk.nashorn.internal.objects.NativeString;

import java.util.Comparator;
import java.util.Objects;

public class RockStar implements Comparable<RockStar>, Comparator<RockStar> {
    int id;
    String firstName;
    String lastName;
    private int yearOfBirth;
    int age;

    //create constructor
    public RockStar(int id, String firstName, String lastName, int yearOfBirth, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.age = age;
    }

    //create getters & setters & toString
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "RockStar{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Year of birth=" + yearOfBirth +
                ", Age=" + age + " years old . " +
                '}';
    }

    //create method hashCode()
    public int hashCode(RockStar[] rockStars) {
        if (rockStars == null)
            return 0;
        int result = 37;
        for (RockStar element : rockStars)
            result = 37 * result * (element == null ? 0 : element.hashCode());
        return result;

    }

   private static       boolean equals(String firstName, String firstName1) {
       return true;
    }


    //create method .equals()
    public boolean equals(RockStar rockStar) {
        if (this == rockStar) {
            return true;
        } else if (rockStar == null || getClass() != rockStar.getClass()) {
            return false;
        } else
            rockStar = rockStar;
        return id == rockStar.id &&
                yearOfBirth == rockStar.yearOfBirth &&
                age == rockStar.age &&
                RockStar.equals(firstName, rockStar.firstName) &&
                RockStar.equals(lastName, rockStar.lastName);

    }

    //override of natural comparison method(implements Comparable)
    @Override
    public int compareTo(RockStar o) {
        if (id == o.id) {
            return 0;
        } else if (id > o.id) {
            return 1;
        } else
            return -1;
    }


    //create class AgeComparable for Override method compare
    //(compare key age (implements Comparable))
    public class AgeComparable implements Comparable<RockStar> {
        @Override
        public int compareTo(RockStar o) {
            if (age == o.getAge()) {
                return 0;
            } else if (age > o.getAge()) {
                return 1;
            } else
                return -1;

        }
    }
    //create class  YearOfBirthComparable for Override method compare
    //(compare key YearOfBirth (implements Comparable)
   public class YearOfBirthComparable implements Comparable<RockStar> {

        @Override
        public int compareTo(RockStar o) {
            if (yearOfBirth == o.getYearOfBirth()) {
                return 0;
            } else if (yearOfBirth < o.getYearOfBirth()) {
                return 1;
            } else
                return -1;
        }

    }
    //override method compare ()(implements Comparator)

    @Override
    public int compare(RockStar o1, RockStar o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }

    //method comparison strings
    public int compare(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int min = Math.min(n1, n2);
        for (int i = 0; i < min; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

        }
        return n1 - n2;
    }

    //create class LastNameComparator for Override method compare
    //(compare key LastName (implements Comparator))
    public class LastNameComparator implements Comparator<RockStar> {

        @Override
        public int compare(RockStar o1, RockStar o2) {

            return o1.getLastName().compareTo(o2.getLastName());
        }

        //method comparison strings
        public int compare(String s1, String s2) {
            int n1 = s1.length();
            int n2 = s2.length();
            int min = Math.min(n1, n2);
            for (int i = 0; i < min; i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);

            }
            return n1 - n2;
        }

    }



}
