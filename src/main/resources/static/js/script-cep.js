/**
 * Script que preenche as informações de endereço de acordo com o CEP digitado
 */


    /*<script type="text/javascript">*/

	$("#cep").focusout(function() {
	$.ajax({
	//URL via cep mais parametro para consulta
	//url : 'https://viacep.com.br/ws/'+ $(this).val() + '/json/',
	url : 'http://localhost:8080/api/cep/'+ $(this).val() +'/ws',
	
	dataType : 'json',
	
	success : function(resposta) 
	{
	$("#logradouro").val(resposta.logradouro);
	$("#complemento").val(resposta.complemento);
	$("#bairro").val(resposta.bairro);
	$("#complemento").focus();
	}
	});
});
	
	/*</script>*/


	/** Refatorar script*/ 
	/** <script type="text/javascript">
	$("#cep").focusout(
	function() {
	
	$.ajax({
	//URL via cep mais parametro para consulta
	//url : 'https://viacep.com.br/ws/'+ $(this).val() + '/json/',
	url : 'http://localhost:8080/api/cep/'+ $(this).val() +'/ws',
	
	dataType : 'json',
	
	success : function(resposta) {
	
	$("#logradouro").val(resposta.logradouro);
	$("#complemento").val(resposta.complemento);
	$("#bairro").val(resposta.bairro);
	$("#complemento").focus();
	}
	});
 });
	</script> */
