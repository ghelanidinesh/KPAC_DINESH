<!DOCTYPE HTML>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<c:set var="req" value="${pageContext.request}" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="shortcut icon" href="data:image/x-icon;," type="image/x-icon">
        <title>Knowledge-Packages-Sets</title>
		<link href="<c:url value="/resources/codebase/suite.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/js/bootstrap.min.css" />" rel="stylesheet">
    </head>
    <body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
					<a style="color: #0ab169" class="nav-link" href="${pageContext.request.contextPath}/kpacs"><b>Knowledge Package</b></a>
				</li>
				<li class="nav-item">
					<a style="color: #0c63e4" href="#"><b>Knowledge Package Set</b></a>
				</li>
			</ul>
		</div>
	</nav>
    	<div class="container">
				<h4>Knowledge Package Set</h4>
		       	<form  class="dhx_form" action="sets" method="post">
		       		<div class="dhx_form-group" >
     					<label class="dhx_label" for="title">Title:</label>
  						<input style="width: 500px" class="dhx_input--text-input" type="text" id="title" name="title" maxlength="250" required placeholder="Title" >
  					</div>
  					<div class="dhx_form-group">
     					<label for="kpacIds" class="dhx_label">Knowledge Packages</label>
						<select style="width: 300px" class="dhx_select" id="kpacIds" name="kpacIds" multiple="multiple" required>
							<option class="dhx_combobox-options__item" value="">-select-</option>
						</select>
  					</div>
  					<div class="dhx_form-group">
				  		<input class="dhx_button--color_primary" type="button" value="SAVE" onclick="form.submit()">
				  	</div>
				</form>
			<div style="height: 60rem; width: 60rem" id="set_grid_container"></div>
    	</div>
    </body>
	<script src="<c:url value="/resources/codebase/suite.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script>
      	const grid = new dhx.Grid('set_grid_container', {
        columns: [
	          {
	            id: 'id',
	            width: 200,
	            htmlEnable: true,
	            tooltip: false,
	            header: [
	              { text: 'Id' },
	              {
	                content: 'comboFilter',
	                customFilter: (value, match) => value === match,
	              },
	            ],
	          },
	          {
	            id: 'title',
	            header: [
	              { text: 'Title' },
	              {
	                content: 'inputFilter',
	                customFilter: (value, match) => value.toLowerCase().includes(match.toLowerCase()),
	              },
	            ],
	          },
	          {
	              width: 160,
	              header: [{text: "Delete", align: "center"}],
	              sortable: false,
	              align: "center",
	              htmlEnable: true,
	              tooltip: false,
	              template: function () {
	                  return "<div class='delete-button' style='color:red'>Delete</div>"
	              }
	          }
	        ],
	        headerRowHeight: 50,
	        autoWidth: true,
	        resizable: true,
	        eventHandlers: {
	            onclick: {
	                "delete-button": function (event, data) {
	                	deleteKPacSet(data.row);
	                }
	            }
	      	}
	      });
      	
      	const contextPath = '${pageContext.request.contextPath}';
  		( () => {
		    const xhttp = new XMLHttpRequest();
		    xhttp.onreadystatechange = function() {
		        if (this.readyState === 4 && this.status === 200) {
		            const responseText=this.responseText;
		            var select = document.getElementById("kpacIds");
		            const kpacData=JSON.parse(responseText)
					for(index in kpacData) {
					    select.options[select.options.length] = new Option(kpacData[index].title, kpacData[index].id);
					}
		        } 
		    };
		    xhttp.open("GET",  contextPath + "/api/kpacs", true);
		    xhttp.send();
		})();
  		loadKpacSetGridData()
		function loadKpacSetGridData() {
			  const loadSetApi = "/api/sets";
	        dhx.ajax.get(contextPath + loadSetApi).then(function (data) {
	            grid.data.parse(
			      data.map(function (obj) {
			        return {
			          id: obj.id + '',
			          title: obj.title,
			        }
			      })
			    )
	        });
		}
      
      	function deleteKPacSet(row) {
			  const deleteApi = "/api/sets/";
	        dhx.ajax
	            .delete(contextPath + deleteApi + row.id)
	            .then(function (data) {
	                loadKpacSetGridData();
	            }).catch(function (error) {
	            	console.log('Error in delete set Api:',error)
	        });
	    }
      	
      grid.events.on("cellDblClick", function(row,column,e){
          const kpacSetId=row.id
          const requestUrl='${req.requestURL}';
          let url=requestUrl.substring(0,requestUrl.indexOf("WEB-INF"));
          url=url+'set/'+kpacSetId;
          const strWindowFeatures = "location=yes,scrollbars=yes,status=yes";
          const win = window.open(url, "_blank", strWindowFeatures);
      });
    </script>
</html>
