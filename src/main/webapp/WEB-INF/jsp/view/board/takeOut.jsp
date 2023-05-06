<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ include file = "../layout/top.jsp" %>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>


        <form name="regForm" id="regForm" method="post" >
            <table style="border-style:solid; border-color: #0925A4;" id="pcdata_form">
                <tr>
                    <td class="bonmoon">구분</td>
                    <td colspan="4">개인</td>
                </tr>
                <tr>
                    <tr>
                        <td class="bonmoon" rowspan="2">사용자</td>
                        <td>성명</td>
                        <td>박시웅</td>
                        <td>직급</td>
                        <td>사원</td>
                    </tr>
                    <tr>
                        <td>부서</td>
                        <td>개발팀</td>
                        <td>전화번호</td>
                        <td>010</td>
                    </tr>
                </tr>
                <tr>
                    <tr>
                        <td class="bonmoon" rowspan="2">반출내용</td>
                        <td rowspan="2">노트북/PC</td>
                        <td>모델</td>
                        <td colspan="2" >NCsoft</td>
                    </tr>
                    <tr>
                        <td>제조번호(S/N)</td>
                        <td colspan="2">1001</td>
                    </tr>
                </tr>
                <tr>
                    <td class="bonmoon">반출목적</td>
                    <td colspan="4"></td>
                </tr>
            </table>
        </form>


<style>
    .bonmoon {
       background-color:#C7F4F0;
       color: #1619E0;
        font-weight:bold;
    }
    table {
        width: 100%;
        border: 2px solid #0925A4;
        border-collapse: collapse;
    }
    th, td {
        border: 2px solid #0925A4;
    }
</style>

<%@ include file = "../layout/bottom.jsp" %>
