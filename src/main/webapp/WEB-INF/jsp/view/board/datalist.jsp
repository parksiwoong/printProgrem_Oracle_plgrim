<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ include file = "../layout/top.jsp" %>

 <%--   /* 체크박스에 맞게 리스트 프린트부분 크기에 맞춰 페이징까지 */--%>

        <link rel="stylesheet" href="">
<div class=dtadrs id="print_info">
        <nav class="clearfix" >
            <ul class ="boxAll_click">
                <li>
                    <div class="allCheck">
                        <input type="checkbox" name="allCheck" id="allCheck"/>
                        <label for="allCheck">모두선택</label>
                    </div>
                    <div>
                        <button type="button" class="selectdelete_btn">선택 삭제</button>
                    </div>
                </li>
            </ul>
            <table class="board_view" >
                <caption>PC상세보기</caption>
                <colgroup>
                    <col width="4%">
                    <col width="20%">
                    <col width="30%">
                    <col width="*">
                    <col width="*">
                    <col width="*">
                </colgroup>
                <tbody>
                <tr style="font-weight: 900;">
                    <th>check</th>
                    <th>pcName</th>
                    <th>CPU</th>
                    <th>MEM</th>
                    <th>SSD</th>
                    <th>HDD</th>
                </tr>
                </tbody>
                     <c:forEach var="data" items="${datalist}">
                        <tr style=" font-weight: 100; ">
                            <th class="checkBox"><input type="checkbox" name="chBox" id="chBox" class="chBox" data_no="${data.bno}"></th>
                            <th>${data.pcname}</th>
                            <th>${data.cpu }GHz</th>
                            <th>${data.mem}</th>
                            <th>${data.ssd}GB</th>
                            <th>${data.hdd }GB</th>
                            <th><button type="button" class="delete_btn"  data_no="${data.bno}">삭제</button></th>
                        </tr>
                     </c:forEach>
                </tbody>
            </table>



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
        $('#searchBtn').click(function() {
            self.location = "pclist" + '${pageMaker.makeQuery(1)}' + "&searchType=" + $("select[name=searchType] option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
        });
    });
</script>

        <div>
            <ul class="page_info" id="page_info">
                <c:if test="${pageMaker.prev}">
                    <li><a href="pclist${pageMaker.makeSearch(pageMaker.startPage - 1)}">이전</a></li>
                </c:if>
                <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
                    <li><a href="pclist${pageMaker.makeSearch(idx)}">${idx}</a></li>
                </c:forEach>
                <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
                    <li><a href="pclist${pageMaker.makeSearch(pageMaker.endPage + 1)}">다음</a></li>
                </c:if>

            </ul>
        </div>
       <%-- <div>
           <form name="readForm" role="form" method="post">
                <input type="hidden" id="bno" name="bno" value="${read.bno}" />
                <input type="hidden" id="page" name="page" value="${scri.page}">
                <input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}">
                <input type="hidden" id="searchType" name="searchType" value="${scri.searchType}">
                <input type="hidden" id="keyword" name="keyword" value="${scri.keyword}">
            </form>
        </div>--%>
    </nav>
</div> <%--print_info end--%>

<%@ include file = "../layout/bottom.jsp" %>
