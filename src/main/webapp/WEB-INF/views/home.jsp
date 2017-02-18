<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
              <div class="col-md-12  col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Employees</h2>
                    <div class="nav navbar-right panel_toolbox">
		                <a href="${pageContext.request.contextPath}/agregar" class="btn btn-primary btn-xs">New Employee</a>
                    </div>
	                <div class="clearfix"></div>
                  </div>
                  <div class="x_content">

                    <p class="text-muted font-13 m-b-30">List all employees</p>

                    <!-- start project list -->
                    <table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                      <thead>
                        <tr>
                          <th style="width: 1%">#</th>
                          <th style="width: 20%">Employee Name</th>
                          <th>Last Name</th>
                          <th>Age</th>
                          <th>Position</th>
                          <th style="width: 20%">#Controls</th>
                        </tr>
                      </thead>
                      <tbody>
                      	<c:forEach items="${list}" var="list">
							<tr>
								<th><c:out value="${list.id}"/></th>
								<th><c:out value="${list.nombres}"/></th>
								<th><c:out value="${list.apellidos}"/></th>
								<th><c:out value="${list.edad}"/></th>
								<th><c:out value="${list.cargo.nombrecargo}"/></th>
								<th>
									<a href="${pageContext.request.contextPath}/editar?id=${list.id}"
										class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Edit </a>
									<a href="${pageContext.request.contextPath}/eliminar?id=${list.id}"
										onclick="return confirm('¿Esta seguro de eliminar?')"
										class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> Delete </a>
								</th>
							</tr>
						</c:forEach>                   
                      </tbody>
                    </table>
                    <!-- end project list -->

                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->

<jsp:include page="include/footer_template.jsp"></jsp:include>