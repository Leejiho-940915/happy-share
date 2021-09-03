package com.share.ftp.handler.join;

import java.util.List;
import com.share.ftp.domain.guest.JoinDTO;
import com.share.util.Prompt;

public class JoinSearchIdHandler extends AbstractJoinHandler {

  public JoinSearchIdHandler(List<JoinDTO> joinDTOList) {
    super(joinDTOList);

  }

  // 아이디찾기 이름, 이메일을 통해 찾는다.
  @Override
  public void execute() {

    while (true) {
      System.out.println("Q. 이름을 적어주세요.");
      System.out.println();
      String name = Prompt.inputString("이름? ");

      JoinDTO joinDTO = findByName(name);

      if (joinDTO.getName() == null) {
        System.out.println("해당 이름은 존재하지 않습니다.");
        return;
      }
    }



    while (true) {
      System.out.println("Q. 이메일을 적어주세요.");
      String email = Prompt.inputString("이메일? ");


      JoinDTO joinDTO = findByEmail(email);

      if (joinDTO == null) {
        System.out.println("해당 아이디를 찾을 수 없습니다.");
        return;
      }
    }
    System.out.printf("아이디: %s\n", joinDTO.getId());
  }
}

// 1. 회원가입을 안했는데 아이디찾기하는 경우 - 등록된 아이디가 없습니다.

// 2. 회원가입을 했는데 이름이 틀린경우 - 일치하는 이름이 없습니다. 
// 3. 회원가입을 했는데 이메일이 틀린경우  - 일치하는 이메일이 없습니다.


// 회원가입을 안했는데 아이디 찾기하는 경우 - 등록된 아이디가 없습니다.
// 회원가입을 했는데 이름이 틀린경우 - 일치하는 이름이 없습니다.
// 회원가입을 했는데 이메일이 틀린경우 - 일치하는 이메일이 없습니다.


