<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>员工管理</title>
    <link rel="icon" href="/favicon.ico" type="image/ico">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/css/style.min.css" rel="stylesheet">
    <link href="/css/pagination.css" rel="stylesheet">
</head>

<body>
<div class="lyear-layout-web">
    <div class="lyear-layout-container">
        <!--左侧导航-->
        <#include "aside.ftl"/>
        <!--End 左侧导航-->

        <!--头部信息-->
        <#include "header.ftl"/>
        <!--End 头部信息-->

        <!--页面主要内容-->
        <main class="lyear-layout-content">

            <div class="container-fluid">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-toolbar clearfix">
                                <div class="pull-right search-bar">
                                    <div class="input-group">
                                        <div class="input-group-btn">
                                            <input type="hidden" name="search_field" id="search-field" value="name">
                                            <button class="btn btn-default dropdown-toggle" id="search-btn"
                                                    data-toggle="dropdown" type="button" aria-haspopup="true"
                                                    aria-expanded="false">
                                                姓名 <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu">
                                                <li><a tabindex="-1" href="javascript:void(0)" data-field="name">姓名</a>
                                                </li>
                                                <li><a tabindex="-1" href="javascript:void(0)"
                                                       data-field="loginName">登录名</a></li>
                                            </ul>

                                        </div>
                                        <input id="search-input" type="text" class="form-control" value=""
                                               name="keyword" placeholder="请输入关键字">
                                    </div>
                                </div>
                                <div class="pull-right m-10">
                                    <label class="lyear-switch switch-danger switch-light">
                                        <input id="status-condition" type="checkbox">状态筛选
                                        <span></span>
                                    </label>
                                </div>

                                <div class="pull-right m-10">
                                    <label>
                                        筛选部门
                                        <select id="department-select">
                                            <option value="0">请选择</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                        </select>
                                    </label>
                                </div>

                                <div class="pull-right m-10">
                                    <label>
                                        筛选职位
                                        <select id="position-select">
                                            <option value="0">请选择</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                        </select>
                                    </label>
                                </div>
                                <div class="toolbar-btn-action">
                                    <a class="btn btn-primary m-r-5" href="/employee/toAddEmployee"><i class="mdi mdi-plus"></i> 新增</a>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <#--                                            <th>-->
                                            <#--                                                <label class="lyear-checkbox checkbox-primary">-->
                                            <#--                                                    <input type="checkbox" id="check-all"><span></span>-->
                                            <#--                                                </label>-->
                                            <#--                                            </th>-->
                                            <th>编号</th>
                                            <th>姓名</th>
                                            <th>手机(用户名)</th>
                                            <th>部门</th>
                                            <th>职位</th>
                                            <th>状态</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody class="employee-wrap">
<#--                                        <tr>-->
<#--                                            <td>1</td>-->
<#--                                            <td>第01章 天涯思君不可忘</td>-->
<#--                                            <td>《倚天屠龙记》</td>-->
<#--                                            <td><font class="text-success">正常</font></td>-->
<#--                                            <td>-->
<#--                                                <div class="btn-group">-->
<#--                                                    <a class="btn btn-xs btn-default" href="#!" title="编辑"-->
<#--                                                       data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>-->
<#--                                                    <a class="btn btn-xs btn-default" href="#!" title="查看"-->
<#--                                                       data-toggle="tooltip"><i class="mdi mdi-eye"></i></a>-->
<#--                                                    <a class="btn btn-xs btn-default" href="#!" title="状态"-->
<#--                                                       data-toggle="tooltip"><i class="mdi mdi-toggle-switch"></i></a>-->
<#--                                                </div>-->
<#--                                            </td>-->
<#--                                        </tr>-->
                                        </tbody>
                                    </table>
                                </div>
                                <div class="jq_pagination m-style">
<#--                                    <li class="disabled"><span>«</span></li>-->
<#--                                    <li class="active"><span>1</span></li>-->
<#--                                    <li><a href="#1">2</a></li>-->
<#--                                    <li><a href="#1">3</a></li>-->
<#--                                    <li><a href="#1">4</a></li>-->
<#--                                    <li><a href="#1">5</a></li>-->
<#--                                    <li><a href="#1">6</a></li>-->
<#--                                    <li><a href="#1">7</a></li>-->
<#--                                    <li><a href="#1">8</a></li>-->
<#--                                    <li class="disabled"><span>...</span></li>-->
<#--                                    <li><a href="#!">14452</a></li>-->
<#--                                    <li><a href="#!">14453</a></li>-->
<#--                                    <li><a href="#!">»</a></li>-->
                                </div>

                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </main>
        <!--End 页面主要内容-->
    </div>
</div>

<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="/js/main.min.js"></script>
<!--消息提示-->
<script src="/js/bootstrap-notify.min.js"></script>
<script type="text/javascript" src="/js/lightyear.js"></script>
<script type="text/javascript" src="/js/jquery.pagination.js"></script>
<script type="text/javascript" src="/js/admin/employee-list.js"></script>
<script type="text/javascript" src="/js/admin/logout.js"></script>
</body>
</html>