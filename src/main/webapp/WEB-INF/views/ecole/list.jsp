
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
                        <h4 class="card-title mb-3">Liste des établissement</h4>
                    </div>
                    <div class="table-responsive">
					    <table id="zero_config" class="table table-striped table-bordered no-wrap">
					        <thead>
					            <tr>
					                <th>ID</th>
					                <th>Nom</th>
					                <th>Adresse</th>
					                <th>Actions</th>
					            </tr>
					        </thead>
					        <tbody>
					          <c:forEach items="${ liste_etablissements }" var="etablissement">
						           <tr>
						              <td>${ etablissement.id }</td>
						              <td>${ etablissement.nom }</td>
						              <td>${ etablissement.adresse }</td>
						              <td>
		                                <a href="editEt?id=<c:out value='${ etablissement.id }' />" class="btn btn-primary btn-sm btn-circle">
		                                	<i class="fa fa-pencil-alt" style="color: #fff"></i>
		                                </a>
		                                <a href="deleteEt?id=<c:out value='${ etablissement.id }' />" class="btn btn-danger btn-sm btn-circle">
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
								<c:if test="${ etablissement != null}">
			            			Formulaire modification
			            		</c:if>
								<c:if test="${ etablissement == null}">
		            				Formulaire d'Ajout
		            			</c:if>
							</h4>
					</caption>
					
                    <div class="mt-4 activity">
                        <c:if test="${ etablissement != null}">
							<form action="updateEt" method="post">
						</c:if>
						<c:if test="${ etablissement == null}">
							<form action="insertEt" method="post">
						</c:if>
						
							<c:if test="${ etablissement != null}">
								<input type="hidden" name="id" value="<c:out value='${ etablissement.id }' />" />
							</c:if>
							
							<div class="form-group">
							  <label for="formGroupExampleInput">Nom</label>
							  <input value="<c:out value='${ etablissement.nom }' />" type="text" class="form-control" name="nom" placeholder="Enter le nom">
							</div>
							
							<div class="form-group">
							  <label for="formGroupExampleInput">Adresse</label>
							  <input value="<c:out value='${ etablissement.adresse }' />" type="text" class="form-control" name="adresse" placeholder="Enter de l'adresse">
							</div>
								  
							 
							 <c:if test="${ etablissement != null}">
			            			<button type="submit" class="btn btn-success">
									 	Modifier
									 </button>
			            	 </c:if>
							 <c:if test="${ etablissement == null}">
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
 

               

           