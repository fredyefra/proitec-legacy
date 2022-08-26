/**
 * Script que preenche as informações de acordo com o nome digitado
 */


    /*<script type="text/javascript">*/

	$("#nome").focusout(function() {
	 
	$.ajax({
	//URL consulta o metodo da classe ClienteWS - findByNome
	url : 'http://localhost:8080/api/nome/'+ $(this).val() +'/ws',
	
	dataType : 'json',
	
	success : function(resposta) 
	{
	$("#nome").val(resposta.nome);
	$("#telefone").val(resposta.telefone);
	$("#email").val(resposta.email);
	$("#endereco").val(resposta.endereco).focus();
	/*$("#nome").focus();*/
	}
	});
});
	
	/*</script>*/

