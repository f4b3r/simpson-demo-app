<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table table-striped">
	<thead>
		<tr>
			<th scope="col">First Name</th>
			<th scope="col">Last Name</th>
			<th scope="col">Age</th>

		</tr>
	</thead>
	<tbody>

		<c:forEach var="simpsonCharacter" items="${characters}">
			<tr>
				<td>${simpsonCharacter.firstName}</td>
				<td>${simpsonCharacter.lastName}</td>
				<td>${simpsonCharacter.age}</td>
				<td>
					<button type="button" data-target="#detailCharacterModal"
						data-img="${simpsonCharacter.picture}"
						data-id="${simpsonCharacter._id}"
						class="btn btn-primary btn-sm showDetailBtn" data-toggle="modal">
						<i class="fas fa-pencil-alt"></i> Detail
					</button>
				</td>
			</tr>

		</c:forEach>


	</tbody>
</table>
<div class="modal fade" id="detailCharacterModal" tabindex="-1"
	role="dialog" aria-labelledby="charModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
			<h4 class="modal-title" id="myModalTitle">Click on the image</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				
			</div>

			<div class="modal-body">
				<img id="imgSrc" src="" alt="" class="img-thumbnail"  data-container="body" 
				data-toggle="popover" data-placement="right" data-content="">
			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
			</div>
		</div>
	</div>
</div>