<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <script src="https://getbootstrap.com/docs/4.1/assets/js/vendor/popper.min.js"></script>
 <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
<c:url value="/css/main.css" var="mainCss" />
<c:url value="/js/main.js" var="mainJs" />
<link href="${mainCss}" rel="stylesheet" />
<script type="text/javascript" src="${mainJs}"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">



</head>
<body>


	<div class="container">

		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#">Simpson Demo App</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="/home">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item">
					<div id="showAllDiv">
						<a class="nav-link" id="showAll" href="/character/list">Show all character</a>
					</div>
					
					</li>
				
					<li class="nav-item"><a class="nav-link" data-toggle="collapse" href="#collapseSearch" role="button" aria-expanded="false" aria-controls="collapseSearch">Search..</a>
					</li>
				</ul>
				
			</div>
		</nav>
		<div class="collapse" id="collapseSearch">
			<jsp:include page="search.jsp" />
		</div>
		<c:if test = "${characters.size() > 0}">
		<div id="result" >
		
 			<jsp:include page="result.jsp" />
		
		</div>
		</c:if>
	</div>

	

</body>

</html>