<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="row">
	<div class="col-sm-6 mx-auto">
		<h2 class="my-5 text-primary">
			<i class="fas fa-user-cog"></i> 회원 정보 수정
		</h2>
		<form:form modelAttribute="member" enctype="multipart/form-data">
			<form:hidden path="userId" class="form-control" />
			<div class="form-group">
				<label for="userId">사용자 ID </label>
				<p class="form-control-static">${member.userId}</p>
			</div>
			<div class="form-group">
				<label for="password">비밀번호</label>
				<form:password path="password" class="form-control" />
				<form:errors path="password" element="div" cssClass="error" />
			</div>
			<div class="form-group">
				<form:hidden path="name" class="form-control" />
				<label for="name">이름</label>
				<p class="form-control-static">${member.name}</p>
			</div>
			<div class="mb-3">
				<img src="${contextPath }/member/avata/${member.userId }">
				<Label for="avata">아바타 이미지</Label>
				<input type="file" name="avata"/>
			</div>
			<div class="form-group">
				<label for="email">email</label>
				<form:input path="email" class="form-control" />
				<form:errors path="email" element="div" cssClass="error" />
			</div>
			<div class="form-group">
				<label for="phone">전화번호</label>
				<form:input path="phone" class="form-control" />
			</div>
			<div class="form-group">
				<label for="address">주소</label>
				<form:input path="address" class="form-control" />
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-primary ok">
					<i class="fas fa-check"></i> 완료
				</button>
				<a href="view" class="btn btn-primary back"> <i
					class="fas fa-undo"></i> 돌아가기
				</a>
			</div>
		</form:form>
	</div>
</div>