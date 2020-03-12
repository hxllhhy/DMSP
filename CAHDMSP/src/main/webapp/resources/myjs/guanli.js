// 管理药品信息
function GLDclick() {
	if (!$('#output').tabs('exists', '管理药品信息')) {
		$('#output').tabs('add', {
			title: '管理药品信息',
			href: './tabs/guanli/guanlidrug.html',
			closable: true
		});
	}
	else $('#output').tabs('select', '管理药品信息');
}

// 管理药厂信息
function GLFclick() {
	if (!$('#output').tabs('exists', '管理药厂信息')) {
		$('#output').tabs('add', {
			title: '管理药厂信息',
			href: './tabs/guanli/guanlifactory.html',
			closable: true
		});
	}
	else $('#output').tabs('select', '管理药厂信息');
}


// 管理采购人信息
function GLBclick() {
	if (!$('#output').tabs('exists', '管理采购人信息')) {
		$('#output').tabs('add', {
			title: '管理采购人信息',
			href: './tabs/guanli/guanlibuyer.html',
			closable: true
		});
	}
	else $('#output').tabs('select', '管理采购人信息');
}