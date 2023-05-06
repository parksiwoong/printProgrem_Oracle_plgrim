<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="static/css/grid.css">
   <%--<script type="text/javascript" src="js/deletedata.js"></script>--%>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script> <%-- 제이쿼리 실행하려면 실행할 제이쿼리 위에 이걸 적어줘야함--%>
        <%-- 그리고 type="" 을 빼줘야함 --%>
        <script src="static/js/pcdata.js"></script>
        <script src="static/js/deletedata.js"></script>
        <script  src="http://code.jquery.com/jquery-latest.min.js"></script>

    <%--     <script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>--%>
      <%--  <script
                src="https://code.jquery.com/jquery-3.6.0.js"
                integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
                crossorigin="anonymous">
        </script>--%>
        <title>자원현황조사서</title>
    </head>
<body>
        <link rel="stylesheet" href="">
        <div class="lyout_info">
            <p class="p">자원현황조사서</p>
            <div class="top_info" id="top_info">
             <%--   <c:if test="${ url="" eq value="(url= "blob.naver.com/simpolor")"}">--%>
                <%--<c:if test="${''ne url= "blob.naver.com/simpolor"}">--%>
                 <%--<c:if test="${'requestScope['javax.servlet.forward.request_uri']'ne url= "blob.naver.com/simpolor"}--%>


                    <select id="selectList" onchange="location.href=this.value" style="display: flex ">
                        <option value="/">리스트뷰선택</option>
                        <option value="/pclist">pclist</option>
                        <option value="/tablelist" >tablelist</option>
                    </select>
         <%--        <script>  //셀렉트박스 클릭
                     $(function(){
                         $('#selectList > option').on('click', function (){
                             self.location = "/" + $("select[id=selectList] option:selected").val();
                         })
                     });
                 </script>--%>

        <%--        </c:if>--%>


                <button id="print" onclick="location.href='/'">write</button>
                <button id="print" onclick="print()">Print</button>
                <%-- <button onclick="location.href='/pclist'">DataList</button>--%>
              <%--   <button id="btnSubmit">Submit</button>  //submit 방법 --%>
                 <button id="btn_save">SAVE</button>  <%--DATA 저장 --%>
            </div> <%--top_info end --%>