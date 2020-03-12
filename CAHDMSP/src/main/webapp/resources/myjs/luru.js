// 录入药品信息
function LRDclick(){
    if(quanXian != 0 ){
        $.messager.alert('提示','您没有权限使用此功能','error');
        event.stopPropagation();
    }
    if(!$('#output').tabs('exists','录入药品信息')) {
        $('#output').tabs('add', {
            title: '录入药品信息',
            href: './tabs/luru/lurudrug.html',
            closable: true
        });
    }
    else $('#output').tabs('select', '录入药品信息');
}

// 录入药厂信息
function LRFclick(){
    if(quanXian != 0 ){
        $.messager.alert('提示','您没有权限使用此功能','error');
        event.stopPropagation();
    }
    if(!$('#output').tabs('exists','录入药厂信息')) {
         $('#output').tabs('add',{
            title:'录入药厂信息',
             href:'./tabs/luru/lurufactory.html',
            closable:true
        });
     }
    else $('#output').tabs('select', '录入药厂信息');
}

// 录入采购人信息
function LRBclick(){
    if(quanXian != 0 ){
        $.messager.alert('提示','您没有权限使用此功能','error');
        event.stopPropagation();
    }
    if(!$('#output').tabs('exists','录入采购人信息')) {
        $('#output').tabs('add',{
            title:'录入采购人信息',
            href:'./tabs/luru/lurubuyer.html',
            closable:true
        });
    }
    else $('#output').tabs('select', '录入采购人信息');
 }