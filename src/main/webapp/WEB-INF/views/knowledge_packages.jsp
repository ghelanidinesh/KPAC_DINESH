<!DOCTYPE HTML>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="shortcut icon" href="data:image/x-icon;," type="image/x-icon">
	<title>Knowledge-Packages</title>
	<link href="<c:url value="/resources/codebase/suite.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/js/bootstrap.min.css" />" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active">
				<a style="color: #0c63e4" class="nav-link" href="#"><b>Knowledge Package</b></a>
			</li>
			<li class="nav-item">
				<a style="color: #0ab169" href="${pageContext.request.contextPath}/sets"><b>Knowledge Package Set</b></a>
			</li>
		</ul>
	</div>
</nav>
		<div class="container">
			<h4>Knowledge Package</h4>
			<form class="dhx_form" action="kpacs" method="post">
				<div class="dhx_form-group">
					<label class="dhx_label" for="title">Title</label>
					<input style="width: 500px" class="dhx_input--text-input" type="text" id="title" name="title" maxlength="250" placeholder="Title" required/>
				</div>
				<div class="dhx_form-group">
					<label class="dhx_label" for="description">Description</label>
					<textarea style="width: 300px" class="dhx_input--textarea" id="description" name="description" maxlength="2000" rows="3" cols="50" required></textarea>
				</div>
				<div class="dhx_form-group">
					<input class="dhx_button--color_primary" type="button" value="SAVE" onclick="form.submit()">
				</div>
			</form>
			<div style="height: 50rem; width: 70rem" id="kpac_grid_container"></div>
		</div>

</body>
<script src="<c:url value="/resources/codebase/suite.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script>
    	const contextPath = '${pageContext.request.contextPath}';
		const grid = new dhx.Grid('kpac_grid_container', {
		  columns: [
		    {
		      id: 'id', width: 150, tooltip: false,
		      header: [
		        { text: 'Id' },
		        { content: 'comboFilter', customFilter: (value, match) => value === match,},
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
		      id: 'description',
		      header: [
		        { text: 'Description' },
		        {
		          content: 'inputFilter',
		          customFilter: (value, match) => value.toLowerCase().includes(match.toLowerCase()),
		        },
		      ],
		    },
		    {
		      id: 'creationDate',
		      width: 180,
		      header: [
		        { text: 'Creation Date' },
		        {
		          content: 'selectFilter',
		          customFilter: (value, match) => value < match,
		        },
		      ],
		      align: "center"
		    },
		    {
                width: 160,
                header: [{text: "Delete", align: "center"}],
                sortable: false,
                align: "center",
                htmlEnable: true,
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
	                    deleteKPac(data.row);
	                }
	            }
	      }
		});
		loadGridData();

		function loadGridData() {
			const kpacApi = "/api/kpacs";
	        dhx.ajax.get(contextPath + kpacApi).then(function (data) {
	            grid.data.parse(
			      data.map(function (obj) {
			        return {
			          id: obj.id + '',
			          title: obj.title,
			          description: obj.description,
			          creationDate: obj.creationDate,
			        }
			      })
			    )
	        });
		}

		function deleteKPac(row) {
			const deleteApi = "/api/kpacs/";
	        dhx.ajax
	            .delete(contextPath + deleteApi + row.id)
	            .then(function (data) {
	                loadGridData();
	            }).catch(function (error) {
	            	console.log('Error in delete Kpac Api:',error)
	        });
	    }
    </script>
</html>
