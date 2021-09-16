
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
                        <h4 class="card-title mb-3">Liste des epreuves </h4>
                    </div>
                    <div class="table-responsive">
					    <table id="zero_config" class="table table-striped table-bordered no-wrap">
					        <thead>
					            <tr>
					                <th>Nom</th>
					                <th>Coef</th>
					                <th>Examen</th>
					                <th>Actions</th>
					            </tr>
					        </thead>
					        <tbody>
					          <c:forEach items="${ liste_epreuves }" var="epreuve">
						            <tr>
						              <td>${ epreuve.nom }</td>
						              <td>${ epreuve.coef }</td>
						              <td>${ epreuve.examen.nom }</td>
						              <td>
		                                <a href="editEp?id=<c:out value='${ epreuve.id }' />" class="btn btn-primary btn-sm btn-circle">
		                                	<i class="fa fa-pencil-alt" style="color: #fff"></i>
		                                </a>
		                                <a href="deleteEp?id=<c:out value='${ epreuve.id }' />" class="btn btn-danger btn-sm btn-circle">
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
								<c:if test="${ epreuve != null}">
			            			Formulaire modification
			            		</c:if>
								<c:if test="${ epreuve == null}">
		            				Formulaire d'Ajout
		            			</c:if>
							</h4>
					</caption>
					
                    <div class="mt-4 activity">
                        <c:if test="${ epreuve != null}">
							<form action="updateEp" method="post">
						</c:if>
						<c:if test="${ epreuve == null}">
							<form action="insertEp" method="post">
						</c:if>
						
							<c:if test="${ epreuve != null}">
								<input type="hidden" name="id" value="<c:out value='${ epreuve.id }' />" />
							</c:if>
							
							<div class="form-group">
							  <label for="formGroupExampleInput">Nom</label>
							  <input value="<c:out value='${ epreuve.nom }' />" type="text" class="form-control" name="nom" placeholder="Enter le nom">
							</div>
							
							<div class="form-group">
							  <label for="formGroupExampleInput">Coeficien</label>
							  <input value="<c:out value='${ epreuve.coef }' />" type="number" class="form-control" name="coef" placeholder="Enter le coef">
							</div>
							
							<div class="form-group">
							  <label class="mr-sm-2" for="inlineFormCustomSelect">Commission</label>
                                  <select name="idCo" class="custom-select mr-sm-2" id="inlineFormCustomSelect">
                                       
		            				   <option selected>Choisir...</option>
		            		           
                                       <c:forEach items="${ liste_commissions }" var="commission">
                                          <option value="<c:out value='${ commission.id }' />">${ commission.nom }</option>
                                       </c:forEach>
                                  </select>
							</div>
							
							<div class="form-group">
							  <label class="mr-sm-2" for="inlineFormCustomSelect">Examen</label>
                                  <select name="idEx" class="custom-select mr-sm-2" id="inlineFormCustomSelect">
                                       <c:forEach items="${ liste_examens }" var="examen">
                                          <option value="<c:out value='${ examen.id }' />">${ examen.nom }</option>
                                       </c:forEach>
                                  </select>
							</div>
							
							 <c:if test="${ epreuve != null}">
			            			<button type="submit" class="btn btn-success">
									 	Modifier
									 </button>
			            	 </c:if>
							 <c:if test="${ epreuve == null}">
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
 

               

           