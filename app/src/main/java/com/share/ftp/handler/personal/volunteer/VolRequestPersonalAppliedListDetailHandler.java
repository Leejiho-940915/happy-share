package com.share.ftp.handler.personal.volunteer;

import java.util.ArrayList;
import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.personal.PersonalRequestDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolRequestPersonalAppliedListDetailHandler extends AbstractVolRequestPersonalHandler { // 개인 봉사신청 양식 쓰는 곳


  int joinCount;

  List<PersonalRequestDTO> personalSelectedList;
  ArrayList<JoinDTO> members = new ArrayList<>();

  public VolRequestPersonalAppliedListDetailHandler(
      List<PersonalRequestDTO> personalRequestDTOList,
      List<PersonalRequestDTO> personalRequestApplyDTOList,
      List<PersonalRequestDTO> personalRequestRejectDTOList,
      List<PersonalRequestDTO> personalSelectedList
      ) {

    super(personalRequestDTOList, personalRequestApplyDTOList, personalRequestRejectDTOList);
    this.personalSelectedList = personalSelectedList;


  }


  @Override
  public void execute() {
    System.out.println();
    System.out.println("[  봉사 참여  ]");
    System.out.println();
    System.out.println(" ▶ 참여를 원하는 봉사번호를 입력해주세요 ");
    System.out.println();
    int no = Prompt.inputInt("봉사번호 > ");

    PersonalRequestDTO personalRequestApplyDTO = findByApplyVol(no);

    //
    //    if (personalRequestApplyDTOList.isEmpty()) {
    //      System.out.println("[  현재 승인된 봉사목록이 없습니다. ]");
    //      return;
    //    }

    if (personalRequestApplyDTO == null) {
      System.out.println("[  해당 번호의 봉사목록이 없습니다. ]");
    }

    System.out.printf("봉사번호: %d\n"
        + "봉사제목: %s\n"
        + "주최자: %s\n"
        + "봉사분류: %s\n"
        + "전화번호: %s\n"
        + "이메일: %s\n"
        + "봉사시작기간: %s\n"
        + "봉사종료기간: %s\n"
        + "봉사시작시간: %s\n"
        + "봉사종료시간: %s\n"
        + "봉사목록: %s\n"
        + "봉사인원: %d\n"
        + "봉사내용: %s\n"
        + "첨부파일: %s\n\n",
        //          + "승인여부: %b \n",  

        personalRequestApplyDTO.getNo(),      
        personalRequestApplyDTO.getTitle(),     
        personalRequestApplyDTO.getOwner().getName(), 
        //        personalRequestApplyDTO.getName(), 
        personalRequestApplyDTO.getSort(), 
        personalRequestApplyDTO.getTel(),
        personalRequestApplyDTO.getEmail(),
        personalRequestApplyDTO.getVolStartDate(),
        personalRequestApplyDTO.getVolEndDate(),
        personalRequestApplyDTO.getVolStartTime(),
        personalRequestApplyDTO.getVolEndTime(),
        personalRequestApplyDTO.getVolList(),
        personalRequestApplyDTO.getJoinNum(),
        personalRequestApplyDTO.getContent(),
        personalRequestApplyDTO.getFileUpload()
        //          personalRequestApplyDTO.isChecked(),
        //        personalRequestApplyDTO.getIsSigned() // 이미 승인되있으니까..
        //          this.personalRequestRejectDTO[i].getIsSigned()
        );

    String input = Prompt.inputString("해당 봉사활동을 참가하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("[  해당 봉사신청 참여를 취소하였습니다. ]");
      return;
    }

    // 주최자 유효성검사
    if (personalRequestApplyDTO.getOwner().getName().equals(AuthLoginHandler.getLoginUser().getName())) {
      System.out.println("당신은 이미 주최자입니다!");
      return;
    }



    personalRequestApplyDTO.setMembers(addJoinMember()); // 참여 멤버 등록
    joinCount = personalRequestApplyDTO.getJoinCount(); //참여인원증가
    joinCount += 1;
    //    personalRequestDTO.setMembers( addJoinMember());
    //    personalRequestApplyDTO.getJoinCount(); // 카운트 1 증가

    personalSelectedList.add(personalRequestApplyDTO);

    System.out.println("[  봉사참여가 완료되었습니다. ]");

  }
  public List<JoinDTO> addJoinMember() {
    //    ArrayList<JoinDTO> members = new ArrayList<>();
    //    String memberName = AuthLoginHandler.getLoginUser().getName();
    //    JoinDTO member = AuthLoginHandler.findByName(memberName);
    JoinDTO member = AuthLoginHandler.getLoginUser();


    if (member != null) {
      members.add(member);
    } else if (member == null) {
      System.out.println("등록된 회원이 아닙니다.");
    }

    //    personalRequestDTO.setMembers(members);
    return members;
  }

  //  public List<JoinDTO> addOwner() {
  //    //    ArrayList<JoinDTO> members = new ArrayList<>();
  //    //    String memberName = AuthLoginHandler.getLoginUser().getName();
  //    //    JoinDTO member = AuthLoginHandler.findByName(memberName);
  //
  //
  //
  //
  //    //    personalRequestDTO.setMembers(members);
  //    return members;
  //  }
  //
  //
  //  public  JoinDTO exist(String name) {
  //    for (JoinDTO joinDTO : joinDTOList) {
  //      if (joinDTO.getName() == name) {
  //        return joinDTO;
  //      }
  //    }
  //    return null;
  //  }
  //



}




