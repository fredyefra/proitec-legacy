/**
 * Script para renderizar o modal de confirmação ou não de exclusão
 */
	
	/*<script>*/
	$(document).ready(function(){
	$(".eBtn").click(function(event){
	
	event.preventDefault();
	var href = $(this).attr('href');
    
	$("#modalQuestion #delRef").attr('href',href);
	$("#modalQuestion").modal('show');
	  })
    });
	/*</script>*/
