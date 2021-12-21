$(function () {

    //登录校验的路径
    var checkLoginUrl = '/checkLogin'
    //登陆次数
    var loginCount = 0

    $('#submit').click(function (){
        //用户名
        var userName = $('#username').val()
        //密码
        var password = $('#password').val()
        //1.当用户校验账号密码,错误次数超过3次,就必须要输入验证码(就是将验证码显示出来)
        //2.如果验证码显示出来了,第一,用户必须输入验证码;第二,后台必须要校验验证码的正确性
        //获取用户输入的验证码
        var captcha = $('#captcha').val()
        //验证码可以不输入
        var needVerify = false
        if (loginCount >= 3) {
            if (!captcha) {
                lightyear.notify("验证码不能为空!", 'danger', 500, 'mdi mdi-emoticon-sad', 'top', 'center');
                return;
            } else {
                needVerify = true
            }
        }

        $.ajax({
            url:checkLoginUrl,
            type:'POST',
            cache:false,
            async:false,
            //期望后端传过来的数据类型
            dataType:'json',
            contentType:'application/json;charset=utf-8',
            data:JSON.stringify({
                userName:userName,
                password:password,
                verifyCode:captcha,
                needVerify:needVerify
                }),
            success:function (data) {
                if (data.success) {
                    console.log("登录成功~");
                    lightyear.notify("登录成功~", 'success', 500, 'mdi mdi-emoticon-happy', 'top', 'center',"/main");
                } else {
                    lightyear.notify(data.errMsg, 'danger', 500, 'mdi mdi-emoticon-sad', 'top', 'center');
                    loginCount++
                    if (loginCount >= 3) {
                        $('#verifyCode').show()
                        $('#j_captcha').click()
                    }
                }
            }
        });
    })

})

function changeVerifyCode(img) {
    img.src = '/Kaptcha?'+Math.floor(Math.random()*100)
}