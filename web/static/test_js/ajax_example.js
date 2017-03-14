/**
 * Ajax API 详解
 */
$.ajax("http://localhost:8080/",{
    data:{//发送请求携带的数据

    },
    type:"GET",//发送请求的GET POST方法
    processData:false,//是否对data数据进行自动转码的操作 默认为true 会把data的json对象自动转化成JSON字符串
    contentType:"",//请求提交数据的格式 默认为application/x-www-form-urlencoded 例子：请求JSON application/json
    traditional:true,//默认为false   代表当前的数据按照传统的格式进行url编码 比如数组的上传可能格式不是熟悉的形式 用了traditional之后级苄正常的传统格式了
    dataType:"text",//响应的数据类型 常用的值：text|html|json|script|jsonp 默认情况下会和请求的contentType相同 比如你请求了一个json对象ajax自动把数据变成json对象 那么success时也是一个json对象 你想要json字符串则可以设置dataType为text
    dataFilter:function (data,type) {//对响应的数据进行预处理的回调函数 return的数据会到success回调函数中去
        //data 是原始的相应数据 type是dataType 举例：你想要原始数据的统计个数 那么在预处理这里先处理之后再返回给success
    },
    async:true,//是否进行异步请求 默认为true
    cache:true,//是否缓存 默认为true
    beforeSend:function () {//发送过程中的函数 使用场景之一：可以在发送数据的时候在此方法中进行进度条的设置和禁止多次点击提交按钮

    },
    /*
     * 一些不常用的参数
     * global:是否触发全局事件
     * IfModifed:仅在服务器数据改变时加载数据
     * timeout:设置请求超时时间 若超时 触发error(jqXHR,"timeout","timeout")方法
     * context:回调中this指向的对象
     * username password:http需要验证时使用的参数
     */
    success:function (data) {//执行成功的回调函数 并返回成功的data信息

    },
    error:function (jqXHR,testStatus,err) {//执行错误时的回调函数
        //jqXHR jquery增强的XHR(XMLHTTPRequest)
        //testStatus 请求完成的状态文本
        //err 底层抛出的错误对象

    },
    complete:function (jqXHR,textStatus) {//无论成功和错误都执行的回调函数 （类似finally块）
        //jqXHR jquery增强的XHR(XMLHTTPRequest)
        //testStatus 请求完成的状态文本
    },
    statusCode:{//根据不同的状态码进行处理的回调函数
        '403':function (jqXHR,testStatus,err) {

        },
        '400':function (jqXHR,testStatus,err) {

        }
    }
})