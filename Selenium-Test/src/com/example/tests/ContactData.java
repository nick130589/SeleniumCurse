package com.example.tests;

public class ContactData implements Comparable<ContactData> {
    public String firstName;
    public String lastName;
    public String address;
    public String homePhone;
    public String mobilePhone;
    public String workPhone;
    public String firstEmail;
    public String secondEmail;
    public String dayOfBirthday;
    public String monthOfBirthday;
    public String yearOfBirthday;
    public String relatedGroup;
    public String secondAddress;
    public String secondHomePhone;

    public ContactData() {
    }

    public ContactData(String firstName, String lastName, String address, String homePhone, String mobilePhone, String workPhone, String firstEmail, String secondEmail, String dayOfBirthday, String monthOfBirthday, String yearOfBirthday, String relatedGroup, String secondAddress, String secondHomePhone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.workPhone = workPhone;
        this.firstEmail = firstEmail;
        this.secondEmail = secondEmail;
        this.dayOfBirthday = dayOfBirthday;
        this.monthOfBirthday = monthOfBirthday;
        this.yearOfBirthday = yearOfBirthday;
        this.relatedGroup = relatedGroup;
        this.secondAddress = secondAddress;
        this.secondHomePhone = secondHomePhone;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstName='" + firstName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        return !(lastName != null ? !lastName.equals(that.lastName) : that.lastName != null);

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(ContactData other) {
        int lastNameResult = this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
        if (lastNameResult != 0) {
            return lastNameResult;
        }
        return this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase());
    }
}
