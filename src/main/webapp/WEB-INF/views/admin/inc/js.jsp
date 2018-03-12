<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!-- jQuery 3 -->
 
<script src=" <s:url value="/resources/bower_components/jquery/dist/jquery.min.js"></s:url>"></script>
<!-- jQuery UI 1.11.4 -->

<script src=" <s:url value="/resources/bower_components/jquery-ui/jquery-ui.min.js"></s:url>"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.7 -->
<script src="<s:url value="/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></s:url>"></script>
<!-- Morris.js charts -->
<script src="<s:url value="/resources/bower_components/select2/dist/js/select2.full.min.js"></s:url>"></script>

<script src="<s:url value="/resources/bower_components/raphael/raphael.min.js"></s:url>"></script>
<script src="<s:url value="/resources/bower_components/morris.js/morris.min.js"></s:url>"></script>
<!-- Sparkline -->

<script src="<s:url value="/resources/bower_components/jquery-sparkline/dist/jquery.sparkline.min.js"></s:url>"></script>
<!-- jvectormap -->
<script src="<s:url value="/resources/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></s:url>"></script>
<script src="<s:url value="/resources/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></s:url>"></script>
<!-- jQuery Knob Chart -->
<script src="<s:url value="/resources/bower_components/jquery-knob/dist/jquery.knob.min.js"></s:url>"></script>
<!-- daterangepicker -->
<script src="<s:url value="/resources/bower_components/moment/min/moment.min.js"></s:url>"></script>
<script src="<s:url value="/resources/bower_components/bootstrap-daterangepicker/daterangepicker.js"></s:url>"></script>
<!-- datepicker -->
<script src="<s:url value="/resources/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></s:url>"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="<s:url value="/resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></s:url>"></script>
<!-- Slimscroll -->
<script src="<s:url value="/resources/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></s:url>"></script>
<!-- FastClick -->
<script src="<s:url value="/resources/bower_components/fastclick/lib/fastclick.js"></s:url>"></script>
<!-- AdminLTE App -->
<script src="<s:url value="/resources/dist/js/adminlte.min.js"></s:url>"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="<s:url value="/resources/dist/js/pages/dashboard.js"></s:url>"></script>
<!-- AdminLTE for demo purposes -->
<script src="<s:url value="/resources/dist/js/demo.js"></s:url>"></script>
<script src="<s:url value="/resources/dist/js/admin.js"></s:url>"></script>

<script src="<s:url value="/resources/bower_components/ckeditor/ckeditor.js"></s:url>"></script>
<script>
  $(function () {
    // Replace the <textarea id="editor1"> with a CKEditor
    // instance, using default configuration.
    CKEDITOR.replace('editor1')
    //bootstrap WYSIHTML5 - text editor
    $('.textarea').wysihtml5()
  })
</script>
