/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author sabuhi
 */
public class EmploymentHistory {

    private int id;
    private User user;
    private String header;
    private String jobDescription;

    public EmploymentHistory(int id, User user, String header, String jobDescription) {
        this.id = id;
        this.user = user;
        this.header = header;
        this.jobDescription = jobDescription;
    }

    public EmploymentHistory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    @Override
    public String toString() {
        return "EmploymentHistory{" + "id=" + id + ", user=" + user + ", header=" + header + ", jobDescription=" + jobDescription + '}';
    }

}
