<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
  <meta charset="UTF-8">
  <title>소통해요 : 나눔이야기 목록</title>
  
  <div class="page-banner bg-img bg-img-parallax overlay-dark" style="background-image: url(../assets/img/bg_image_3.jpg);">
    <div class="container h-100">
      <div class="row justify-content-center align-items-center h-100">
        <div class="col-lg-8">
            <ol class="breadcrumb breadcrumb-dark bg-transparent justify-content-center py-0">
              <li class="breadcrumb-item"><a href="index.html">소통해요</a></li>
              <li class="breadcrumb-item active" aria-current="page" style="font-size:24px;">나눔이야기 게시판</li>
            </ol>
        </div>
      </div>
    </div>
  </div> <!-- .page-banner -->
  </head>

<body>
<div class="main">
    <div class="serch">
      <label for="f-search">검색</label>
      <input type="text" class="" id="f-search" name="keword">
      <button type="submit" class="searchBtn">검색</button>
    </div>
    <!-- //serch -->

    <div class="table01">
      <table class="table">
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>등록일</th>
            <th>조회수</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${volunteerBoardList}" var="volunteerBoardDTO">
          <tr>
            <td>${volunteerBoardDTO.no}</td>
            <td><a href='boardDetail?no=${volunteerBoardDTO.no}'>${volunteerBoardDTO.title}</a></td> 
            <td>${volunteerBoardDTO.owner.id}</td> 
            <td>${volunteerBoardDTO.registeredDate}</td>
            <td>${volunteerBoardDTO.viewCount}</td> 
          </tr>
        </c:forEach>
        </tbody>
      </table>
      <div class="ad-btn">
         <a href='boardForm' class="btnSubmit">게시글 작성</a>
      </div>
    </div><!-- table01 -->
</div><!-- main -->
</div>
</body>
</html>








