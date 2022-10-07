<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Hello, world!</title>
</head>
<body>
	<h1 class="container">
		<h2 class="text-center">Tabel Mahasiswa</h2>
		<div class="w-50 mx-auto">
		<c:url var="addAction" value="/mahasiswa/add"></c:url>
			<form:form action="${addAction}" commandName="mahasiswa">
				<div class="mb-3">
					<form:label for="exampleInputEmail1" class="form-label" path="nim">NIM</form:label> 
					<form:input type="text" class="form-control" path="nim"></form:input>
				</div>
				<div class="mb-3">
					<form:label for="exampleInputPassword1" class="form-label" path="name">Nama</form:label>
					<form:input type="text" class="form-control" path="name"></form:input>
				</div>
				<div class="mb-3">
					<form:label for="exampleInputPassword1" class="form-label" path="alamat">Alamat</form:label>
					<form:input type="text" class="form-control" path="alamat"></form:input>
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form:form>
		</div>
		<c:if test="${!empty listMahasiswas}">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">No</th>
						<th scope="col">ID</th>
						<th scope="col">NIM</th>
						<th scope="col">Nama</th>
						<th scope="col">Alamat</th>
						<th scope="col">Prodi</th>
						<th scope="col">Edit</th>
						<th scope="col">Delete</th>
					</tr>
				</thead>
				<tbody>
					<%
					int count = 1;
					%>
					<c:forEach items="${listMahasiswas}" var="mahasiswa">
						<tr>
							<%
							request.setAttribute("count", count);
							%>
							<td><c:out value="${count}"/></td>
							<td>${mahasiswa.id}</td>
							<td>${mahasiswa.nim}</td>
							<td>${mahasiswa.name}</td>
							<td>${mahasiswa.alamat}</td>
							<c:forEach items="${mahasiswa.prodi}" var="p">
							<td>${p.name}</td>
							</c:forEach>
							<td><a href="<c:url value='/edit/${mahasiswa.id}' />"><button type="button" class="btn btn-primary"> Edit</button></a></td>
							<td><a href="<c:url value='/remove/${mahasiswa.id}' />"><button type="button" class="btn btn-primary"> Delete</button></a></td>
						</tr>
						<%
						count++;
						%>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<!-- Optional JavaScript; choose one of the two! -->

		<!-- Option 1: Bootstrap Bundle with Popper -->
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
			crossorigin="anonymous"></script>

		<!-- Option 2: Separate Popper and Bootstrap JS -->
		<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    -->
</body>
</html>