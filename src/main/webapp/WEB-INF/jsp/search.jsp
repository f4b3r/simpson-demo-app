<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:url value="/character/search" var="searchCharacterUrl" />

	<form:form class="form-horizontal" method="post" 
                modelAttribute="searchFilter" action="${searchCharacterUrl}">
	<div class="form-group row">

		<div class="col-sm-3">
			<form:input path="firstName" type="text" class="form-control" id="firstName"
				placeholder="First Name"/>
		</div>
		<div class="col-sm-3">
			<form:input path="lastName" type="text" class="form-control" id="lastName"
				placeholder="Last Name"/>
		</div>
		
		<div class="col-sm-2">
			<label for="ageFrom" class="col-sm col-form-label">Age From</label>

		</div>
		<div class="col-sm-1">

			<form:input path="ageFrom"  type="number" class="col-sm form-control" id="ageFrom"/>
		</div>
		<div class="col-sm-2">
			<label for="ageTo" class="col-sm col-form-label">Age To</label>
		</div>
		<div class="col-sm-1">
			<form:input path="ageTo" type="number" class="col-sm form-control" id="ageTo"/>
		</div>

	</div>



	<div class="form-group row">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-primary">Search</button>
		</div>
	</div>
</form:form>

