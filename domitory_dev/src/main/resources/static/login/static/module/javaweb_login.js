/**
 * 系统登录
 */
layui.use(['layer', 'form', 'index'], function () {
    var $ = layui.jquery;
    var layer = layui.layer;
    var form = layui.form;
    var index = layui.index;
    $('.login-wrapper').removeClass('layui-hide');

    
    form.on('submit(loginSubmit)', function(data){
    	  console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
    	  console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
    	  console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
    	  var pname=data.field.username;
  	    var password=data.field.password;
  	  console.log(pname)
  	  $.ajax({
	       url:"admin/login",
	       //type:"post",
	       data:{a_no:pname,a_pass:password},
	       contentType:"application/json;charset=utf-8",
	       dataType:"json",
	       success:function(data)
	       {
	        console.log(data);
	        location.href='index1';
	        sessionStorage.setItem('user',JSON.stringify(data));
	       }
	       
	    })
    	});


});