/**
 * Script para renderizar o modal de confirmação ou não de exclusão
 */
	
/*<script type="text/javascript">*/
$(document).ready(function(){
	
	$(".eBtn").click(function(event){
	
	event.preventDefault();
	var href = $(this).attr('href');
    
	$("#modalQuestion #delRef").attr('href',href);
	$("#modalQuestion").modal('show');
	  })
    });
/*</script>*/


/**
 * Script para renderizar o modal de edição
 */	

/*<script type="text/javascript">*/
$(document).ready(function(){
	
	$(".eBtn1").click(function(event){
	
	event.preventDefault();
	var href = $(this).attr('href');
    
    $.get(href,function(cliente,status){
      $('.myForm2 #id').val(cliente.identificador);
      $('.myForm2 #nome').val(cliente.nome);
      $('.myForm2 #telefone').val(cliente.telefone);
      $('.myForm2 #email').val(cliente.email);
      $('.myForm2 #cep').val(cliente.endereco.cep);
      $('.myForm2 #bairro').val(cliente.endereco.bairro);
      $('.myForm2 #logradouro').val(cliente.endereco.logradouro); 
      $('.myForm2 #complemento').val(cliente.endereco.complemento)   
    });
    
	$("#modalEdit").modal('show');
	  })
    });
/*</script>*/
