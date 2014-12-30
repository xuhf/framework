$(function() {
	$("form[data-role='validate']").validate();
	new jBox('Confirm', {
		confirmButton : '确认',
		cancelButton : '取消'
	});
	$(".chosen-select").chosen(); 
});
