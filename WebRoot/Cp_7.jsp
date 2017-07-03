<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="check.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>USTC-ITSEC信息管理平台</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" >
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
		<script  type="text/javascript" src="bootstrap/js/jquery.min.js" ></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js" ></script>		
		<link rel="shortcut icon" href="images/title.png" type="image/x-icon">
		<style type="text/css">
			body {
			 width:95%;margin-left:auto;margin-right:auto;
			 background-color:#eef3f7;
			}
		</style>
		<script type="text/javascript">
			
			 $(function(){
				 $(".miaoshu div").css("display","none");
				 $(".cc1").click(function(){
					 $(this).parent().parent().find(".miaoshu .miaoshu1").toggle(500).siblings().fadeOut();
					 })
				  $(".cc2").click(function(){
					 $(this).parent().parent().find(".miaoshu .miaoshu2").toggle(500).siblings().fadeOut();
					 })
				 $(".cc3").click(function(){
					 $(this).parent().parent().find(".miaoshu .miaoshu3").toggle(500).siblings().fadeOut();
					 })
				 $(".cc4").click(function(){
					 $(this).parent().parent().find(".miaoshu .miaoshu4").toggle(500).siblings().fadeOut();
					 })
				 $(".cc5").click(function(){
					 $(this).parent().parent().find(".miaoshu .miaoshu5").toggle(500).siblings().fadeOut();
					 })
					 
				$(".cc6").click(function(){
					 $(this).parent().parent().find(".miaoshu .miaoshu6").toggle(500).siblings().fadeOut();
					 }) 
				 <!--tabjs over-->
	 
	 <!--初始化根据数字显示进度begin-->
				 var bfb = $(".miaoshu1 .span1").text();
				 bfb =bfb*140/100;
				$(".bfb1 img").animate({width:bfb+"px"})
				
				var bfb = $(".miaoshu2 .span2").text();
				 bfb =bfb*140/100;
				$(".bfb2 img").animate({width:bfb+"px"})
				
				var bfb = $(".miaoshu3 .span3").text();
				 bfb =bfb*140/100;
				$(".bfb3 img").animate({width:bfb+"px"})
				
				var bfb = $(".miaoshu4 .span4").text();
				 bfb =bfb*140/100;
				$(".bfb4 img").animate({width:bfb+"px"})
				
				var bfb = $(".miaoshu5 .span5").text();
				 bfb =bfb*140/100;
				$(".bfb5 img").animate({width:bfb+"px"})
				
				var bfb = $(".miaoshu6 .span6").text();
				 bfb =bfb*140/100;
				$(".bfb6 img").animate({width:bfb+"px"})
				
				<!--初始化根据数字显示进度over-->
			 })
		</script>
		<script type="text/javascript">

			function getTab(mm){
				for(var i=1;i<=10;i++){
					if(i==mm){
						document.getElementById("d" +mm).style.display="block";
					}else{
						document.getElementById("d" +i).style.display="none";	
					}
				}
			}
		</script>
		
	</head>
	<body class="container-fluid">
		<br><br>
		<div style="width:1024px; margin:0 auto;" class="tag" id="d7">
		
		<s:iterator value="system" id="sys">

				<br>
				<!-- <div contenteditable="true" style="-moz-border-radius: 4px;-khtml-border-radius: 4px;-webkit-border-radius: 4px;border-radius: 4px; color:#000; font-size:16px; background:url(images/bgt.png) repeat ; "> -->
	    		<div style="text-align:left; width:100%" class="btn btn-info">
	    			${project.corName}--${sys.sysName}</div>
	    		
	    		
	    	<br>
			<div class="jinzhan" style="-moz-border-radius: 6px;-khtml-border-radius: 6px;-webkit-border-radius: 6px;border-radius: 6px; padding:5px; margin-bottom:-10px;">
			
		    <div style=" text-align:center; color:#000; font-weight: 900">
		      <div style="float:left; width:113px;">商务洽谈</div>
		      <div style="float:left; width:180px; margin-left:34px;">前期调查</div>
		      <div style="float:left; width:180px;">进入现场</div>
		      <div style="float:left; width:180px;">人工测评</div>
		      <div style="float:left; width:180px;">编写报告</div>
		      <div style="float:left; width:130px; text-align:left; text-indent:60px;">项目完结</div>
		      <div style=" clear:both;"></div>
		    </div>
			<div style=" clear:both;"></div>
			</div>
	    <div class="jinzhan" style="-moz-border-radius: 6px;-khtml-border-radius: 6px;-webkit-border-radius: 6px;border-radius: 6px;   padding:5px; margin-bottom:10px;">
	    	
		    <div style=" background:url(images/index_05.png) no-repeat; width:965px; height:67px; padding:14px 11px; margin:0px auto 0 auto;">
		      	<div class="cc1" style=" width:40px; height:40px; float:left; cursor:pointer;"></div>
		     	 <div class="bfb1" style=" width:140px; height:27px; float:left; padding-top:13px;  "><img style=" height:13px; display:block;" src="images/1.png"></div>
		      	<div class="cc2" style=" width:40px; height:40px; float:left; cursor:pointer;"></div>
		      	<div class="bfb2" style=" width:140px; height:40px; float:left;  padding-top:13px;  "><img style=" height:13px; display:block;" src="images/2.png"></div>
		       <div class="cc3" style=" width:40px; height:40px; float:left; cursor:pointer;"></div>
		       <div  class="bfb3" style=" width:140px; height:40px; float:left;   padding-top:13px;  "><img style=" height:13px; display:block;" src="images/3.png"></div>
		       <div class="cc4" style=" width:40px; height:40px; float:left; cursor:pointer;"></div>
		      <div  class="bfb4" style=" width:140px; height:40px; float:left;   padding-top:13px;  "><img style=" height:13px; display:block;" src="images/4.png"></div>
		      <div class="cc5" style=" width:40px; height:40px; float:left; cursor:pointer;"></div>
		      <div  class="bfb5" style=" width:140px; height:40px; float:left;  padding-top:13px;  "><img style=" height:13px; display:block;" src="images/5.png"></div>
		      <div class="cc6" style=" width:40px; height:40px; float:left; cursor:pointer;"></div>
		      <div style=" clear:both;"></div>
		    	</div>
    		<div class="miaoshu" style=" position:relative; ">
            <div class="miaoshu1"  style="  margin-left:13px;-moz-border-radius: 11px;-khtml-border-radius: 11px;-webkit-border-radius: 11px;border-radius: 11px;  background:url(images/bgt.png) repeat ; padding:10px; display:inline-block;width:225px; height:auto;  position:absolute; top:10px; left:-18px;" > 进度： 
	            <span  class="span1" contenteditable="true" style="">
	            	<s:if test="state==0">
	            	50
	            	</s:if>
	            	<s:else>
				       100
				    </s:else>
	            </span>%<br>
	     		<span contenteditable="true" >已完成：</span><br>
	     		 <span contenteditable="true" >未完成： </span>
     		</div>
     		<s:if test="state==1">
     		<s:iterator id="tt" value="testSys">
		    <div class="miaoshu2"   style="  margin-left:13px;-moz-border-radius: 11px;-khtml-border-radius: 11px;-webkit-border-radius: 11px;border-radius: 11px;  background:url(images/bgt.png) repeat ; padding:10px; display:inline-block;width:225px; height:auto;  position:absolute; top:10px; left:105px;" > 进度： 
		    	<span  class="span2" contenteditable="true" style="">
		    	<s:if test="testSystem.cpState == 1">
		    		50
		    	</s:if>
		    	<s:if test="#tt.cpState >1"> 100 </s:if>
		    	</span>%<br>
		        <span contenteditable="true" >已完成：</span><br>
		        <span contenteditable="true" >未完成： </span>
		    </div>
		    <div class="miaoshu3"   style="  margin-left:13px;-moz-border-radius: 11px;-khtml-border-radius: 11px;-webkit-border-radius: 11px;border-radius: 11px;  background:url(images/bgt.png) repeat ; padding:10px; display:inline-block;width:225px; height:auto;  position:absolute; top:10px; left:290px;" > 进度： 
		    	<span contenteditable="true" style="" class="span3">
		    		<s:if test="testSystem.cpState == 2">
		    		50
		    	</s:if>
		    	<s:if test="testSystem.cpState >2"> 100 </s:if>
		    	</span>%<br>
		        <span contenteditable="true" >已完成：</span><br>
		       <span contenteditable="true" >未完成： </span>
		   </div>

	       <div class="miaoshu4"  style="  margin-left:13px;-moz-border-radius: 11px;-khtml-border-radius: 11px;-webkit-border-radius: 11px;border-radius: 11px;  background:url(images/bgt.png) repeat ; padding:10px; display:inline-block;width:225px; height:auto;  position:absolute;  top:10px; left:470px;" > 进度： 
		       	<span contenteditable="true" style="" class="span4">
		       	<s:if test="testSystem.cpState == 3">
		    		50
		    	</s:if>
		    	<s:if test="testSystem.cpState >3 ">100</s:if>
		       	</span>%<br>
		        <span contenteditable="true" >已完成：</span><br>
		       <span contenteditable="true" >未完成： </span>
	   		</div>
	     	<div class="miaoshu5"  style="   margin-left:13px;-moz-border-radius: 11px;-khtml-border-radius: 11px;-webkit-border-radius: 11px;border-radius: 11px;  background:url(images/bgt.png) repeat ; padding:10px; display:inline-block;width:225px; height:auto;  position:absolute; top:10px; left:650px;" > 进度： 
	     		<span contenteditable="true" style="" class="span5">
	     		<s:if test="testSystem.cpState == 4">
		    		50
		    	</s:if>
		    	<s:if test="testSystem.cpState >4">100</s:if>
	     		</span>%<br>
	      		<span contenteditable="true" >已完成：</span><br>
	      		<span contenteditable="true" >未完成</span> 
	      	</div>
	        <div class="miaoshu6"   style="   margin-left:13px;-moz-border-radius: 11px;-khtml-border-radius: 11px;-webkit-border-radius: 11px;border-radius: 11px;  background:url(images/bgt.png) repeat ; padding:10px; display:inline-block;width:225px; height:auto;  position:absolute; top:10px; left:762px;" > 测评结束： 
	        </div>
	    	</s:iterator>
	        </s:if>
	       <div style=" clear:both;"></div>
			</div><!--miao shu-->
			<div style=" clear:both;"></div>
		</s:iterator>
		<input type=button class="btn btn-info" value="后退" onclick="window.history.go(-1)" style ="margin-left:20px;margin-top:50px">
		</div>
		
		<div class="navbar-fixed-bottom container span12 ">
        <p class=" text-center ">&copy;中国科学技术大学信息安全测评中心&nbsp;&nbsp;&nbsp;&nbsp;地址：邮编：  <a href="http://itsec.ustc.edu.cn/contact.php">联系我们</a></p>
        <p class="text-center"></p>
		</div>
	</body>
</html>
