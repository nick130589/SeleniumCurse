package com.example.tests;

public class ContactData implements Comparable<ContactData> {
    private String firstName;
    private String lastName;
    private String address;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String firstEmail;
    private String secondEmail;
    private String dayOfBirthday;
    private String monthOfBirthday;
    private String yearOfBirthday;
    private String relatedGroup;
    private String secondAddress;
    private String secondHomePhone;

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
                " lastName='" + lastName + '\'' +
                " address='" + address + '\'' +
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

    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }


    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public ContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public ContactData withFirstEmail(String firstEmail) {
        this.firstEmail = firstEmail;
        return this;
    }

    public ContactData withSecondEmail(String secondEmail) {
        this.secondEmail = secondEmail;
        return this;
    }

    public ContactData withDayOfBirthday(String dayOfBirthday) {
        this.dayOfBirthday = dayOfBirthday;
        return this;
    }

    public ContactData withMonthOfBirthday(String monthOfBirthday) {
        this.monthOfBirthday = monthOfBirthday;
        return this;
    }

    public ContactData withYearOfBirthday(String yearOfBirthday) {
        this.yearOfBirthday = yearOfBirthday;
        return this;
    }

    public ContactData withSecondAddress(String secondAddress) {
        this.secondAddress = secondAddress;
        return this;
    }

    public ContactData withSecondHomePhone(String secondHomePhone) {
        this.secondHomePhone = secondHomePhone;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getFirstEmail() {
        return firstEmail;
    }

    public String getSecondEmail() {
        return secondEmail;
    }

    public String getDayOfBirthday() {
        return dayOfBirthday;
    }

    public String getMonthOfBirthday() {
        return monthOfBirthday;
    }

    public String getYearOfBirthday() {
        return yearOfBirthday;
    }

    public String getRelatedGroup() {
        return relatedGroup;
    }

    public String getSecondAddress() {
        return secondAddress;
    }

    public String getSecondHomePhone() {
        return secondHomePhone;
    }
}
