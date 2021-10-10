package com.share.ftp.handler.admin;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.challenge.ChallengeQuestionDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.ftp.handler.personal.challenge.AbstractChallengeQuestionHandler;
import com.share.util.Prompt;

public class AdminChallengeReplyConnectlHandler extends AbstractChallengeQuestionHandler {

  public AdminChallengeReplyConnectlHandler(List<ChallengeQuestionDTO> challengeQuestionDTOList,
      List<ChallengeDTO> challengeDTOList, List<ChallengeQuestionDTO> challengeReplyList) {
    super(challengeQuestionDTOList, challengeDTOList, challengeReplyList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 답글 변경, 삭제 ]");
    System.out.println();

    int challengeNo = (int) request.getAttribute("challengeNo");

    ChallengeDTO challengeList = findByChallengeNo(challengeNo); 

    if (challengeList == null) {
      System.out.println("해당 챌린지가 없습니다.");
      return;
    }

    int questionNo = Prompt.inputInt("문의답글 번호를 입력해주세요 ▶ ");

    ChallengeQuestionDTO challengeQuestion = findByQuestionNo(questionNo, challengeList);

    if (challengeQuestion == null) {
      System.out.println("해당 번호의 답글문의가 없습니다.");
      return;
    }

    if (!challengeQuestion.getOwner().getId().equals("admin")) {
      System.out.println("관리자가 작성한 답글번호를 입력해주세요!");
      return;
    }

    if ((challengeQuestion.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) ||
        AuthLoginHandler.getLoginUser().getId().equals("admin")) {
      //      for (ChallengeQuestionDTO challengeQuestionDTO : challengeQuestionDTOList) {
      if (challengeQuestion.getNo() == challengeNo) {
        System.out.printf("아이디: %s\n", challengeQuestion.getOwner().getId());
        System.out.printf("내용: %s\n", challengeQuestion.getContent());
        System.out.printf("등록날짜: %s\n", challengeQuestion.getRegisteredDate());
      } 
      //      }
    }

    System.out.println();

    request.setAttribute("questionNo", questionNo); 


    while (true) {
      System.out.println();
      System.out.println("1번 ▶ 답글 변경");
      System.out.println("2번 ▶ 답글 삭제");
      System.out.println("0번 ▶ 이전");
      int input = Prompt.inputInt("번호 입력 ▶ ");
      switch (input) {
        case 1: request.getRequestDispatcher("/adminChallenge/replyUpdate").forward(request); return;
        case 2: request.getRequestDispatcher("/adminChallenge/replyDelete").forward(request); return;
        case 0: return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }
  }
}