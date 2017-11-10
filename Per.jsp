<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<style>

.headingcustom
{
	font:25px Times New Roman;
}
</style>
<body>
	
	<div class="col-lg-12">&nbsp;</div>
	
	<div class="text-center col-lg-12">
		<span class="headingcustom">${title}</span>
	</div>
	<div class="col-lg-12">&nbsp;</div>
	<div class="container col-lg-offset-2 col-lg-8 text-center">
		<form:form action="savePer.html" commandName="per">
								<div class="form-group">
									<form:label class="control-label " path="perId">PER ID:</form:label>
									<form:input type="text" class="form-control " id="perId" path="perId"/>
									<form:label class="control-label " path="perNum">PER Number:</form:label>
									<form:input type="text" class="form-control " id="perNum" path="perNum"/>
									<form:label class="control-label " path="desc">Description:</form:label>
									<form:textarea type="text" class="form-control " id="desc" path="desc"></form:textarea>
									<form:label class="control-label " path="managersToNotify">Managers To Notify:</form:label>
									<form:input type="email" class="form-control " id="managersToNotify" path="managersToNotify"/>
								</div>
					
					<form:button type="button" class="btn  btn-default" data-toggle="modal" data-target="#myModal">Allocate Resource</form:button>
				
					<div class="modal fade" id="myModal" role="dialog">
						<div class="modal-dialog">
						
						  <!-- Modal content-->
						  <div class="modal-content">
							<div class="modal-header">
							  <form:button type="button" class="close" data-dismiss="modal">&times;</form:button>
							  <h4 class="modal-title">EMAIL</h4>
							</div>
							<div class="modal-body">
							  <%-- <form action="#"> --%>
								<div class="form-group">
									<form:label class="control-label " path="mailTo">To:</form:label>
									<form:input type="email" class="form-control " id="mailTo" path="mailTo"/>
									<form:label class="control-label " path="mailCc">CC:</form:label>
									<form:input type="email" class="form-control " id="mailCc" path="mailCc"/>
									<form:label class="control-label " path="mailBcc">BCC:</form:label>
									<form:input type="email" class="form-control " id="mailBcc" path="mailBcc"/>
									<form:label class="control-label " path="mailSubject">Subject:</form:label>
									<form:input type="text" class="form-control " id="mailSubject" path="mailSubject"/>
									<form:label class="control-label " path="mailBody">Body:</form:label>
									<form:textarea class="form-control"  rows="10" id="mailBody" path="mailBody"></form:textarea>
								</div>
 							  <%-- </form> --%>
							</div>
							<div class="modal-footer">
								<form:button type="button" class="btn btn-default" data-dismiss="modal">Save</form:button>
								<form:button type="button" class="btn btn-default" data-dismiss="modal">Cancel</form:button>
							</div>
						  </div>
						  
						</div>
					</div>
					<div class="col-lg-12">&nbsp;</div>
					<form:button type="submit" class="btn btn-default">Submit</form:button>
			
		</form:form>
	</div>
</body>
</html>
