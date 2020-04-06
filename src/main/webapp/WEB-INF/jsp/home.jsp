<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<c:url value="/css/main.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
 <script>
  $( function() {
	  var availableCharacters=[];
	 
	  $.ajax({
		   type:'GET',
		   url :"/character/list", 
		   headers: {'Access-Control-Allow-Origin': '*',
		   'Access-Control-Allow-Methods': '*',
		   'Access-Control-Allow-Headers': 'api-key,content-type',
		   'Access-Control-Allow-Credentials': true},
		   success: function(data) {
			   availableCharacters = data;
		       
		       
		   },
		   error:function(exception){alert('Exeption:'+exception);}
		}); 

    $( "#searchInput" ).autocomplete({
      source: function (request, response) {
          //data :: JSON list defined
         
          response($.map(availableCharacters, function (value, key) {
               return {
                   label: value.firstName + " " + value.lastName,
                   value: value.firstName + " " + value.lastName,
                   id: value._id
               }
           }));

   },
    });
  } );
  </script>
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
					<li class="nav-item active"><a class="nav-link" href="#">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Show all character</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> Dropdown </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#">Action</a> <a
								class="dropdown-item" href="#">Another action</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Something else here</a>
						</div></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
					</li>
				</ul>
				<form class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="search" id="searchInput"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>
		</nav>
		<div id="result">
		
 
		<c:forEach var="simpsonCharacter" items="${characters}">
 
			  <img src="${simpsonCharacter.picture}" class="img-fluid" alt="Responsive image">
			 
		</c:forEach>
		
		
		</div>
	</div>

	

</body>

</html>