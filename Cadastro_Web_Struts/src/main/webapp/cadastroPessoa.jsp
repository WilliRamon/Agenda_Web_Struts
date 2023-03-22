<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="b"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="estilo.css">
<title>Agenda Web</title>
</head>
<body>

<h:form action="/cadastroPessoa.do">

	<h1>Cadastro de Pessoas</h1>
	
	<p hidden="hidden">
		<label for="id">ID</label>
		<input type="text" name="id" id="id" > 
<%-- 		value = "${ id }" --%>
	</p>
	
	<p>
		<label for="nome">Nome:</label>
		<input type="text" id="nome" class="nome" name="nome">
	</p>

	<p>
		<label for="idade">Idade:</label>
		<input type="number" id="idade" class="idade" name="idade">
	</p>

	<p>
		<label for="sexo">Sexo:</label>
			<select id="sexo" name="sexo">
				<option selected>Selecione um sexo:</option>
				<option value="1">Masculino</option>
				<option value="2">Feminino</option>
			</select>
	</p>
	
	<p>	
		<input type="submit" value="Inserir" id="inserir" name="acao" onclick="inserir()">
		<input type="submit" value="Alterar" id="alterar" name="acao">
		<input type="submit" value="Limpar" id="limpar" name="acao">
	</p>
	
</h:form>
	
	<c:if test="${ empty listaPessoas }">
		<p>Não há contatos na agenda</p>	
	</c:if>
	
	<c:if test="${ not empty listaPessoas }">
		
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Idade</th>
					<th>Sexo</th>
					<th>Data Cadastro</th>
					<th>Alterar</th>
					<th>Excluir</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ listaPessoas }" var="listaPessoa">
					<tr>
						<td>${ listaPessoa.id }</td>
						<td>${ listaPessoa.nome }</td>
						<td>${ listaPessoa.idade }</td>
						<td>${ listaPessoa.sexo }</td>
						<td><fmt:formatDate value="${ listaPessoa.dataCadastro }" pattern="dd/MM/yyy" /></td>
						<td>O</td>
						<td>X</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	
	<script src="js.js"></script>
</body>
</html>