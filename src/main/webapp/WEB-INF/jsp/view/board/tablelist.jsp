<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%--<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>--%>
<%@ include file = "../layout/top.jsp" %>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<div class=dtadrs id="print_info">
     <div class="tableView-design">
<c:forEach var="data" items="${datalist}">
         <table border="1px" id="pcdata_form">
             <colgroup>
                 <col width="15%">
                 <col width="35%">
                 <col width="15%">
                 <col width="*">
             </colgroup>

             <tbody>
             <tr >
                 <td  colspan="4" style="text-align:center;">${data.pcname}</td>
             </tr>
             <tr>
                 <td>CPU</td>
                 <td colspan="3" >${data.cpu}GHz</td>
             </tr>
             <tr>
                 <td>MEM</td>
                 <td colspan="3" >${data.mem}GB</td>
             </tr>
             <tr>
                 <td>SSD</td>
                 <td colspan="3" >${data.ssd}GB</td>
             </tr>
             <tr>
                 <td>HDD</td>
                 <td colspan="3">${data.hdd}GB</td>
             </tr>
             </tbody>
         </table>
</c:forEach>
     </div>
</div> <%-- 프린트범위 끝부분 --%>

<div class="search" id="search">
    <select name="searchType">
        <option value="" <c:out value="${scri.searchType == null ? 'selected' : ''}" /> >선택</option>
        <option value="p" <c:out value="${scri.searchType eq 'p' ? 'selected' : ''}" /> >PCNAME</option>
        <option value="c" <c:out value="${scri.searchType eq 'c' ? 'selected' : ''}" /> >CPU</option>
        <option value="m" <c:out value="${scri.searchType eq 'm' ? 'selected' : ''}" /> >MEM</option>
        <option value="s" <c:out value="${scri.searchType eq 's' ? 'selected' : ''}" /> >SSD</option>
        <option value="h" <c:out value="${scri.searchType eq 'h' ? 'selected' : ''}" /> >HDD</option>
    </select>
    <input type="text" name="keyword" id="keywordInput" value="${scri.keyword}">
    <button id="searchBtn" type="button" >검색</button>
</div>

<script>
    $(function(){
        $('#search_two').on('click', function(){
            self.location = "tablelist" + '${pageMaker.makeQuery(1)}' + "&searchType=" + $("select[name=searchType] option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
        })
    })
</script>
<div>
    <ul class="page_info" id="page_info">
        <c:if test="${pageMaker.prev}">
            <li><a href="tablelist${pageMaker.makeSearch(pageMaker.startPage - 1)}">이전</a></li>
        </c:if>
        <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
            <li><a href="tablelist${pageMaker.makeSearch(idx)}">${idx}</a></li>
        </c:forEach>
        <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
            <li><a href="tablelist${pageMaker.makeSearch(pageMaker.endPage + 1)}">다음</a></li>
        </c:if>

    </ul>
</div>
  <%@ include file = "../layout/bottom.jsp" %>

