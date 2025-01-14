package com.share.ftp.web;

import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.dao.DonationRegisterDao;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.domain.donation.DonationBoardDTO;
import com.share.ftp.domain.donation.DonationRegisterDTO;
import com.share.ftp.domain.donation.DonationRegisterPayType;
import com.share.ftp.domain.join.JoinDTO;

@Controller
@RequestMapping("/register")
public class DonationRegisterController {

  private static final Logger logger = LogManager.getLogger(DonationRegisterController.class);


  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired DonationBoardDao donationBoardDao;
  @Autowired DonationRegisterDao donationRegisterDao;
  @Autowired GeneralDao generalDao;

  @GetMapping("form")
  public ModelAndView form(int boardNo) throws Exception {

    List<DonationRegisterPayType> payTypes = generalDao.findAllPayType();
    DonationRegisterPayType cardType = new DonationRegisterPayType();

    for (DonationRegisterPayType cardTypes : payTypes) {
      if (cardTypes.getNo() == 2) {
        cardType.setNo(cardTypes.getNo());
        cardType.setTitle(cardTypes.getTitle());
      }
    }

    ModelAndView mv = new ModelAndView();
    mv.addObject("cardType", cardType);
    mv.addObject("boardNo", boardNo);
    mv.addObject("pageTitle", "HappyShare : 후원하기");
    mv.addObject("contentUrl", "register/DonationRegisterForm.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @RequestMapping("add")
  public ModelAndView add(
      DonationBoardDTO donationBoard,
      DonationRegisterDTO donationRegisterDTO,
      HttpSession session,
      int money,
      String registeration,
      int boardNo) throws Exception {

    DonationRegisterPayType payTypeNo = new DonationRegisterPayType();
    payTypeNo.setNo(1);
    donationBoard.setNo(boardNo);
    donationRegisterDTO.setDonationMoney(money);
    donationRegisterDTO.setRegisterationNumber(registeration);
    donationRegisterDTO.setPayTypeNo(payTypeNo);
    donationRegisterDTO.setDonationBoard(donationBoard);
    donationRegisterDTO.setDonator((JoinDTO) session.getAttribute("loginUser"));

    donationRegisterDao.insert(donationRegisterDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect: ../donation/list");
    return mv;
  }

  @GetMapping("list")
  public ModelAndView list(int no) throws Exception {
    DonationBoardDTO donationBoardDTO = donationBoardDao.findByDonationNo(no);
    long remainMoney = donationRegisterDao.findByRemainMoney(no);
    long money = donationRegisterDao.findByRegisterMoney(no);
    Collection<DonationRegisterDTO> donationRegisterList = donationRegisterDao.findAllNo(no);
    int registerUser = donationRegisterDao.findByJoinUser(no);

    ModelAndView mv = new ModelAndView();
    mv.addObject("donationBoardDTO", donationBoardDTO);
    mv.addObject("remainMoney", remainMoney);
    mv.addObject("money", money);
    mv.addObject("donationRegisterList", donationRegisterList);
    mv.addObject("registerUser", registerUser);
    mv.addObject("pageTitle", "HappyShare : 기부자목록");
    mv.addObject("contentUrl", "register/DonationRegisterList.jsp");
    mv.setViewName("template1");
    return mv;
  }

  //  @GetMapping("detail")
  //  public ModelAndView detail(int no) throws Exception {
  //    DonationBoardDTO donationBoardDTO = donationBoardDao.findByDonationNo(no);
  //    long remainMoney = donationRegisterDao.findByRemainMoney(no);
  //    if (donationBoardDTO == null) {
  //      throw new Exception("해당 번호의 모금함이 없습니다.");
  //    }
  //
  //    ModelAndView mv = new ModelAndView();
  //    mv.addObject("donationBoardDTO", donationBoardDTO);
  //    mv.addObject("remainMoney", remainMoney);
  //    mv.addObject("pageTitle", "HappyShare : 모금함 상세");
  //    mv.addObject("contentUrl", "donation/DonationBoardDetail.jsp");
  //    mv.setViewName("template1");
  //    return mv;
  //  }
  //
  //  @PostMapping("update")
  //  public ModelAndView update(Board board) throws Exception {
  //
  //    Board oldBoard = boardDao.findByNo(board.getNo());
  //    if (oldBoard == null) {
  //      throw new Exception("해당 번호의 게시글이 없습니다.");
  //    } 
  //
  //    boardDao.update(board);
  //    sqlSessionFactory.openSession().commit();
  //
  //    ModelAndView mv = new ModelAndView();
  //    mv.setViewName("redirect:list");
  //    return mv;
  //  }
  //
  //  @GetMapping("delete")
  //  public ModelAndView delete(int no) throws Exception {
  //
  //    Board board = boardDao.findByNo(no);
  //    if (board == null) {
  //      throw new Exception("해당 번호의 게시글이 없습니다.");
  //    }
  //
  //    boardDao.delete(no);
  //    sqlSessionFactory.openSession().commit();
  //
  //    ModelAndView mv = new ModelAndView();
  //    mv.setViewName("redirect:list");
  //    return mv;
  //  }
}







