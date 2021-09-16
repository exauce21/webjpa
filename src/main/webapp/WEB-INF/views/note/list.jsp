
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
                        <h4 class="card-title mb-3">Liste des notes</h4>
                    </div>
                    <div class="table-responsive">
					    <table id="zero_config" class="table table-striped table-bordered no-wrap">
					        <thead>
					            <tr>
					                <th>ELeve</th>
					                <th>Epreuve</th>
					                <th>Coef</th>
					                <th>Note</th>
					                <th>NC</th>
					                <th>NG</th>
					                <th>Actions</th>
					            </tr>
					        </thead>
					        <tbody>
					          <c:forEach items="${ liste_notes }" var="note">
						            <tr>
						              <td>${ note.eleve.nom }</td>
						              <td>${ note.epreuve.nom }</td>
						              <td>${ note.epreuve.coef }</td>
						              <td>${ note.valeur}</td>
						              <td>${ note.valeur * note.epreuve.coef }</td>
						              <td>${ (note.valeur * note.epreuve.coef)/2 }</td>
						              <td>
		                                <a href="editNt?id=<c:out value='${ note.id }' />" class="btn btn-primary btn-sm btn-circle">
		                                	<i class="fa fa-pencil-alt" style="color: #fff"></i>
		                                </a>
		                                <a href="deleteNt?id=<c:out value='${ note.id }' />" class="btn btn-danger btn-sm btn-circle">
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
								<c:if test="${ note != null}">
			            			Formulaire modification
			            		</c:if>
								<c:if test="${ note == null}">
		            				Formulaire d'Ajout
		            			</c:if>
							</h4>
					</caption>
					
                    <div class="mt-4 activity">
                        <c:if test="${ note != null}">
							<form action="updateNt" method="post">
						</c:if>
						<c:if test="${ note == null}">
							<form action="insertNt" method="post">
						</c:if>
						
							<c:if test="${ note != null}">
								<input type="hidden" name="id" value="<c:out value='${ note.id }' />" />
							</c:if>
							
							<div class="form-group">
							  <label class="mr-sm-2" for="inlineFormCustomSelect">Élève</label>
                                  <select name="idEl" class="custom-select mr-sm-2" id="inlineFormCustomSelect">
                                       <c:if test="${ note.eleve.nom != null}">
			            					<option value="<c:out value='${ note.eleve.id }' />" selected>${ note.eleve.nom }</option>
			            	 	 	   </c:if>
							           <c:if test="${ note.eleve.nom == null}">
		            						<option selected>Choisir...</option>
		            		           </c:if>
		            		           
                                       <c:forEach items="${ liste_eleves }" var="eleve">
                                          <option value="<c:out value='${ eleve.id }' />">${ eleve.nom }</option>
                                       </c:forEach>
                                  </select>
							</div>
							
							<div class="form-group">
							  <label class="mr-sm-2" for="inlineFormCustomSelect">Epreuve</label>
                                  <select name="idEp" class="custom-select mr-sm-2" id="inlineFormCustomSelect">
                                       <c:if test="${ note.epreuve.nom != null}">
			            					<option value="<c:out value='${ note.epreuve.id }' />" selected>${ note.epreuve.nom }</option>
			            	 	 	   </c:if>
							           <c:if test="${ note.epreuve.nom == null}">
		            						<option selected>Choisir...</option>
		            		           </c:if>
		            		           
                                       <c:forEach items="${ liste_epreuves }" var="epreuve">
                                          <option value="<c:out value='${ epreuve.id }' />">${ epreuve.nom }</option>
                                       </c:forEach>
                                  </select>
							</div>
							
							<div class="form-group">
							  <label for="formGroupExampleInput">Valeur</label>
							  <input value="<c:out value='${ note.valeur }' />" type="text" class="form-control" name="valeur" placeholder="Enter le nom">
							</div>
							
							 <c:if test="${ note != null}">
			            			<button type="submit" class="btn btn-success">
									 	Modifier
									 </button>
			            	 </c:if>
							 <c:if test="${ note == null}">
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
 

               

           