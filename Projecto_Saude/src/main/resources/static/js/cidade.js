$('document').ready(function(){
	
	$('table #editButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(cidade, status){
			
			$('#editid').val(cidade.id);
			$('#editnomeCidade').val(cidade.nomeCidade);
			$('#editcapital').val(cidade.capital);
			
			
		});
		$('#editModal').modal();
	});
	//DETAIL MODAL
	$('table #detailButton').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		
		$.get(href, function(cidade, status){
			
			$('#detailid').val(cidade.id);
			$('#detailnomeCidade').val(cidade.nomeCidade);
			$('#detailcapital').val(cidade.capital);
			
			
		});
		
		$('#detailtModal').modal();
	});
	
	//DETELE MODAL
	$('table #deleteButton').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$('#confirmButtonDelete').attr('href', href);
		$('#deleteModal').modal();
	});
});