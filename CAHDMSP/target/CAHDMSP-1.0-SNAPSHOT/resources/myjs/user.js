// 添加/删除用户
function UMclick(){
	if(quanXian != 0 ){
	    $.messager.alert('提示','您没有权限使用此功能','error');
	    event.stopPropagation();
	 }
	if(!$('#output').tabs('exists','添加/删除用户')) {
		$('#output').tabs('add',{
			title:'添加/删除用户',
			href:'./tabs/user.html',
			closable: true
		});
	}
	else $('#output').tabs('select', '添加/删除用户');
}

// 用户注销
function logOff(){
	$.get('../../login/logOff');
	location.href="../login.html";
}