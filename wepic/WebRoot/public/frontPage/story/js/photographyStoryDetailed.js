$(function(){
	hoverOpacityOnly(".small-head");
	
	});
	
	
	

/*投诉*/
function submitComplaint(){
	var num = $("#inputWorkNum").val();
	var numtextarea= $("#textareacomplaint").val();
	
	if(num == "请输入作品编号"){
		alert("请输入作品编号");
		return;
		}
	if(numtextarea == "" || numtextarea== null){
		alert("请输入投诉原因");
		return;
		}
	else{
		cloosePopBox('divComplaint');
		openPopUpBox('divComplaint2');
		}

}



function submitComplaint2(){
	var Linkman = $("#inputComplaintLinkman").val();
	var Phone= $("#inputComplaintPhone").val();
	var Address= $("#inputComplaintAddress").val();
	
	if(Linkman == "" || Linkman== null){
		alert("请输入联系人");
		return;
		}
	if(Phone == "" || Phone== null){
		alert("请输入联系电话");
		return;
		}
	if(Address == "" || Address== null){
		alert("请输入联系地址");
		return;
		}
	else{
		alert("成功");
		}

}

/*投诉*/
