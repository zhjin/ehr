/**
 * 
 */

PrimeFaces.locales['zh_CN'] = {     
		closeText: '关闭',     
		prevText: '上个月',     
		nextText: '下个月',     
		currentText: '今天',     
		monthNames: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],     
		monthNamesShort: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],     
		dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],     
		dayNamesShort: ['日','一','二','三','四','五','六'],     
		dayNamesMin: ['日','一','二','三','四','五','六'],     
		weekHeader: '周',     
		firstDay: 1,     
		isRTL: false,     
		showMonthAfterYear: true,     
		yearSuffix: '年',  
		timeOnlyTitle: '仅时间',     
		timeText: '时间',     
		hourText: '时',     
		minuteText: '分',     
		secondText: '秒',     
		ampm: false,     
		month: '月',     
		week: '周',     
		day: '日',     
		allDayText : '全天' 
};


function handleComplete(xhr, status, args) {  
	if(args.validationFailed) {  
		alert("Validation Failed");  
	} else {  
		if (args.rtype == 'alert') {
			alert(args.message);
		}  else if (args.rtype == 'openwindow') {
			openWindowWithName(args.url, args.name, args.width, args.height);
		} else if (args.rtype == 'js') {
			parentWindowButtonClick(args.refreshButton);
			window.close();
		}
	}  
}  

function windowButtonClick(buttonString) {
	var _button = window.document.getElementById(buttonString);
	if (_button != null) {
		_button.click();
	}
}

function parentWindowButtonClick(buttonString) {
	var _button1 = window.opener.document.getElementById(buttonString);
	if (_button1 != null) {
		clickObj(_button1);
	}
}

function  clickObj(obj){  
	  if(document.all && typeof(document.all)== "object") {
		  // IE
		  //obj.fireEvent("onclick");
		  obj.click();
	  } else {   
		  obj.click();
		  //var e = document.createEvent('MouseEvent');   
		  //e.initEvent('click',false,false);   
		  //obj.dispatchEvent(e);   
	  }   
} 

function openWindowWithName(url, windowName, width, height) {
	var x = parseInt((screen.width  - width) / 2.0);  
	var y = parseInt((screen.height - height) / 2.0) - 50; 
    var win = window.open(url, windowName, "top=" + y + ",left=" + x + ",menubar=no,scrollbars=no,width=" + width + ",height=" + height + ",resizable=no,location=no" );
    win.focus();
}

function moduleClick(event) {
    event = event || window.event; 
    var obj = event.target || event.srcElement;
	var o1 = document.getElementById("menuul");
	lis = o1.getElementsByTagName('li');
	
	for (var i = 0; i < lis.length; i++) {
		if (lis[i] == obj.parentNode.parentNode) {
			lis[i].id = "current";
		} else {
			lis[i].id = "";
		}
	}
}

function hideshowmenuframe(){
	parent.document.all.frameset1.cols = parent.document.all.frameset1.cols == "0,*" ? "180,*" : "0,*";
}

function hidemenuframe(){
	parent.document.all.frameset1.cols = "0,*";
}

function showmenuframe(){
	parent.document.all.frameset1.cols = "180,*";
}