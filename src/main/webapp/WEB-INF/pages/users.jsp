<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="../layout/taglibs.jsp" %>
		
	<table class="table table-striped table-bordered table-hover">
	 	<thead>
	 		<tr>
	 			<td>Users</td>
	 		</tr>
	 	</thead>
	 	<tbody>
	 		<c:forEach items="${users}" var="user">
	 		<tr>
	 			<td>
	 				<a href='<spring:url value="/users/${user.id}.htm"></spring:url>'>${user.name}</a>
	 				
	 			</td>
	 		</tr>
	 		</c:forEach>
	 	</tbody>
	</table>

	