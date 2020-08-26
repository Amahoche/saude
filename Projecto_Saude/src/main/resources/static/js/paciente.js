$('document').ready(function(){
	
	$('.table #editButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(paciente, status){
			
			$('#editid').val(paciente.id);
			$('#editnome').val(paciente.nome);
			$('#editapelido').val(paciente.apelido);
			$('#editemail').val(paciente.email);
			$('#editdataNasc').val(paciente.dataNasc);
			$('#editsexo').val(paciente.sexo);
			$('#editdocumento').val(paciente.documento);
			$('#editnumDoc').val(paciente.numDoc);
			$('#editconjuge').val(paciente.conjuge);
			$('#edittelf').val(paciente.telf);
			$('#edittelfConjuge').val(paciente.telfConjuge);
			
		});
		$('#editModal').modal();
	});
	//DETAIL MODAL
	$('table #detailButton').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		
		$.get(href, function(paciente, status){
			
			$('#detailid').val(paciente.id);
			$('#detailnome').val(paciente.nome);
			$('#detailapelido').val(paciente.apelido);
			$('#detailemail').val(paciente.email);
			$('#detaildocumento').val(paciente.documento);
			$('#detailnumDoc').val(paciente.numDoc);
			$('#detailsexo').val(paciente.sexo);
			$('#detaildataNasc').val(paciente.dataNasc);
			$('#detailconjuge').val(paciente.conjuge);
			$('#detailtelf').val(paciente.telf);
			$('#detailespecialidade').val(paciente.telfConjuge);
			
		});
		
		$('#detailtModal').modal();
	});
	//FOTO MODAL
	$('.table #fotoButton').on('click',function(event) {
		   event.preventDefault();
		   var href = $(this).attr('href');
		   $('#fotoModal #pacienteFoto').attr('src', href);
		   $('#fotoModal').modal();		
		});
	//DETELE MODAL
	$('.table #deleteButton').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$('#confirmButtonDelete').attr('href', href);
		$('#deleteModal').modal();
	});
});