/**
 * 
 */

var main = {
		init : function(){
			var _this = this;
			$('#btn-save').on('click', function(){
				_this.save();
			});
		},
		
		save : function(){
			var data = {
					title : $('#title').val(),
					author: $('#author').val(),
					content: $('#content').val()
			};
			
			$.ajax({
				type : 'POST',
				url : '/posts',
				dataType: 'json',
				contentType: 'application/json; charset=utf-8',
				data : JSON.stringify(data)
			}).done(function(){
				alert("insert post");
				location.reload();
			}).fail(function(err){
				alert(JSON.stringify(err));
				console.log(err);
			})
		}
};

main.init();