/**
 * 
 */
var request;
function window12(){
	if(window.ActiveXObject){
			request=new ActiveXObject("Microsoft.XMLHTTP");
		}
		else if(window.XMLHttpRequest){
			request=new XMLHttpRequest();
		}
}
function getDetails(){
	var ename=document.getElementById("en").value;
	var epass=document.getElementById("ep").value;
	var eemail=document.getElementById("ee").value;
	var ecountry=document.getElementById("ec").value;
	var url="SaveServlet?ename="+ename+"&epass="+epass+"&eemail="+eemail+"&ecountry="+ecountry;
	window12();
	request.onreadystatechange=getInfo;
	request.open("GET",url,true);
	request.send();		
}
function getInfo(){
	if(request.readyState==4 && request.status==200){
		
		var response=request.responseText;
		document.getElementById("result").innerHTML=response;
		
		showView();			
	}			
}
window.onload=function(){
	showView();
}

// to show the data
function showView(){
	var url="ViewServlet";
	window12();
	request.onreadystatechange=ShowViewresult;
	request.open("GET",url,true);
	request.send();
}
function ShowViewresult(){
	if(request.readyState==4){
		var response=request.responseText;
		document.getElementById("View").innerHTML=response;
	}
} 
/** To Delete data */
function deleteData(id){
		var url="DeleteServlet?id="+id;
		window12();
				request.onreadystatechange=ShowViewresult;
				request.open("GET",url,true);
				request.send();
}

/** To edit data */	
function editData(id){
		var url="EditServlet?id="+id;
		window12();
		request.onreadystatechange=ShowViewresult;
				request.open("GET",url,true);
				request.send();
}

function editData2(id){
	

	var name=document.getElementById("1name").value;
	var password = document.getElementById("1pass").value;
	var email = document.getElementById("1email").value;
	var country = document.getElementById("1country").value;
	var url="EditServlet2?id="+id+"&name="+name+"&password="+password+"&email="+email+"&country="+country;
	window12();
	request.onreadystatechange=ShowViewresult;
	request.open("GET",url,true);
	request.send();
}

