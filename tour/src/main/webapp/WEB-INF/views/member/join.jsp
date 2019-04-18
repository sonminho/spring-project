<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script src="${contextPath }/resources/js/member.js">
</script>
<script>
	$(function() {
		$('.id-check').checkUserId();
		$('#member').checkPassword();
	});
</script>
<div class="row">
	<div class="col-sm-6 mx-auto">
		<h2 class="my-5 text-primary">
			<i class="fas fa-user-plus"></i>회원 가입
		</h2>
		<form:form modelAttribute="member" enctype="multipart/form-data">
			<form:hidden path="userLevel" value="NORMAL" />
			<div class="form-group">
				<label for="userId"> 사용자ID
					<button type="button" class="btn btn-primary btn-sm id-check">
						<i class="fas fa-user-check"></i>중복체크
					</button> <span id="message"></span>
				</label>
				<form:input path="userId" class="form-control" />
				<form:errors path="userId" element="div" cssClass="error" />
			</div>
			
			<div class="form-group">
				<label for="password"> 비밀번호
				</label>
				<form:input path="password" class="form-control"/>
				<form:errors path="password" element="div" cssClass="error"/>
			</div>
			
			<div class="form-group">
				<label for="password2">비밀번호 확인</label>
				<input type="password" id="password2" class="form-control"/>
			</div>
			
			<div class="form-group">
				<label for="name">이름</label>
				<form:input path="name" class="form-control"/>
				<form:errors path="name" element="div" cssClass="error"/>
			</div>
			
			<div class="form-group">
				<label for="email">email</label>
				<form:input path="email" class="form-control"/>
				<form:errors path="email" element="div" cssClass="error"/>
			</div>
			
			<div class="form-group">
				<label for="phone">전화번호</label>
				<form:input path="phone" class="form-control"/>
			</div>
			
			<div class="form-group">
				<label for="address">주소</label>
				<form:input path="address" class="form-control"/>
			</div>
			
			<div class="text-center">
				<button type="submit" class="btn btn-primary" disabled>
					<i class="fas fa-check"></i>완료
				</button>
			</div>
		</form:form>
	</div>
</div>
