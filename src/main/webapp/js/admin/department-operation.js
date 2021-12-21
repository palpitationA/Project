$(function () {
    //根据id查看部门信息url
    var getDepartmentInfoUrl = '/department/queryDepartmentById'
    //编辑部门url
    var editDepartmentInfoUrl = '/department/editDepartment'
    //新增部门url
    var addDepartmentUrl = '/department/insertDepartment'

    var depId = getQueryString("depId")
    var is_edit = getQueryString("edit")
    // console.log(depId)

    //如果能从URL获取到dep_id,那么说明用户要么在‘查看’，要么在进行‘编辑’
    if (depId) {
        //需要从后端调用
        $.post(getDepartmentInfoUrl, {depId: depId}, function (data) {
            console.log(data)
            if (data.success) {
                var department = data.data;
                $('#dep-name').val(department.name);
                $('#dep-address').val(department.address);
                if (department.status === 1) {
                    $('#status-on').attr('checked', true);
                    $('#status-off').removeAttr('checked');
                } else {
                    $('#status-off').attr('checked', true);
                    $('#status-on').removeAttr('checked');
                }
            } else {
               //TODO:如果后台没有正确返回数据,则需要.....
            }
        })
    }


    $('#status-on').click(function () {
        $('#status-on').attr('checked', true);
        $('#status-off').removeAttr('checked');
    })


    $('#status-off').click(function () {
        $('#status-off').attr('checked', true);
        $('#status-on').removeAttr('checked');
    })


    $('#submit').click(function () {
        var department = {}
        console.log($('input[name="status"][checked]').val())
        if (is_edit) {
            department.depId = depId;
        }
        department.name = $('#dep-name').val()
        department.address = $('#dep-address').val()
        department.status = $('input[name="status"][checked]').val()
        var formData = new FormData();
        formData.append('departmentStr',JSON.stringify(department))
        $.ajax({
            url:is_edit?editDepartmentInfoUrl:addDepartmentUrl,
            type:'POST',
            dataType:'json',
            //一般用作表单提交涉及到文件上传
            contentType:false,
            processData:false,
            cache:false,
            async:false,
            data:formData,
            success:function (data) {
                console.log(data)
                if (data.success) {
                    lightyear.notify("操作成功~", 'success', 500, 'mdi mdi-emoticon-happy', 'top', 'center', "/department/toList");
                } else {
                    lightyear.notify(data.errMsg, 'danger', 500, 'mdi mdi-emoticon-sad', 'top', 'center');
                }
            }
        })
    })
})