package com.share.ftp.domain.volunteer;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.share.ftp.domain.Category;
import com.share.ftp.domain.join.JoinDTO;


public class VolunteerRequestDTO implements Serializable {

  private static final long serialVersionUID = 1L;
  private int no;
  private int memberType; 
  private Category type;
  private String title;
  private String content;
  private String tel;
  private String email;
  private Date startDate;
  private Date endDate;
  private String startTime;
  private String endTime;
  private int totalJoinCount = 1; // 현재 참여 인원 (주최자는 미리 포함)
  private String name;
  private String status;
  private JoinDTO owner; 
  private String fileUpload;
  private Date submitTime; 
  private JoinDTO wish;
  private int limitNum; // 총 정원
  private int questionCount;
  private List<JoinDTO> members = new ArrayList<>(); // 봉사 참여한 멤버들




  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public int getMemberType() {
    return memberType;
  }

  public void setMemberType(int memberType) {
    this.memberType = memberType;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public JoinDTO getOwner() {
    return owner;
  }

  public void setOwner(JoinDTO owner) {
    this.owner = owner;
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

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
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

  public Date getSubmitTime() {
    return submitTime;
  }

  public void setSubmitTime(Date submitTime) {
    this.submitTime = submitTime;
  }

  public JoinDTO getWish() {
    return wish;
  }

  public void setWish(JoinDTO wish) {
    this.wish = wish;
  }

  public int getLimitNum() {
    return limitNum;
  }

  public void setLimitNum(int limitNum) {
    this.limitNum = limitNum;
  }

  public int getTotalJoinCount() {
    return totalJoinCount;
  }

  public void setTotalJoinCount(int totalJoinCount) {
    this.totalJoinCount = totalJoinCount;
  }

  public List<JoinDTO> getMembers() {
    return members;
  }

  public void setMembers(List<JoinDTO> members) {
    this.members = members;
  }

  public void addMembers(JoinDTO volMember) {
    this.members.add(volMember);
  }

  public void removeMembers(JoinDTO volMember) {
    this.members.remove(volMember);
  }

  public int getQuestionCount() {
    return questionCount;
  }

  public void setQuestionCount(int questionCount) {
    this.questionCount = questionCount;
  }

  public Category getType() {
    return type;
  }

  public void setType(Category type) {
    this.type = type;
  }

  public String getMemberNames() {
    if (members == null) {
      return "";
    }
    StringBuilder names = new StringBuilder();


    for (JoinDTO joinDTO : members) {
      if (names.length() > 0) {
        names.append("\n");
      }
      names.append(joinDTO.getId()).append("("+joinDTO.getName()+")");
    }
    return names.toString();
  }


}