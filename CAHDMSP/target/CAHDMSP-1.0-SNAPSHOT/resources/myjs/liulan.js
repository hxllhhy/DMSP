// 浏览药品信息
function LLDclick(){
	if(!$('#output').tabs('exists','浏览药品信息')) {
		 $('#output').tabs('add',{
			title:'浏览药品信息',
			href:'./tabs/liulan/liulandrug.html',
			closable:true
		});
	}
	else $('#output').tabs('select', '浏览药品信息');
}

// 浏览药厂信息
function LLFclick(){
	if(!$('#output').tabs('exists','浏览药厂信息')) {
		 $('#output').tabs('add',{
			title:'浏览药厂信息',
			 href:'./tabs/liulan/liulanfactory.html',
			closable:true
		});
	}
	else $('#output').tabs('select', '浏览药厂信息');
}

// 浏览采购人信息
function LLBclick(){
	if(!$('#output').tabs('exists','浏览采购人信息')) {
		 $('#output').tabs('add',{
			title:'浏览采购人信息',
			 href:'./tabs/liulan/liulanbuyer.html',
			closable:true
		});
	}
	else $('#output').tabs('select', '浏览采购人信息');
}