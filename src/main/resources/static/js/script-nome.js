/**
 * Script que preenche as informações de acordo com o nome digitado
 */


    /*<script type="text/javascript">*/

	$("#nome").focusout(function() {
	$.ajax({
	//URL consulta o metodo da classe ClienteWS - findByNome
	//url : 'https://viacep.com.br/ws/'+ $(this).val() + '/json/',
	url : 'http://localhost:8080/api/nome/'+ $(this).val() +'/ws',
	
	dataType : 'json',
	
	success : function(resposta) 
	{
	$("#nome").val(resposta.nome);
	$("#telefone").val(resposta.telefone);
	/*$("#nome").focus();*/
	}
	});
});
	
	/*</script>*/

