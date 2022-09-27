package uz.exemple.less62_task3_pref_saveobjects_java.model;

public class MemberModel {
    private String name;
    private int age;
    private String email;

    public MemberModel(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}
