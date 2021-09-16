
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
                        <h4 class="card-title mb-3">Liste des eleves</h4>
                    </div>
                    <div class="table-responsive">
					    <table id="zero_config" class="table table-striped table-bordered no-wrap">
					        <thead>
					            <tr>
					                <th>Mat</th>
					                <th>Nom</th>
					                <th>Prenom</th>
					                <th>Date Nais.</th>
					                <th>Actions</th>
					            </tr>
					        </thead>
					        <tbody>
					          <c:forEach items="${ liste_eleves }" var="eleve">
						           <tr>
						              <td>${ eleve.matricule }</td>
						              <td>${ eleve.nom }</td>
						              <td>${ eleve.prenom }</td>
						              <td>${ eleve.datenaiss }</td>
						              <td>
		                                <a href="editEl?id=<c:out value='${ eleve.id }' />" class="btn btn-primary btn-sm btn-circle">
		                                	<i class="fa fa-pencil-alt" style="color: #fff"></i>
		                                </a>
		                                <a href="deleteEl?id=<c:out value='${ eleve.id }' />" class="btn btn-danger btn-sm btn-circle">
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
								<c:if test="${ eleve != null}">
			            			Formulaire modification
			            		</c:if>
								<c:if test="${ eleve == null}">
		            				Formulaire d'Ajout
		            			</c:if>
							</h4>
					</caption>
					
                    <div class="mt-4 activity">
                        <c:if test="${ eleve != null}">
							<form action="updateEl" method="post">
						</c:if>
						<c:if test="${ eleve == null}">
							<form action="insertEl" method="post">
						</c:if>
						
							<c:if test="${ eleve != null}">
								<input type="hidden" name="id" value="<c:out value='${ eleve.id }' />" />
							</c:if>
							
							<div class="form-group">
							  <label for="formGroupExampleInput">Matricule</label>
							  <input value="<c:out value='${ eleve.matricule }' />" type="text" class="form-control" name="matricule" placeholder="Matricule">
							</div>
							
							<div class="form-group">
							  <label for="formGroupExampleInput">Nom</label>
							  <input value="<c:out value='${ eleve.nom }' />" type="text" class="form-control" name="nom" placeholder="Nom ">
							</div>
							
							<div class="form-group">
							  <label for="formGroupExampleInput">Prenom</label>
							  <input value="<c:out value='${ eleve.prenom }' />" type="text" class="form-control" name="prenom" placeholder="Prenom ">
							</div>
							
							<div class="form-group">
							  <label for="formGroupExampleInput">Date Naissance</label>
							  <input value="<c:out value='${ eleve.datenaiss }' />" type="date" class="form-control" name="datenais" placeholder="Enter de l'adresse">
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
							<div class="form-group">
	                            <label class="mr-sm-2" for="inlineFormCustomSelect">Examen</label>
	                               <select name="idEx" class="custom-select mr-sm-2" id="inlineFormCustomSelect">
	                                   <option selected>Choisir l'examen...</option>
	                                   <c:forEach items="${ liste_examens }" var="examen">
	                                       <option value="<c:out value='${ examen.id }' />">${ examen.nom }</option>
	                                   </c:forEach>
	                            </select>
							</div> 
							 
							 <c:if test="${ eleve != null}">
			            			<button type="submit" class="btn btn-success">
									 	Modifier
									 </button>
			            	 </c:if>
							 <c:if test="${ eleve == null}">
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
 

               

           