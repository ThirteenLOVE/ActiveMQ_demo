<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>demo</title>
</head>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<body>
${demoStr}
<input type="text" id="info"></input>
<input type="button" onclick="sendInfo()" value="send"></input>
</body>
<script>
function sendInfo(){
		$.ajax({
			url:"sendInfo",
			type:"POST",
			data:{'sendInfo':$("#info").val()},
			dataType:'text',
			success:function(data){
				if(data=="success"){
					alert("s");
				}else{
					alert("f");
				}
			}
		});
}
</script>
</html>