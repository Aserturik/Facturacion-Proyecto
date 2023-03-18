package co.edu.uptc.pojo;

public class Person {
    boolean isAdult;
    private static int id;
    private int document;
    private String name;
    private String lastName;
    private String address;
    private String city;

    public Person(boolean isAdult,int document, String name, String lastName, String address, String city) {
        this.isAdult = isAdult;
        this.id++;
        this.document = document;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
    }
    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }

    public String getDocument() {
        return document+"";
    }

    public void setDocument(int document) {
        this.document = document;
    }

    public Person clone(Person originalPerson){
        this.id = originalPerson.id;
        this.document = originalPerson.document;
        this.name = originalPerson.name;
        this.lastName = originalPerson.lastName;
        this.address = originalPerson.address;
        this.city = originalPerson.city;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                "isAdult=" + isAdult +
                ", document=" + document +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
