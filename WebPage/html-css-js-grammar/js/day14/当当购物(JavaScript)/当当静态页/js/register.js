// JavaScript Document
/*
常用的类样式
	register_input 文本框初始状态的样式
	register_input_Focus 文本框获得焦点时的样式
	register_input_Blur 文本框失去焦点时的样式
	register_prompt 提示信息的默认样式
	register_prompt_error 提示信息出错时的样式
	register_prompt_ok 提示信息正确时的样式
*/
/***********************************************email验证***********************************************/
/*鼠放在email文本框中时*/
function emailFocus()
{
	var obj = document.getElementById("email");
	var msg = document.getElementById("emailMsg");
	obj.className = "register_input register_input_Focus";
	msg.className = "register_prompt";
	msg.innerHTML = "此邮箱将是您登录当当网的账号，并将用来接收验证邮件";
}
/*鼠标离开email文本框时*/
function emailBlur()
{
	var obj = document.getElementById("email");
	var msg = document.getElementById("emailMsg");
	msg.innerHTML = "";
	if(obj.value=="")
	{
		obj.className="register_input register_input_Blur";
		msg.innerHTML = "电子邮件是必填项，请输入您的Email地址";
		msg.className = "register_prompt_error";
		return false;
	}else if(!isEmail(obj.value))
	{
		obj.className="register_input register_input_Blur";
		msg.innerHTML = "电子邮件格式不正确，请重新输入";
		msg.className = "register_prompt_error";
		return false;
	}else
	{
	  	obj.className="register_input";
	  	msg.className="register_prompt_ok";
		return true;
	}
}
function isEmail(str)
{
	if(str.indexOf("@")==-1)
	{
		return false;
	}else
	{
		return true;
	}
}


/**************************************昵称验证**************************************/
/*鼠放在nickName文本框中时*/
function nickFocus()
{
	var obj = document.getElementById("nickName");
	var msg = document.getElementById("nickMsg");
	obj.className = "register_input register_input_Focus";
	msg.className = "register_prompt";
	msg.innerHTML = "昵称可由大小写英文字母、数字组成，长度为4-20个字符";
}
/*鼠标离开nickName文本框时*/
function nickBlur()
{
	var obj = document.getElementById("nickName");
	var msg = document.getElementById("nickMsg");
	msg.innerHTML = "";
	if(obj.value=="")
	{
		obj.className="register_input register_input_Blur";
		msg.innerHTML = "昵称为必填项，请输入您的昵称";
		msg.className = "register_prompt_error";
		return false;
	}else if(obj.value.length<4 || obj.value.length>20)
	{
		obj.className="register_input register_input_Blur";
		msg.innerHTML = "昵称长度为4-20个字符";
		msg.className = "register_prompt_error";
		return false;
	}else
	{
	  	obj.className="register_input";
	  	msg.className="register_prompt_ok";
		return true;
	}
}
/******************************************密码验证***************************************/
/*鼠放在pwd文本框中时*/
function pwdFocus()
{
	var obj = document.getElementById("pwd");
	var msg = document.getElementById("pwdMsg");
	obj.className = "register_input register_input_Focus";
	msg.className = "register_prompt";
	msg.innerHTML = "密码可由大小写英文字母、数字组成，长度6－20个字符";
}
/*鼠标离开pwd文本框时*/
function pwdBlur()
{
	var obj = document.getElementById("pwd");
	var msg = document.getElementById("pwdMsg");
	msg.innerHTML = "";
	if(obj.value=="")
	{
		obj.className="register_input register_input_Blur";
		msg.innerHTML = "密码为必填项，请设置您的密码";
		msg.className = "register_prompt_error";
		return false;
	}else if(obj.value.length<6 || obj.value.length>20)
	{
		obj.className="register_input register_input_Blur";
		msg.innerHTML = "密码长度为6-20个字符";
		msg.className = "register_prompt_error";
		return false;
	}else
	{
	  	obj.className="register_input";
	  	msg.className="register_prompt_ok";
		return true;
	}
}
/*******************************************确认密码的验证*************************************/
/*鼠放在repwd文本框中时*/
function repwdFocus()
{
	var obj = document.getElementById("repwd");
	var msg = document.getElementById("repwdMsg");
	obj.className = "register_input register_input_Focus";
	msg.className = "register_prompt";
	msg.innerHTML = "密码可由大小写英文字母、数字组成，长度6－20个字符";
}
/*鼠标离开repwd文本框时*/
function repwdBlur()
{
	var obj2 = document.getElementById("pwd");
	var obj = document.getElementById("repwd");
	var msg = document.getElementById("repwdMsg");
	msg.innerHTML = "";
	if(obj.value=="")
	{
		obj.className="register_input register_input_Blur";
		msg.innerHTML = "密码为必填项，请设置您的密码";
		msg.className = "register_prompt_error";
		return false;
	}else if(obj2.value != obj.value)
	{
		obj.className="register_input register_input_Blur";
		msg.innerHTML = "两次输入的密码不一致";
		msg.className = "register_prompt_error";
		return false;
	}else
	{
	  	obj.className="register_input";
	  	msg.className="register_prompt_ok";
		return true;
	}
}

/*单击提交注册页面时，对页面内容进行验证*/
function checkForm()
{
	//当表单提交时，调用各项验证函数进行验证
	var flagEmail = emailBlur();
	var flagNickName = nickBlur();
	var flagPwd = pwdBlur();
	var flagRepwd = repwdBlur();
	if(flagEmail && flagNickName && flagPwd && flagRepwd)
	{
		//如果验证通过，则提示信息
		window.alert("表单验证通过");
		return true;
	}else
	{
		//如果验证失败，则提示信息
		window.alert("表单验证失败");
		return false;
	}
}