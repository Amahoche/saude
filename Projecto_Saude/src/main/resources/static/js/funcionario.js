$('document').ready(function(){
	
	$('table #editButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(funcionario, status){
			
			$('#editid').val(funcionario.id);
			$('#editnome').val(funcionario.nome);
			$('#editapelido').val(funcionario.apelido);
			$('#editemail').val(funcionario.email);
			$('#editdataNasc').val(funcionario.dataNasc);
			$('#editsexo').val(funcionario.sexo);
			$('#editdocumento').val(funcionario.documento);
			$('#editnumDoc').val(funcionario.numDoc);
			$('#edittelf').val(funcionario.telf);
			$('#editsalario').val(funcionario.salario);
			$('#editespecialidade').val(funcionario.especialidade);
			
		});
		$('#editModal').modal();
	});
	//DETAIL MODAL
	$('table #detailButton').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		
		$.get(href, function(funcionario, status){
			
			$('#detailid').val(funcionario.id);
			$('#detailnome').val(funcionario.nome);
			$('#detailapelido').val(funcionario.apelido);
			$('#detailemail').val(funcionario.email);
			$('#detaildocumento').val(funcionario.documento);
			$('#detailnumDoc').val(funcionario.numDoc);
			$('#detailsexo').val(funcionario.sexo);
			$('#detaildataNasc').val(funcionario.dataNasc);
			$('#detailtelf').val(funcionario.telf);
			$('#detailsalario').val(funcionario.salario);
			$('#detailespecialidade').val(funcionario.especialidade);
			
		});
		
		$('#detailtModal').modal();
	});
	//FHOTO
	$('.table #fotoButton').on('click',function(event) {
		   event.preventDefault();
		   var href = $(this).attr('href');
		   $('#fotoModal #funcionarioFoto').attr('src', href);
		   $('#fotoModal').modal();		
		});
	//DETELE MODAL
	$('table #deleteButton').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$('#confirmButtonDelete').attr('href', href);
		$('#deleteModal').modal();
	});
});