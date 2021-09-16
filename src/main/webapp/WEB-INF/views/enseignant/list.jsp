
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
                        <h4 class="card-title mb-3">Liste des enseignants</h4>
                    </div>
                    <div class="table-responsive">
					    <table id="zero_config" class="table table-striped table-bordered no-wrap">
					        <thead>
					            <tr>
					                <th>Mat</th>
					                <th>Nom</th>
					                <th>Tel</th>
					                <th>Adresse</th>
					                <th>Ville</th>
					                <th>Actions</th>
					            </tr>
					        </thead>
					        <tbody>
					          <c:forEach items="${ liste_enseignants }" var="enseignant">
						           <tr>
						              <td>${ enseignant.matricule }</td>
						              <td>${ enseignant.nom }</td>
						              <td>${ enseignant.tel }</td>
						              <td>${ enseignant.adresse }</td>
						              <td>${ enseignant.ville }</td>
						              <td>
		                                <a href="editEn?id=<c:out value='${ enseignant.id }' />" class="btn btn-primary btn-sm btn-circle">
		                                	<i class="fa fa-pencil-alt" style="color: #fff"></i>
		                                </a>
		                                <a href="deleteEn?id=<c:out value='${ enseignant.id }' />" class="btn btn-danger btn-sm btn-circle">
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
								<c:if test="${ enseignant != null}">
			            			Formulaire modification
			            		</c:if>
								<c:if test="${ enseignant == null}">
		            				Formulaire d'Ajout
		            			</c:if>
							</h4>
					</caption>
					
                    <div class="mt-4 activity">
                        <c:if test="${ enseignant != null}">
							<form action="updateEn" method="post">
						</c:if>
						<c:if test="${ enseignant == null}">
							<form action="insertEn" method="post">
						</c:if>
						
							<c:if test="${ enseignant != null}">
								<input type="hidden" name="id" value="<c:out value='${ enseignant.id }' />" />
							</c:if>
							
							<div class="form-group">
							  <label for="formGroupExampleInput">Matricule</label>
							  <input value="<c:out value='${ enseignant.matricule }' />" type="text" class="form-control" name="matricule" placeholder="Matricule">
							</div>
							
							<div class="form-group">
							  <label for="formGroupExampleInput">Nom</label>
							  <input value="<c:out value='${ enseignant.nom }' />" type="text" class="form-control" name="nom" placeholder="Nom complet">
							</div>
							
							<div class="form-group">
							  <label for="formGroupExampleInput">Tel</label>
							  <input value="<c:out value='${ enseignant.tel }' />" type="number" class="form-control" name="tel" placeholder="Telephone">
							</div>
							
							<div class="form-group">
							  <label for="formGroupExampleInput">Adresse</label>
							  <input value="<c:out value='${ enseignant.adresse }' />" type="text" class="form-control" name="adresse" placeholder="Enter de l'adresse">
							</div>
							
							<div class="form-group">
							  <label for="formGroupExampleInput">Ville</label>
							  <input value="<c:out value='${ enseignant.ville }' />" type="text" class="form-control" name="ville" placeholder="Ville">
							</div>
							
							<div class="form-group">
								<label class="mr-sm-2" for="inlineFormCustomSelect">Commission</label>
                               <select name="idCo" class="custom-select mr-sm-2" id="inlineFormCustomSelect">
                                   <option selected>Choisir commission...</option>
                                   <c:forEach items="${ liste_commissions }" var="commission">
                                       <option value="<c:out value='${ commission.id }' />">${ commission.nom }</option>
                                   </c:forEach>
                            	</select>
							</div>
							
                            <div class="form-group">
	                            <label class="mr-sm-2" for="inlineFormCustomSelect">Établissement</label>
	                               <select name="idEt" class="custom-select mr-sm-2" id="inlineFormCustomSelect">
	                                   <option selected>Choisir établissement...</option>
	                                   <c:forEach items="${ liste_etablissements }" var="etablissement">
	                                       <option value="<c:out value='${ etablissement.id }' />">${ etablissement.nom }</option>
	                                   </c:forEach>
	                            </select>
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
 

               

           