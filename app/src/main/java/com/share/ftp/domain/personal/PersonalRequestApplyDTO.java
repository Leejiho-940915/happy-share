package com.share.ftp.domain.personal;

import java.sql.Date;
import java.util.Objects;

public class PersonalRequestApplyDTO {

  private int no;
  private String title;
  private String sort;
  private String tel;
  private String email;
  private String volunteerPeriod;
  private Date volunteerTime;
  private String volunteerList;
  private String content;
  private String fileUpload;
  private boolean isOrg;
  private boolean isChecked;
  private String isSigned;



  @Override
  public int hashCode() {
    return Objects.hash(content, email, fileUpload, isChecked, isOrg, isSigned, no, sort, tel,
        title, volunteerList, volunteerPeriod, volunteerTime);
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    PersonalRequestApplyDTO other = (PersonalRequestApplyDTO) obj;
    return Objects.equals(content, other.content) && Objects.equals(email, other.email)
        && Objects.equals(fileUpload, other.fileUpload) && isChecked == other.isChecked
        && isOrg == other.isOrg && Objects.equals(isSigned, other.isSigned) && no == other.no
        && Objects.equals(sort, other.sort) && Objects.equals(tel, other.tel)
        && Objects.equals(title, other.title) && Objects.equals(volunteerList, other.volunteerList)
        && Objects.equals(volunteerPeriod, other.volunteerPeriod)
        && Objects.equals(volunteerTime, other.volunteerTime);
  }
  @Override
  public String toString() {
    return "PersonalRequestApplyDTO [no=" + no + ", title=" + title + ", sort=" + sort + ", tel="
        + tel + ", email=" + email + ", volunteerPeriod=" + volunteerPeriod + ", volunteerTime="
        + volunteerTime + ", volunteerList=" + volunteerList + ", content=" + content
        + ", fileUpload=" + fileUpload + ", isOrg=" + isOrg + ", isChecked=" + isChecked
        + ", isSigned=" + isSigned + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getSort() {
    return sort;
  }
  public void setSort(String sort) {
    this.sort = sort;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getVolunteerPeriod() {
    return volunteerPeriod;
  }
  public void setVolunteerPeriod(String volunteerPeriod) {
    this.volunteerPeriod = volunteerPeriod;
  }
  public Date getVolunteerTime() {
    return volunteerTime;
  }
  public void setVolunteerTime(Date volunteerTime) {
    this.volunteerTime = volunteerTime;
  }
  public String getVolunteerList() {
    return volunteerList;
  }
  public void setVolunteerList(String volunteerList) {
    this.volunteerList = volunteerList;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getFileUpload() {
    return fileUpload;
  }
  public void setFileUpload(String fileUpload) {
    this.fileUpload = fileUpload;
  }
  public boolean isOrg() {
    return isOrg;
  }
  public void setIsOrg(boolean isOrg) {
    this.isOrg = isOrg;
  }
  public boolean isChecked() {
    return isChecked;
  }
  public void setChecked(boolean isChecked) {
    this.isChecked = isChecked;
  }
  public String getIsSigned() {
    return isSigned;
  }
  public void setIsSigned(String isSigned) {
    this.isSigned = isSigned;
  }
  public void setOrg(boolean isOrg) {
    this.isOrg = isOrg;
  }






}
