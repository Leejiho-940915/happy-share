package com.share.ftp.handler.personal.challenge;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class ChallengeWishHandler implements Command {

  ChallengeDao challengeDao;
  SqlSession sqlSession;

  public ChallengeWishHandler(ChallengeDao challengeDao, SqlSession sqlSession) {
    this.challengeDao = challengeDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[  🎈 WISH 🎈  ]");
    System.out.println();

    int challengeNo = (int) request.getAttribute("challengeNo");

    ChallengeDTO challengeList = challengeDao.findByNo(challengeNo); 

    while (true) {
      String input = Prompt.inputString("[  🎈 관심 챌린지로 추가하시겠습니까?(y/N) 🎈 ] ");

      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println();
        System.out.println("[  ❌ WISH 취소 ❌  ]");
        return;

      } else if (input.equalsIgnoreCase("y")) {
        System.out.println();
        challengeList.setWish(AuthLoginHandler.getLoginUser());
        challengeDao.insertWish(challengeList.getNo(), AuthLoginHandler.getLoginUser().getNo());
        sqlSession.commit();
        System.out.println("[  🎈 관심 챌린지로 등록되었습니다. 🎈  ]");
        return;

      } else {
        System.out.println("y 또는 n을 입력하세요.");
        continue;
      } 
    } 
  }
}

