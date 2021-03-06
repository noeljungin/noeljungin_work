var post = {
	init : function() {
		var _this = this;
		console.log(this);
		$('#btn-list').on('click', function() {
			_this.list();
		});
		$('#btn-modify').on('click', function() {
			_this.modify();
		});
		$('#btn-delete').on('click', function() {
			_this.delete();
		});
	},
	list : function() {
		window.location.href = '/';
	},
	modify : function() {
		if(confirm('r u want to modify content?'))
		{
			var data = {
					id: $('#id').val(),
					title: $('#title').val(),
					author: $('#author').val(),
					content: $('#content').val()
			};
			
			$.ajax({
				type: 'POST',
				url: 'posts/modify',
				dataType: 'json',
				contentType: 'application/json; charset=utf-8',
				data: JSON.stringify(data)
			}).done(function() {
				alert('modify success');
				location.reload();
			}).fail(function(err) {
				alert(JSON.stringify(err));
				console.log(err);
			});
		}
	},
	delete : function() {
		if(confirm('r u want delete?'))
		{
			var data = $('#delete-id').val();
			
			$.ajax({
				type: 'POST',
				url: '/posts/delete',
				dataType: 'json',
				contentType: 'application/json; charset=utf-8',
				data: data
			}).done(function(id){
				alert(id + 'content delete');
				location.href = '/';
			}).fail(function(err){
				alert(JSON.stringify(err));
				console.log(err);
			});
		}
	}
}

post.init();