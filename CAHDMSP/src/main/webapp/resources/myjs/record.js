// 查看入库记录
function INRCclick(){
	if(!$('#output').tabs('exists','查看入库记录')) {
		 $('#output').tabs('add',{
		 	 title:'查看入库记录',
			 href:'./tabs/jilu/jiluin.html',
			 closable:true
		});
	 }
	else $('#output').tabs('select', '查看入库记录');
}

// 查看出库记录
function OUTRCclick(){
	if(!$('#output').tabs('exists','查看出库记录')) {
		 $('#output').tabs('add',{
			 title:'查看出库记录',
			 href:'./tabs/jilu/jiluout.html',
             closable:true
		});
	 }
	else $('#output').tabs('select', '查看出库记录');
}