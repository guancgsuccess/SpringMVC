<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/20 0020
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSON交互测试</title>
    <link type="text/css" rel="stylesheet"
          href='${pageContext.request.contextPath}/dist/css/bootstrap.min.css'>
</head>
<body>

    <!--
        1、请求json、输出json，要求请求的是json串，所以在前端页面中需要将请求的内容转成json，不太方便。

        2、请求key/value、输出json。此方法比较常用。
    -->
    <button class="btn btn-default" onclick="test01()">请求json,输出是json</button>

    <button class="btn btn-default" onclick="test03()">请求json,输出是json,映射到集合</button>

    <button class="btn btn-default" onclick="test02()">请求key/value,输出是json</button>

    <button class="btn btn-default" onclick="test04()">根据id查询</button>

    <script src="${pageContext.request.contextPath}/dist/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/js/bootstrap.min.js"></script>
    <script>
        //请求json,输出是json
        function test01(){
            var jsonStr = '{"name":"手机","price":999}';
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath}/requestJson.action',
                contentType:'application/json;charset=utf-8',
                //数据格式是json串,商品信息
                data:jsonStr,
                success:function(data){//返回json结果
                        alert(data.name);
                }
            });
        }

        //请求json,输出是json
        function test03(){
            var saveDataAry=[];
            var data1={"name":"test1","price":999};
            var data2={"name":"test2","price":9999};
            saveDataAry.push(data1);
            saveDataAry.push(data2);
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath}/requestJsonList.action',
                contentType:'application/json;charset=utf-8',
                //数据格式是json串,商品信息
                data:JSON.stringify(saveDataAry),
                success:function(data){//返回json结果
                    alert(data[0].name);
                }
            });
        }

        //请求key/value，输出是json
        function test02(){
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath }/requestJsonStr.action',
                //请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
                //contentType:'application/json;charset=utf-8',
                //数据格式是json串，商品信息
                data:'name=手机&price=999',
                success:function(data){//返回json结果
                    alert(data.name);
                }
            });
        }

        //根据id查询
        function test04(){
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath }/findItemsList.action',
                //请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
                //contentType:'application/json;charset=utf-8',
                //数据格式是json串，商品信息
                data:'id=1',
                success:function(data){//返回json结果
                    alert(data.name);
                }
            });
        }
    </script>
</body>
</html>
