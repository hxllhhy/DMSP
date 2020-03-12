
function closeAll() {
	var tab =$('#output').tabs('tabs');
	for (var i=tab.length-1;i>=0;i--) {
		$('#output').tabs('close', i);
	}
}
function helpclick(){
	$.messager.alert('帮助','如忘记密码可发邮件至979641269@qq.com说明情况，工作人员会及时联系你','info');
}
