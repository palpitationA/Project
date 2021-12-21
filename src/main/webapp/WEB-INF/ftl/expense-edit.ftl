<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>编辑报销单</title>
    <link rel="icon" href="/favicon.ico" type="image/ico">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/materialdesignicons.min.css" rel="stylesheet">
    <!--标签插件-->
<#--    <link rel="stylesheet" href="/js/jquery-tags-input/jquery.tagsinput.min.css">-->
    <link href="/css/style.min.css" rel="stylesheet">
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
                            <div class="card-body">
                                <div class="row">
<#--                                    <div class="form-group col-md-12">-->
<#--                                        <label for="expense-name">报销单名称</label>-->
<#--                                        <input type="text" class="form-control" id="expense-name"-->
<#--                                               name="expense-name" placeholder="请输入部门名称"/>-->
<#--                                    </div>-->
                                    <div class="form-group col-md-12">
                                        <label for="expense-cause">报销原因</label>
                                        <input type="text" class="form-control" id="expense-cause"
                                               name="expense-cause" placeholder="请输入报销原因"/>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <label for="expense-emId">创建人</label>
                                        <input type="text" class="form-control" id="expense-emId"
                                               name="expense-emId" placeholder="请输入创建人" disabled/>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <label for="expense-nextDealEm">待处理人</label>
                                        <input type="text" class="form-control" id="expense-nextDealEm"
                                               name="expense-nextDealEm" placeholder="请输入待处理人"/>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <label for="expense-totalAmount">报销总金额</label>
                                        <input type="text" class="form-control" id="expense-totalAmount"
                                               name="expense-totalAmount" placeholder="请输入报销总金额"/>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <label for="status">状态</label>
                                        <div class="clearfix">
                                            <label class="lyear-radio radio-inline radio-primary">
                                                <input id="status-off" type="radio" name="status"
                                                       value="0"><span>禁用</span>
                                            </label>
                                            <label class="lyear-radio radio-inline radio-primary">
                                                <input id="status-on" type="radio" name="status"
                                                       value="1"><span>启用</span>
                                            </label>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <button id="submit2" class="btn btn-primary ajax-post" target-form="add-form">确 定</button>
                                        <button type="button" class="btn btn-default" onclick="javascript:history.back(-1);return false;">返 回</button>
                                    </div>
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
<!--消息提示-->
<script src="/js/bootstrap-notify.min.js"></script>
<script type="text/javascript" src="/js/lightyear.js"></script>
<!--标签插件-->
<script src="/js/jquery-tags-input/jquery.tagsinput.min.js"></script>
<script type="text/javascript" src="/js/main.min.js"></script>
<script type="text/javascript" src="/js/admin/common.js"></script>
<script type="text/javascript" src="/js/admin/expense-operation.js"></script>
<script type="text/javascript" src="/js/admin/logout.js"></script>

</body>
</html>