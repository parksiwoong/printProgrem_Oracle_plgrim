<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%--<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>--%>
<%@ include file = "../layout/top.jsp" %>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>


        <form name="regForm" id="regForm" method="post" >
            <table border="1px" id="pcdata_form">
                <colgroup>
                 <%--   <col width="27%">
                    <col width="33%">
                    <col width="40%">--%>
                </colgroup>
                <tr >
                    <%--rowspan="3"--%>
                    <td  colspan="4" style="text-align:center;"><input name="pcname" id="pcname" placeholder="제품번호" value=""></td>
                </tr>
                <tr>
                    <td>CPU</td>
                    <td colspan="3" ><input name="cpu" id="cpu" value="">GHz</td>
                </tr>
                <tr>
                    <td>MEM</td>
                    <td colspan="3" ><input  name="mem" id="mem" value="">GB</td>
                </tr>
                <tr>
                    <td>SSD</td>
                    <td colspan="3" ><input  name="ssd"  id="ssd" value="">GB</td>
                </tr>
                <tr>
                    <td>HDD</td>
                    <td colspan="3"><input  name="hdd" id="hdd" value="">GB</td>
                </tr>
            </table>
        </form>




<%@ include file = "../layout/bottom.jsp" %>
