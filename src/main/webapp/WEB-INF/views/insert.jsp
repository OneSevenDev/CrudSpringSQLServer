<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false"%>

<jsp:include page="include/header_template.jsp"></jsp:include>
        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Employee <small>Container</small></h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for...">
                    <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Go!</button>
                    </span>
                  </div>
                </div>
              </div>
            </div>
            
            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-6 col-sm-xs-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Employees</h2>
	                <div class="clearfix"></div>
                  </div>
                  <div class="x_content">

                    <p class="text-muted font-13 m-b-30">List all employees</p>
                    
                    <!-- start form for validation -->
                    <form:form action="${pageContext.request.contextPath}/agregar" method="post" id="demo-form">
						<div id="alertSuccess" class="alert alert-success alert-dismissible fade in" role="alert" style="display:none;">
							<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span>
							</button>
							<p id="messageAlert">${ message }</p>
						</div>
						<label for="nombres">Name * :</label>
						<input type="text" id="nombres" class="form-control" name="nombres" placeholder="Nombre" required />
						
						<label for="apellidos">Last Name * :</label>
						<input type="text" id="apellidos" class="form-control" name="apellidos" placeholder="Apellidos" required />

						<label for="edad">Age * :</label>
						<input type="text" id="edad" class="form-control" name="edad" placeholder="Edad" required />

						<label for="selectPosition">Position Company *:</label>
						<select id="selectPosition" class="form-control" name="selectPosition" required>
                            <c:forEach items="${list}" var="list">
								<option value="${list.id }"> ${list.nombrecargo }</option>
							</c:forEach>
						</select>
						<br/>
						<div class="nav navbar-right panel_toolbox">
							<a href="${pageContext.request.contextPath}">Volver </a>
							<input class="btn btn-primary" type="submit" name="send" value="Agregar"/>
						</div>

                    </form:form>
                    <!-- end form for validations -->

                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->

<jsp:include page="include/footer_template.jsp"></jsp:include>

    <!-- Custom Me -->
	<script src="${pageContext.request.contextPath}/resources/js/MessageAlert.js"></script>