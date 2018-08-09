/**
 * 日志管理初始化
 */
var work = {
    id: "WorkTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
work.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '工作名称', field: 'workName', align: 'center', valign: 'middle'},
        {title: '姓名', field: 'name', align: 'center', valign: 'middle', sortable: true},
        {title: '年龄', field: 'age', align: 'center', valign: 'middle', sortable: true},
        //注意这里，如果换成了sexName 需要使用到包装类中方法
         {title: '性别', field: 'sexName', align: 'center', valign: 'middle', sortable: true},
        //{title: '性别', field: 'sex', align: 'center', valign: 'middle', sortable: true},
        {title: '出生日期', field: 'birthday', align: 'center', valign: 'middle', sortable: true},
        {title: '创建时间', field: 'created', align: 'center', valign: 'middle', sortable: true},
        {title: '更新时间', field: 'updated', align: 'center', valign: 'middle', sortable: true}];
};

/**
 * 检查是否选中
 */
work.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        work.seItem = selected[0];
        return true;
    }
};

/**
 * 查看日志详情
 */
work.detail = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/work/detail/" + this.seItem.id, function (data) {
            Feng.infoDetail("日志详情", data.regularMessage);
        }, function (data) {
            Feng.error("获取详情失败!");
        });
        ajax.start();
    }
};


/**
 * 清空日志
 */
work.delLog = function () {
    Feng.confirm("是否清空所有日志?",function(){
        var ajax = Feng.baseAjax("/log/delLog","清空日志");
        ajax.start();
        work.table.refresh();
    });
}

/**
 * 查询表单提交参数对象
 * @returns {{}}
 */
work.formParams = function() {
    var queryData = {};

    queryData['createtime'] = $("#birthday").val();

    return queryData;
}
work.initTime=function () {
    var date = new Date();
    var year=date.getFullYear();
    var month=(date.getMonth()+1)>10?(date.getMonth()+1):(0+''+(date.getMonth()+1));
    var day=(date.getDate())>10?(date.getDate()):(0+''+date.getDate());

    $("#birthday").val(year+'-'+month+'-'+day);
}



/**
 * 查询日志列表
 */
work.search = function () {

    work.table.refresh({query: OptLog.formParams()});
};


work.downloadExcel=function(){
    window.location.href=Feng.ctxPath + '/work/downloadExcelContent';
}


work.downloadModelExcel=function(){
    window.location.href=Feng.ctxPath + '/work/downloadExcelModel';
}



function uploadExcel(){
    var loading;
    layui.use('upload', function(){
        var upload = layui.upload;

        var uploadInst =upload.render({

            elem: '#layuiSelect'
            ,url: Feng.ctxPath + '/work/uploadExcel_easypoi'
            ,accept: 'file'
            ,size: 50
            ,exts: 'xls|xlsx'
            ,auto:false
            ,bindAction: '#uploadExcel'
            ,size: 10000
            ,number:0
            ,before:function(){
                loading=layui.layer.load();
            }
            ,done:function(res){
                if(res.code>0){
                    Feng.error("添加失败! !");
                }
                console.log(res)
                layer.close(loading);
                Feng.info(res.msg);
                work.table.refresh();
            }
            ,error:function(index, upload){
                layer.close(loading);
            }
        });
    })
}

var TableInit=function (bstableId,url,columns) {

        this.btInstance = null;
        this.bstableId = bstableId;
        this.url = Feng.ctxPath + url;
        this.method = "post";
        this.paginationType = "server";
        this.toolbarId = bstableId + "Toolbar";
        this.columns = columns;
        this.height = 665;
        this.data = {};
        this.queryParams = {};
    
}

TableInit.prototype={
    /**
     * 初始化bootstrap table
     */
    init: function () {
        var tableId = this.bstableId;
        var me = this;
        this.btInstance =
            $('#' + tableId).bootstrapTable({
                contentType: "application/x-www-form-urlencoded",
                url: this.url,				//请求地址
                method: this.method,		//ajax方式,post还是get
                ajaxOptions: {				//ajax请求的附带参数
                    data: this.data
                },
                toolbar: "#" + this.toolbarId,//顶部工具条
                striped: true,     			//是否显示行间隔色
                cache: false,      			//是否使用缓存,默认为true
                pagination: true,     		//是否显示分页（*）
                sortable: true,      		//是否启用排序
                sortOrder: "desc",     		//排序方式
                pageNumber: 1,      			//初始化加载第一页，默认第一页
                pageSize: 14,      			//每页的记录行数（*）
                pageList: [14, 50, 100],  	//可供选择的每页的行数（*）
                queryParamsType: 'limit', 	//默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
                queryParams: function (param) {
                    return $.extend(me.queryParams, param);
                }, // 向后台传递的自定义参数
                sidePagination: this.paginationType,   //分页方式：client客户端分页，server服务端分页（*）
                search: false,      		//是否显示表格搜索，此搜索是客户端搜索，不会进服务端
                strictSearch: true,			//设置为 true启用 全匹配搜索，否则为模糊搜索
                showColumns: true,     		//是否显示所有的列
                showRefresh: true,     		//是否显示刷新按钮
                minimumCountColumns: 2,    	//最少允许的列数
                clickToSelect: true,    	//是否启用点击选中行
                searchOnEnterKey: true,		//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
                columns: this.columns,		//列数组
                pagination: true,			//是否显示分页条
                height: this.height,
                icons: {
                    refresh: 'glyphicon-repeat',
                    toggle: 'glyphicon-list-alt',
                    columns: 'glyphicon-list'
                },
                iconSize: 'outline'
            });
        return this;
    },
    /**
     * 向后台传递的自定义参数
     * @param param
     */
    setQueryParams: function (param) {
        this.queryParams = param;
    },
    /**
     * 设置分页方式：server 或者 client
     */
    setPaginationType: function (type) {
        this.paginationType = type;
    },

    /**
     * 设置ajax post请求时候附带的参数
     */
    set: function (key, value) {
        if (typeof key == "object") {
            for (var i in key) {
                if (typeof i == "function")
                    continue;
                this.data[i] = key[i];
            }
        } else {
            this.data[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
        }
        return this;
    },

    /**
     * 设置ajax post请求时候附带的参数
     */
    setData: function (data) {
        this.data = data;
        return this;
    },

    /**
     * 清空ajax post请求参数
     */
    clear: function () {
        this.data = {};
        return this;
    },

    /**
     * 刷新 bootstrap 表格
     */
    refresh: function (parms) {
        if (typeof parms != "undefined") {
            this.btInstance.bootstrapTable('refresh', parms);
        } else {
            this.btInstance.bootstrapTable('refresh');
        }
    }
};

$(function () {

    work.initTime();
    var defaultColunms = work.initColumn();
    var queryParams=$("#birthday").val();

    var myTable=new TableInit(work.id, "/work/listServerWarp", defaultColunms);

    myTable.setPaginationType("server");

    work.table=myTable.init();

    myTable.init();

    uploadExcel();

});
