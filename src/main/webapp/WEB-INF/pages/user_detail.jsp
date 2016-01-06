<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ include file="../layout/taglibs.jsp" %>
	${user.name}

	<c:forEach items="${user.blogs}" var="blog">
		<p>${blog.id}</p>
		<p>${blog.name}</p>
		<p>${blog.url}</p>
		
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Title</th>
					<th>Link</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${blog.items}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.title}</td>
					<td>${item.link}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:forEach>