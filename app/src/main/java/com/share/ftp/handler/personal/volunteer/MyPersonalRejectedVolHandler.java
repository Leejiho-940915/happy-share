package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.personal.PersonalRequestDTO;
import com.share.ftp.handler.join.AuthLoginHandler;

public class MyPersonalRejectedVolHandler extends AbstractVolRequestPersonalHandler { 


  public MyPersonalRejectedVolHandler(
      List<PersonalRequestDTO> personalRequestDTOList,
      List<PersonalRequestDTO> personalRequestApplyDTOList,
      List<PersonalRequestDTO> personalRequestRejectDTOList) {

    super(personalRequestDTOList, personalRequestApplyDTOList, personalRequestRejectDTOList);
  }



  @Override
  public void execute() {
    System.out.println();
    System.out.println("[  개인봉사반려 목록  ]");

    if (personalRequestRejectDTOList.isEmpty()) {
      System.out.println("[  현재 반려된 봉사목록이 없습니다. ]");
      return;
    }

    for (PersonalRequestDTO personalRequestRejectDTO : personalRequestRejectDTOList) {
      if (personalRequestRejectDTO.getOwner().getName().equals(AuthLoginHandler.getLoginUser().getName())) {
        System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %d, %s, %s, %s \n", 
            personalRequestRejectDTO.getNo(),      
            personalRequestRejectDTO.getTitle(),     
            personalRequestRejectDTO.getOwner().getName(), 
            //          personalRequestRejectDTO.getName(), 
            personalRequestRejectDTO.getSort(), 
            personalRequestRejectDTO.getTel(),
            personalRequestRejectDTO.getEmail(),
            personalRequestRejectDTO.getVolStartDate(),
            personalRequestRejectDTO.getVolEndDate(),
            personalRequestRejectDTO.getVolStartTime(),
            personalRequestRejectDTO.getVolEndTime(),
            personalRequestRejectDTO.getVolList(),
            personalRequestRejectDTO.getJoinNum(),
            personalRequestRejectDTO.getContent(),
            personalRequestRejectDTO.getFileUpload(),
            //          personalRequestRejectDTO.isChecked()
            personalRequestRejectDTO.getIsSigned()
            //          this.personalRequestRejectDTO[i].getIsSigned()
            );
      }
    }
  }


}
