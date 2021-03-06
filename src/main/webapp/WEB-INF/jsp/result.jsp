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
				<td style="text-align: end;">
					<button type="button" data-target="#detailCharacterModal"
						data-img="${simpsonCharacter.picture}"
						data-id="${simpsonCharacter._id}"
						class="btn btn-primary btn-sm showDetailBtn" data-toggle="modal">
						Detail</button>
					<button type="button"
						data-target="#addPhraseModal_${simpsonCharacter._id}" id="addPhraseBtn"
						data-id="${simpsonCharacter._id}" data-toggle="modal"
						class="btn btn-info btn-sm">Add Phrase</button>
					<button type="button"
						data-target="#deleteModal_${simpsonCharacter._id}"
						data-toggle="modal" class="btn btn-danger btn-sm">Delete</button>
				</td>

			</tr>
			<!-- Delete modal -->
			<div id="deleteModal_${simpsonCharacter._id}" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title">Confirm Delete</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>

						</div>

						<div class="modal-body">
							<p>Are you sure you want to delete this character?</p>
						</div>
						<div class="modal-footer">

							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<a href="/character/delete/${simpsonCharacter._id}">Delete</a>
						</div>
					</div>
				</div>
			</div>
			<!-- Add phrase modal -->
			<div id="addPhraseModal_${simpsonCharacter._id}" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title">Add a phrase</h4>
							<button type="button" class="close" data-dismiss="modal" onclick="resetModal()"
								aria-hidden="true">&times;</button>

						</div>

						<div class="modal-body">
							<input id="phraseToAddInput" type="text" class="form-control">
						</div>
						<div class="modal-footer">
						<div style='visibility:hidden;' id="savePhraseOK">
							<p class="text-success">Phrase has been added</p>
						</div>
						<div style='visibility:hidden;' id="savePhraseKO">
							<p class="text-danger">Error saving phrase.. try later</p>
						</div>
						
							<button type="button" class="btn btn-default" onclick="resetModal()"
								data-dismiss="modal">Close</button>
							<button type="button" class="btn btn-default"
								onclick="addPhrase('${simpsonCharacter._id}')" id="savePhraseBtn"
								>
								<i class="fa fa-trash-o"></i>Save
							</button>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>


	</tbody>
</table>
<!-- Detail modal -->
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
				<img id="imgSrc" src="" alt="" class="img-thumbnail"
					data-container="body" data-toggle="popover" data-placement="right"
					data-content="">
			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
			</div>
		</div>
	</div>
</div>

