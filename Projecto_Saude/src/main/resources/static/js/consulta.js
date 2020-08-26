$('document').ready(function(){
	
	$('table #editButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(consulta, status){
			
			$('#editid').val(consulta.id);
			$('#editsintomas').val(consulta.sintomas);
			$('#editdata').val(consulta.data);
			$('#edithoraEntrada').val(consulta.horaEntrada);
			$('#edithoraSaida').val(consulta.horaSaida);
			
			
		});
		$('#editModal').modal();
	});
	//DETAIL MODAL
	$('table #detailButton').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		
		$.get(href, function(consulta, status){
			
			$('#detailid').val(consulta.id);
			$('#detailsintomas').val(consulta.sintomas);
			$('#detaildata').val(consulta.data);
			$('#detailhoraEntrada').val(consulta.horaEntrada);
			$('#detailhoraSaida').val(consulta.horaSaida);
			
			
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