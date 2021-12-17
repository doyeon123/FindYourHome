<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body style="background: url('/resources/js/background.jpg');">
<div id="page-wrapper" style="margin: 100px">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header" >�󼼺���</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default" >
                       <%--  <div class="panel-heading">
                            ${	vo.consulting_title}
                        </div> --%>
                        <!-- /.panel-heading -->
                        <div class="panel-body" style="display: flex; flex-direction: column;">
                            <div class="form-group">
                                <label>����</label>
                                <input readonly class="form-control" value="${vo.consulting_title}">
                                
                            </div>
                            <div class="form-group">
                                <label>����</label>
                                <textarea readonly class="form-control" rows="5">${vo.consulting_content}</textarea>
                            </div>
                            <div class="form-group">
                                <label>�ۼ���</label>
                                <input readonly class="form-control" value="${vo.consulting_author}">
                                
                            </div>
                            <div class="form-group" >
                                <label>��Ͻð�</label>
                                <input readonly class="form-control" value="${vo.consulting_writedate}">
                                
                            </div>
                            
                            
                        </div>
                        	<div style="padding-top: 15px">
                            <button type="button" onclick="move()" class="btn btn-outline-primary">����</button>
                            <button type="button" onclick="remove()" class="btn btn-outline-primary">����</button>
                            <button type="button" onclick="" class="btn btn-outline-primary">���</button>
                            <button type="button" onclick="detailBtn()" class="btn btn-outline-primary">���</button>
                            </div>
                            
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
        </div>

<script type="text/javascript">
	
	function move(){
	    location.href="/consulting/update?no="+${vo.consulting_registerno};
	
	    }
	function remove(){
	    location.href="/consulting/remove?no="+${vo.consulting_registerno};
	
	    }
	
	//�󼼺��� �̵�
	function detailBtn(){
		 location.href="javascript:history.back()";
		/* document.detailForm.action=url;
		document.detailForm.submit(); */
		
	}

</script>
</body>
</html>