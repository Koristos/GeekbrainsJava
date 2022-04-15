package Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonBuilder {
    String firstName;
    String lastName;
    String middleName;
    String country;
    String address;
    String phone;
    String gender;
    int age;

    Pattern namePattern = Pattern.compile("[a-zA-Z]{3,}");
    Pattern phonePattern = Pattern.compile("[0-9]{10}");

    PersonBuilder(){
        this.firstName = "";
        this.lastName = "";
        this.middleName = "";
        this.country = "";
        this.address = "";
        this.phone = "";
        this.gender = "";
        this.age = -1;

    }

    public void setFirstName(String firstName) {
        if (checkName(firstName)) {
            this.firstName = firstName;
        }else {
            System.out.println("First Name doesnt match, try another one");
        }
    }

    public void setLastName(String lastName) {
        if (checkName(lastName)) {
            this.lastName = lastName;
        }else {
            System.out.println("Last Name doesnt match, try another one");
        }
    }

    public void setMiddleName(String middleName) {
        if (checkName(middleName)) {
            this.middleName = middleName;
        }else {
            System.out.println("Middle Name doesnt match, try another one");
        }
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        if (checkPhone(phone)) {
            this.phone = phone;
        }else {
            System.out.println("Type in correct phone number");
        }
    }

    public void setGender(Gender gender) {
        this.gender = gender.name();
    }

    public void setAge(int age) {
        if (checkAge(age)) {
            this.age = age;
        }else {
            System.out.println("Type in correct age");
        }
    }

    public Person build (){
        if (isBuildPossible()){
            return new Person(firstName, lastName, middleName, country, address, phone, gender, age);
        }else {
            System.out.println("The bulder params are not valid");
            return null;
        }
    }

    private boolean checkName (String name){
        Matcher matcher = namePattern.matcher(name);
        return matcher.matches();
    }

    private boolean checkPhone (String phone){
        Matcher matcher = phonePattern.matcher(phone);
        return matcher.matches();
    }

    private boolean checkAge(int age) {
        if (age >= 0 && age < 120) {
            return true;
        }
        return false;
    }

    private boolean isBuildPossible () {
        List<String> params = new ArrayList<>();
        params.add(firstName);
        params.add(lastName);
        params.add(middleName);
        params.add(country);
        params.add(address);
        params.add(phone);
        params.add(gender);
        params.add(checkAge(age) ? String.valueOf(age) : "");
        return params.stream().noneMatch(String::isBlank);
    }
}

enum Gender{
    MALE,
    FEMALE
}
