package com.share.ftp.handler.personal.challenge;

import java.util.List;

import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeReviewDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractChallengeReviewHandler implements Command {

  protected List<ChallengeReviewDTO> challengeReviewDTOList;
  protected List<ChallengeDTO> challengeDTOList;

  public AbstractChallengeReviewHandler(List<ChallengeReviewDTO> challengeReviewDTOList,
        List<ChallengeDTO> challengeDTOList) {
    this.challengeReviewDTOList = challengeReviewDTOList;
    this.challengeDTOList = challengeDTOList;
  }

  protected ChallengeReviewDTO findByReviewNo(int no) {
    ChallengeReviewDTO[] arr = challengeReviewDTOList.toArray(new ChallengeReviewDTO[0]);
    for (ChallengeReviewDTO challengeReviewDTO : arr) {
      if (challengeReviewDTO.getNo() == no) {
        return challengeReviewDTO;
      }
    }
    return null;
  }
  protected ChallengeDTO findByChallengeNo(int no) {
    for (ChallengeDTO challengeDTO : challengeDTOList) {
      if (challengeDTO.getNo() == no) {
        return challengeDTO;
      }
    }
    return null;
  }

}