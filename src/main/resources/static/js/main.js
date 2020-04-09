$(document).on('show.bs.modal', '#detailCharacterModal', function(e) {

	var btn = $(e.relatedTarget);
	var my_id_value = btn.data('id');
	var my_img_value = btn.data('img');

	$.get("/phrase/find/" + my_id_value, function(data) {
		var randomPhrase = data[Math.floor(Math.random() * data.length)];
		$(".modal-header #myModalTitle").val(randomPhrase.phrase);
		$(".modal-body #imgSrc").attr("src", my_img_value);
		$(".modal-body #imgSrc").attr("data-content", randomPhrase.phrase)
	});

});
$(document).on('show.bs.modal', '#detailCharacterModal', function(e) {

	var btn = $(e.relatedTarget);
	var my_id_value = btn.data('id');
	var my_img_value = btn.data('img');

	$.get("/phrase/find/" + my_id_value, function(data) {
		var randomPhrase = data[Math.floor(Math.random() * data.length)];
		$(".modal-header #myModalTitle").val(randomPhrase.phrase);
		$(".modal-body #imgSrc").attr("src", my_img_value);
		$(".modal-body #imgSrc").attr("data-content", randomPhrase.phrase)
	});

});
$(function() {
	$('[data-toggle="popover"]').popover()
})

function addPhrase(id) {
	var phrase = $("#phraseToAddInput").val();

	$.post("/phrase/save", {
		characterId : id,
		phrase : phrase
	}, function(data) {
		$("#savePhraseOK").css('visibility', 'visible');
		$("#savePhraseBtn").prop("disabled", true);
	}).fail(function() {
		$("#savePhraseKO").css('visibility', 'visible');
		$("#savePhraseBtn").prop("disabled", true);
	});

}
function resetModal(){
	$("#savePhraseKO").css('visibility', 'hidden');
	$("#savePhraseOK").css('visibility', 'hidden');
	$("#savePhraseBtn").prop("disabled", false);
	$("#phraseToAddInput").val('');
	
}

