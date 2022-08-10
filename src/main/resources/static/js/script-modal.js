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
    
    $.get(href,function(cliente){
      $("#id").val(cliente.identificador);
      $("#nome").val(cliente.nome);
      $("#telefone").val(cliente.telefone);
    });
    
	$("#modalEdit").modal('show');
	  })
    });
/*</script>*/