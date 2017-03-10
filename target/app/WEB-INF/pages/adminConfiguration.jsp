<%--
  Created by IntelliJ IDEA.
  User: K.Kokulan
  Date: 3/2/2017
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Configuration</title>
</head>
<body>
<div>
    <form id="duration_form">
Sprint duration in days: <input type="number" id="sprint_interval"> <span> <button id="setDuration" >Set</button></span>
    </form>
</div>
<div id="error" hidden>
    <P style="color: red"> insert a valid number</P>
</div>

<script src="../../assets/js/jquery.js"></script>
<script class="include" type="text/javascript" src="../../assets/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="../../assets/js/jquery.scrollTo.min.js"></script>
<script src="../../assets/js/jQuery-slimScroll-1.3.0/jquery.slimscroll.js"></script>
<script src="../../assets/js/jquery.nicescroll.js"></script>

<script type="text/javascript">


    $('#setDuration').click(function(e){
        e.preventDefault();
        var value = $('#sprint_interval').val();
        if (!value.isEmpty && value > 0) {

            $('#error').hide();
            var myForm = $('#duration_form')[0];
            var fd = new FormData(myForm);

            var search = {};
            search["duration"]=$('#sprint_interval').val();

            $.ajax({
                type: "POST",
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                url: "/update_duration",
                data: JSON.stringify(search),
                dataType : 'json',
                success: function (result) {
                    console.log(result);
                },
                error: function (result) {
                    alert('error');
                    console.log(result);
                }
            });
        } else{
            $('#error').show();
        }

    });



</script>
</body>
</html>
