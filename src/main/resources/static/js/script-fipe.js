	$("#type").focusout(function() {
	$.ajax({

	url : 'http://localhost:8080/api/veiculo/'+ $(this).val() +'/ws',

	dataType : 'json',

	success : function(resposta)
	{
	$("#name").val(resposta.name);
	$("#ano").focus();
	}
	});
});

