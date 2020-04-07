


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
function deleteCharacter(id) {
	$.get('/character/delete/' + id,function(data) {
		location.reload();
	});
	
	
}
