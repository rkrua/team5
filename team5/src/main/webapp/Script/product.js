/**
 * 
 */

function checkProduct() {
	if(document.frm.name.value.length===0){
		alert("상품명을 입력하세요. ");
		frm.name.focus();
		return false;
	}
	if(document.frm.price.value.length===0){
		alert("가격을 입력하세요. ");
		frm.price.focus();
		return false;
	}
	if(!document.frm.pictureurl.value){
		alert("사진을 등록하세요. ");
		frm.pictureurl.focus();
		return false;
	}
	if(isNaN(document.frm.price.value)){
		alert("숫자로 입력하세요. ");
		frm.price.focus();
		return false;
	}
	return true;
}


