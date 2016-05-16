var ProdutoModel = Backbone.Model.extend({
	urlRoot: '/produto/adiciona',
	defaults: {
		id : null,           
		nome : '',       
		descricao : '',  
		preco : '',      
	}
});