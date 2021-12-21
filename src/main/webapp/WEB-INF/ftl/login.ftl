<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>登录页面 OA</title>
    <link rel="icon" href="/favicon.ico" type="image/ico">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/css/style.min.css" rel="stylesheet">
    <style>
        .lyear-wrapper {
            position: relative;
        }
        .lyear-login {
            display: flex !important;
            min-height: 100vh;
            align-items: center !important;
            justify-content: center !important;
        }
        .lyear-login:after{
            content: '';
            min-height: inherit;
            font-size: 0;
        }
        .login-center {
            background-color: rgba(255,255,255,.075);
            min-width: 29.25rem;
            padding: 2.14286em 3.57143em;
            border-radius: 3px;
            margin: 2.85714em;
        }
        .login-header {
            margin-bottom: 1.5rem !important;
        }
        .login-center .has-feedback.feedback-left .form-control {
            padding-left: 38px;
            padding-right: 12px;
            background-color: rgba(255,255,255,.075);
            border-color: rgba(255,255,255,.075)
        }
        .login-center .has-feedback.feedback-left .form-control-feedback {
            left: 0;
            right: auto;
            width: 38px;
            height: 38px;
            line-height: 38px;
            z-index: 4;
            color: #dcdcdc;
        }
        .login-center .has-feedback.feedback-left.row .form-control-feedback {
            left: 15px;
        }
        .login-center .form-control::-webkit-input-placeholder{
            color: rgba(255, 255, 255, .8);
        }
        .login-center .form-control:-moz-placeholder{
            color: rgba(255, 255, 255, .8);
        }
        .login-center .form-control::-moz-placeholder{
            color: rgba(255, 255, 255, .8);
        }
        .login-center .form-control:-ms-input-placeholder{
            color: rgba(255, 255, 255, .8);
        }
        .login-center .custom-control-label::before {
            background: rgba(0, 0, 0, 0.3);
            border-color: rgba(0, 0, 0, 0.1);
        }
        .login-center .lyear-checkbox span::before {
            border-color: rgba(255,255,255,.075)
        }
    </style>
</head>

<body>
<div class="row lyear-wrapper" style="background-image: url(/images/login-bg-2.jpg); background-size: cover;">
    <div class="lyear-login">
        <div class="login-center">
            <form action="#!" method="post">
                <div class="form-group has-feedback feedback-left">
                    <input type="text" placeholder="请输入您的用户名" class="form-control" name="username" id="username" />
                    <span class="mdi mdi-account form-control-feedback" aria-hidden="true"></span>
                </div>
                <div class="form-group has-feedback feedback-left">
                    <input type="password" placeholder="请输入密码" class="form-control" id="password" name="password" />
                    <span class="mdi mdi-lock form-control-feedback" aria-hidden="true"></span>
                </div>
<#--                <div class="form-group has-feedback feedback-left row">-->
<#--                    <div class="col-xs-7">-->
<#--                        <input type="text" name="captcha" class="form-control" placeholder="验证码">-->
<#--                        <span class="mdi mdi-check-all form-control-feedback" aria-hidden="true"></span>-->
<#--                    </div>-->
<#--                    <div class="col-xs-5">-->
<#--                        <img src="images/captcha.png" class="pull-right" id="captcha" style="cursor: pointer;" onclick="this.src=this.src+'?d='+Math.random();" title="点击刷新" alt="captcha">-->
<#--                    </div>-->
<#--                </div>-->
                <div id="verifyCode" class="form-group has-feedback feedback-left row" hidden="hidden">
                    <div class="col-xs-7">
                        <input id="captcha" type="text" name="captcha" class="form-control" placeholder="验证码">
                        <span class="mdi mdi-check-all form-control-feedback" aria-hidden="true"></span>
                    </div>
                    <div class="col-xs-5">
<#--                        /Kaptcha?d= 0.5               -->
                        <img src="/Kaptcha" class="pull-right" id="j_captcha" style="cursor: pointer;" onclick="changeVerifyCode(this)" title="点击刷新" alt="captcha">
                    </div>
                </div>
                <div class="form-group">
                    <button id="submit" class="btn btn-block btn-primary" type="button">立即登录</button>
                </div>
            </form>
            <footer class="col-sm-12 text-center text-white">
                <p class="m-b-0">Copyright © 2020 <a href="http://lyear.itshubao.com">IT书包</a>. All right reserved</p>
            </footer>
        </div>
    </div>
</div>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<!--消息提示-->
<script src="/js/bootstrap-notify.min.js"></script>
<script type="text/javascript" src="/js/lightyear.js"></script>
<#--<script type="text/javascript" src="/js/perfect-scrollbar.min.js"></script>-->
<#--<script type="text/javascript" src="/js/main.min.js"></script>-->
<script type="text/javascript" src="/js/admin/login.js"></script>
</body>
</html>