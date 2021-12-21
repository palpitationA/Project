$(function () {
    //根据id查看部门信息url
    var getExpenseInfoUrl = '/expense/queryExpenseById'
    //编辑部门url
    var editExpenseInfoUrl = '/expense/editExpense'
    //新增部门url
    var addExpenseUrl = '/expense/insertExpense'
    //查看某个报销单信息的url
    var checkExpenseInfoUrl='/expense/toExpenseInfo'


    var expenseId = getQueryString("expenseId")
    var is_edit = getQueryString("edit")
    console.log('11111'+is_edit);

    //如果能从URL获取到expense_id,那么说明用户要么在‘查看’，要么在进行‘编辑’
    if (expenseId) {
        //需要从后端调用
        $.post(getExpenseInfoUrl, {expenseId: expenseId}, function (data) {
            console.log(data)
            if (data.success) {
                var expense = data.data;
                $('#expense-cause').val(expense.cause);
                $('#expense-emId').val(expense.emId);
                $('#expense-createTime').val(expense.createTime);
                $('#expense-nextDealEm').val(expense.nextDealEm);
                $('#expense-totalAmount').val(expense.totalAmount);
                if (expense.status === 1) {
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
        // alert(1)
        $('#status-on').attr('checked', true);
        $('#status-off').removeAttr('checked');
    });



    $('#status-off').click(function () {
        // alert(0)
        $('#status-off').attr('checked', true);
        $('#status-on').removeAttr('checked');
    })


    $('#submit2').click(function () {
        // alert("hello~~~?")
        var expense = {}
        console.log($('input[name="status"][checked]').val())
        if (is_edit) {
            expense.expenseId = expenseId;
        }
        /*expense.name=$('#expense-name').val();*/
        expense.cause=$('#expense-cause').val();
        expense.emId=$('#expense-emId').val();
        expense.nextDealEm=$('#expense-nextDealEm').val();
        expense.totalAmount=$('#expense-totalAmount').val();
        expense.status = $('input[name="status"][checked]').val()
        var formData = new FormData();
        formData.append('expenseStr',JSON.stringify(expense))
        console.log('formData:'+formData);
        $.ajax({
            url:is_edit?editExpenseInfoUrl:addExpenseUrl,
            type:'POST',
            dataType:'json',
            //一般用作表单提交涉及到文件上传
            contentType:false,
            processData:false,
            cache:false,
            async:false,
            data:formData,
            success:function (data) {
                // alert(111)
                alert(data.success)
                if (data.success) {
                    lightyear.notify("操作成功~", 'success', 500, 'mdi mdi-emoticon-happy', 'top', 'center', "/expense/toList");
                } else {
                    lightyear.notify(data.errMsg, 'danger', 500, 'mdi mdi-emoticon-sad', 'top', 'center');
                }
            }
        })
    })
})
