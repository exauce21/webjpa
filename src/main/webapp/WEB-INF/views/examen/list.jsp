
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../../header.jsp"></jsp:include>
 <!-- Container fluid  -->
 <!-- ============================================================== -->
<div class="container-fluid">
  <!-- *************************************************************** -->
    <!-- Start Location and Earnings Charts Section -->
    <!-- *************************************************************** -->
    <div class="row">
        <div class="col-md-6 col-lg-8">
            <div class="card">
                <div class="card-body">
                    <div class="d-flex align-items-start">
                        <h4 class="card-title mb-3">Liste des examens</h4>
                    </div>
                    <div class="table-responsive">
					    <table id="zero_config" class="table table-striped table-bordered no-wrap">
					        <thead>
					            <tr>
					                <th>ID</th>
					                <th>Nom</th>
					                <th>Date</th>
					                <th>Academie</th>
					                <th>Actions</th>
					            </tr>
					        </thead>
					        <tbody>
					          <c:forEach items="${ liste_examens }" var="examen">
						            <tr>
						              <td>${ examen.id }</td>
						              <td>${ examen.nom }</td>
						              <td>${ examen.date }</td>
						              <td>${ examen.academie.nom }</td>
						              <td>
		                                <a href="editEx?id=<c:out value='${ examen.id }' />" class="btn btn-primary btn-sm btn-circle">
		                                	<i class="fa fa-pencil-alt" style="color: #fff"></i>
		                                </a>
		                                <a href="deleteEx?id=<c:out value='${ examen.id }' />" class="btn btn-danger btn-sm btn-circle">
		                                	<i class="fa fa-trash-alt" style="color: #fff"></i>
		                                </a>
						              </td>
						          </tr>
					          </c:forEach>
					        </tbody>
					    </table>
					</div>      
                </div>
            </div>
        </div>
        <div class="col-md-6 col-lg-4">
            <div class="card">
                <div class="card-body">
                    <caption>
							<h4 class="card-title">
								<c:if test="${ examen != null}">
			            			Formulaire modification
			            		</c:if>
								<c:if test="${ examen == null}">
		            				Formulaire d'Ajout
		            			</c:if>
							</h4>
					</caption>
					
                    <div class="mt-4 activity">
                        <c:if test="${ examen != null}">
							<form action="updateEx" method="post">
						</c:if>
						<c:if test="${ examen == null}">
							<form action="insertEx" method="post">
						</c:if>
						
							<c:if test="${ examen != null}">
								<input type="hidden" name="id" value="<c:out value='${ examen.id }' />" />
							</c:if>
							
							<div class="form-group">
							  <label for="formGroupExampleInput">Nom</label>
							  <input value="<c:out value='${ examen.nom }' />" type="text" class="form-control" name="nom" placeholder="Enter le nom">
							</div>
							
							<div class="form-group">
							  <label for="formGroupExampleInput">Date d'examen</label>
							  <input value="<c:out value='${ examen.date }' />" type="date" class="form-control" name="dateEx">
							</div>
							
							<div class="form-group">
							  <label class="mr-sm-2" for="inlineFormCustomSelect">Academie</label>
                                  <select name="idAc" class="custom-select mr-sm-2" id="inlineFormCustomSelect">
                                       <c:if test="${ examen.academie.nom != null}">
			            					<option value="<c:out value='${ examen.academie.id }' />" selected>${ examen.academie.nom }</option>
			            	 	 	   </c:if>
							           <c:if test="${ examen.academie.nom == null}">
		            						<option selected>Choisir...</option>
		            		           </c:if>
		            		           
                                       <c:forEach items="${ liste_academies }" var="academie">
                                          <option value="<c:out value='${ academie.id }' />">${ academie.nom }</option>
                                       </c:forEach>
                                  </select>
							</div>
							
							 <c:if test="${ examen != null}">
			            			<button type="submit" class="btn btn-success">
									 	Modifier
									 </button>
			            	 </c:if>
							 <c:if test="${ examen == null}">
		            				<button type="submit" class="btn btn-primary">
									 	Ajouter
									 </button>
		            		 </c:if>
						 </form>
                    </div> 
                </div>
            </div>
        </div>
    </div>
    <!-- *************************************************************** -->
    <!-- End Location and Earnings Charts Section -->
    <!-- *************************************************************** -->
 </div>
 <!-- /.container-fluid -->
<jsp:include page="../../../footer.jsp"></jsp:include>
 

               

           